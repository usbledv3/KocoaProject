package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.UiThread
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import lx.com.kocoa.databinding.ActivityFestivalInfoBinding
import lx.com.kocoa.databinding.ActivityMonthFestivalInfoBinding

import lx.com.kocoa.databinding.ActivitySancheonuBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MonthFestivalInfoActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var binding: ActivityMonthFestivalInfoBinding
    var mapx : String? = null
    var mapy : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMonthFestivalInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        AppDataYW.doSelectedItem?.let {
//            binding.fesImageView.setImageResource(it.doImage)
//            binding.fesDateView.text="기간 : "+it.doDate
//            binding.fesPlaceView.text="장소 : "+it.doPlace
//            binding.fesNameView.text=it.doName
//        }

        AppDataYW.monthSelectedItem?.apply {
            binding.monthFesImageView.setImageResource(this.mImage)
            binding.monthFesDateView.text = "기간 : ${this.mDate}"
            binding.monthFesPlaceView.text = "장소 : ${this.mPlace}"
            binding.monthFesNameView.text = "${this.mName}"
        }

        apiOn()

        binding.passbutton.setOnClickListener {
            startActivity(Intent(this@MonthFestivalInfoActivity,FespassActivity::class.java))
        }
        binding.reviewbtn.setOnClickListener {
            startActivity(Intent(this@MonthFestivalInfoActivity,ReviewActivity::class.java))
        }
        binding.minigamebtn.setOnClickListener {
            startActivity(Intent(this@MonthFestivalInfoActivity,MiniGameActivity::class.java))
        }
        binding.rtbtn.setOnClickListener {
            startActivity(Intent(this@MonthFestivalInfoActivity,RouteActivity::class.java))
        }
    }

    private fun apiOn() {
        //네이버 api키 입력
        val APIKEY_ID = "mu07smaqre"
        val APIKEY = "83iOebzNdf31Co6RiJxXXQm7rYFGXKNHMxw8aXzM"
        //레트로핏 객체 생성
        val retrofit = Retrofit.Builder().
        baseUrl("https://naveropenapi.apigw.ntruss.com/").
        addConverterFactory(GsonConverterFactory.create()).
        build()

        val api = retrofit.create(NaverAPI::class.java)
        //도로명 주소를 통해 위경도 값 받아오기
        val callgetPath = api.getMap(APIKEY_ID, APIKEY, SelectedDoData.selectedItem?.doPlace.toString())
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
    private fun initView() {
        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.map2) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.map2, it).commit()
            }
        //지도 출력
        mapFragment.getMapAsync(this)
    }

    @UiThread
    override fun onMapReady(naverMap: NaverMap) {
        //지정된 위치로 지도 위치 변경
        val cameraUpdate = CameraUpdate.scrollTo(LatLng(mapy!!.toDouble(), mapx!!.toDouble()))
        if (cameraUpdate != null) {
            naverMap.moveCamera(cameraUpdate)
        }
    }
}

