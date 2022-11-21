package lx.com.kocoa

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.UiThread
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import kotlinx.android.synthetic.main.drawer_header.view.*
import lx.com.kocoa.SAppData.Companion.data12
import lx.com.kocoa.databinding.ActivityFestInforStatusBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.xml.datatype.DatatypeFactory.newInstance

class FestInforStatusActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var binding:ActivityFestInforStatusBinding
    lateinit var festMapFragment: FestMapFragment // 맵 띄우는거 땡겨올려고
    var mapx : String? = null
    var mapy : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFestInforStatusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        festMapFragment = FestMapFragment() // 맵 띄우기 위한 프래그먼트 사용


        //선택한 아이템 현황화면에 가져오는거
        SAppData.selelctedItem.apply {
            binding.showpassName.text = "패스이름 : ${SAppData.data1}"
            //binding.showpassSort.text = "패스종류 : ${SAppData.data2}"
            binding.showpassPerson.text = "패스인원 : ${SAppData.data3}"
            binding.showpassTime.text = "패스기간 : ${SAppData.data4}"
            binding.showfestName.text = "축제이름 : ${SAppData.data5}"
            binding.showfestRange.text = "축제규모 : ${SAppData.data6}"
            binding.showfestLocation.text = "개최지역 : ${SAppData.data7}"
            binding.showroadName.text = "개최지주소 : ${SAppData.data8}"
            binding.showQuizname.text = "미니게임 이름 : ${SAppData.data9}"
            binding.showQuizsort.text = "미니게임 종류 : ${SAppData.data10}"
            binding.showQuizansw.text = "미니게임 정답 : ${SAppData.data11}"
            binding.showPosterImage.setImageResource(R.drawable.festivalexpic)



        }

        apiOn()

        //뒤로가기버튼
        binding.backButton.setOnClickListener {
            finish()
        }
    }

    private fun apiOn(){
        //네이버 api키 입력
        val APIKEY_ID = "mu07smaqre"
        val APIKEY = "83iOebzNdf31Co6RiJxXXQm7rYFGXKNHMxw8aXzM"
        //레트로핏 객체 생성
        val retrofit = Retrofit.Builder().
        baseUrl("https://naveropenapi.apigw.ntruss.com/").
        addConverterFactory(GsonConverterFactory.create()).
        build()

        val api = retrofit.create(NaverAPI::class.java)
        //도로명 주소로 위도 경도 받아오는거
        val callgetPath = SAppData.data8?.let { api.getMap(APIKEY_ID,APIKEY, it) }
        callgetPath?.enqueue(object: Callback<MapResponse> {
            override fun onResponse(call: Call<MapResponse>, response: Response<MapResponse>) {
                mapx = response.body()?.addresses?.get(0)?.x
                mapy = response.body()?.addresses?.get(0)?.y
                initView()
            }
            override fun onFailure(call: Call<MapResponse>, t: Throwable) {

            }
        })
    }
    private fun initView(){
        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.mapLayout) as MapFragment?
            ?:MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.mapLayout, it).commit()
            }
        //지도를 mapLayout에 보여줌
        mapFragment.getMapAsync(this)

    }

    @UiThread
    override fun onMapReady(naverMap: NaverMap){
        //위치로 지도 이동
        val cameraUpdate = CameraUpdate.scrollTo(LatLng(mapy!!.toDouble(), mapx!!.toDouble()))
        if (cameraUpdate != null){
            naverMap.moveCamera(cameraUpdate)
        }
    }


}