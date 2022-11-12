package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.PathOverlay
import com.naver.maps.map.util.FusedLocationSource
import lx.com.kocoa.databinding.ActivityMylocaBinding
import lx.com.kocoa.pathData.Companion.pathstart
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MylocaActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var binding: ActivityMylocaBinding

    private lateinit var locationSource: FusedLocationSource
    private lateinit var naverMap: NaverMap

    var startx : String? = null
    var starty : String? = null
    var endx : String? = null
    var endy : String? = null

    var pathinfo : List<List<Double>>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMylocaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        locationSource = FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)
        val APIKEY_ID = "mu07smaqre"
        val APIKEY = "83iOebzNdf31Co6RiJxXXQm7rYFGXKNHMxw8aXzM"
        //레트로핏 객체 생성
        val retrofit = Retrofit.Builder().baseUrl("https://naveropenapi.apigw.ntruss.com/").
        addConverterFactory(GsonConverterFactory.create()).build()
        val api = retrofit.create(NaverAPI::class.java)

        val starting = RouteData.startpoint?.let { api.getMap(APIKEY_ID, APIKEY, it) }
        starting?.enqueue(object : Callback<MapResponse> {
            override fun onResponse(
                call: Call<MapResponse>,
                response: Response<MapResponse>
            ) {
                startx = response.body()?.addresses?.get(0)?.x
                starty = response.body()?.addresses?.get(0)?.y
                pathstart = "$startx,$starty"
            }
            override fun onFailure(call: Call<MapResponse>, t: Throwable) {
            }
        })

        val ending = RouteData.endpoint?.let { api.getMap(APIKEY_ID, APIKEY, it) }
        ending?.enqueue(object : Callback<MapResponse> {
            override fun onResponse(
                call: Call<MapResponse>,
                response: Response<MapResponse>
            ) {
                endx = response.body()?.addresses?.get(0)?.x
                endy = response.body()?.addresses?.get(0)?.y
                pathData.pathend = "$endx,$endy"
            }
            override fun onFailure(call: Call<MapResponse>, t: Throwable) {
            }
        })

        val callpath = pathstart?.let {
            pathData.pathend?.let { it1 ->
                api.getPath(APIKEY_ID, APIKEY,
                    it, it1
                )
            }
        }
        if (callpath != null) {
            callpath.enqueue(object : Callback<RouteResponse> {
                override fun onResponse(
                    call: Call<RouteResponse>,
                    response: Response<RouteResponse>
                ) {
                    pathinfo = response.body()?.route?.traoptimal?.get(0)?.path
                    pathinfo?.let {showToast(it.toString())}
//                    pathinfo?.apply {
//                        for (item in this) {
//                            RouteData.rt!!.add(item[0].toString()+","+item[1].toString())
//                        }
//                    }

                }
                override fun onFailure(call: Call<RouteResponse>, t: Throwable) {
                }
            })
        }

        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.Mylocamap) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.Mylocamap, it).commit()
            }
        //지도 출력
        mapFragment.getMapAsync(this)

        binding.button13.setOnClickListener {
            showToast(pathinfo.toString())
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        if (locationSource.onRequestPermissionsResult(requestCode, permissions,
                grantResults)) {
            if (!locationSource.isActivated) { // 권한 거부됨
                naverMap.locationTrackingMode = LocationTrackingMode.None
            }
            return
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap
        naverMap.locationSource = locationSource
        naverMap.locationTrackingMode = LocationTrackingMode.Follow
        val path = PathOverlay()
//        var finalRoute = rt?.toList()
//        if (finalRoute != null) {
//            path.coords = finalRoute
//        }
//        path.width = 30
//        path.map=naverMap
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}

