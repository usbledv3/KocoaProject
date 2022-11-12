package lx.com.kocoa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.UiThread
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import lx.com.kocoa.databinding.FragmentFestmapBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class FestMapFragment : Fragment(), OnMapReadyCallback {
    var _binding : FragmentFestmapBinding? = null
    val binding get() = _binding!!
    var mapx : String? = null
    var mapy : String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFestmapBinding.inflate(inflater, container, false)

        mapx="127.703225"
        mapy="38.107433"
        initView()

        //네이버 api키 입력
        val APIKEY_ID = "mu07smaqre"
        val APIKEY = "83iOebzNdf31Co6RiJxXXQm7rYFGXKNHMxw8aXzM"
        //레트로핏 객체 생성
        val retrofit = Retrofit.Builder().
        baseUrl("https://naveropenapi.apigw.ntruss.com/").
        addConverterFactory(GsonConverterFactory.create()).
        build()

        val api = retrofit.create(NaverAPI::class.java)

        //지도 이동 클릭시
        binding.button9.setOnClickListener {
            //도로명주소 검색
            val callgetPath = api.getMap(APIKEY_ID, APIKEY, binding.editTextTextPersonName6.text)
            callgetPath.enqueue(object : Callback<MapResponse> {
                override fun onResponse(
                    call: Call<MapResponse>,
                    response: Response<MapResponse>
                ) {
                    mapx = response.body()?.addresses?.get(0)?.x
                    mapy = response.body()?.addresses?.get(0)?.y
                    initView()
                }

                override fun onFailure(call: Call<MapResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
        return binding.root
    }

    private fun initView() {
        val fm = childFragmentManager
        val mapFragment = fm.findFragmentById(R.id.map) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.map, it).commit()
            }
        //지도 출력
        mapFragment.getMapAsync(this)
    }

    @UiThread
    override fun onMapReady(naverMap: NaverMap) {
        //지도 카메라 위치 변경
        val cameraUpdate = CameraUpdate.scrollTo(LatLng(mapy!!.toDouble(), mapx!!.toDouble()))
        naverMap.moveCamera(cameraUpdate)
        naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_BUILDING, true)
        //지도 UI 변경
        val uiSettings = naverMap.uiSettings
        uiSettings.isTiltGesturesEnabled = false
    }
}