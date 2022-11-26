package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.UiThread
import androidx.recyclerview.widget.LinearLayoutManager
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import kotlinx.android.synthetic.main.fragment_festpass.*
import lx.com.kocoa.ReviewManagerData.Companion.titleofReview
import lx.com.kocoa.databinding.ActivitySancheonuBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SancheonuActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var binding: ActivitySancheonuBinding
    var mapx : String? = null
    var mapy : String? = null
    val sancheonuInforlauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

    }
    var reviewAdapter: ReviewAdapter? = null
    var reviewData: ReviewData? = null
    var manageReviewAdapter:ManageReviewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySancheonuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppDataYW.doSelectedItem?.let {
            binding.imageView9.setImageResource(it.doImage)
            binding.import1.text="기간 : "+it.doDate
            binding.import3.text="장소 : "+it.doPlace
            binding.nameView.text=it.doName
        }

        initList()

        initReview()

        apiOn()

        binding.bookImage.setOnClickListener {
            startActivity(Intent(this@SancheonuActivity,FespassActivity::class.java))
        }
        binding.bookText.setOnClickListener {
            startActivity(Intent(this@SancheonuActivity,FespassActivity::class.java))
        }
        binding.reviewText.setOnClickListener {
            val sancheonuInfoIntent = Intent(this@SancheonuActivity,ReviewActivity::class.java)
            sancheonuInforlauncher.launch(sancheonuInfoIntent)
//            startActivity(Intent(this@SancheonuActivity,ReviewActivity::class.java))
        }
        binding.reviewImage.setOnClickListener {
            startActivity(Intent(this@SancheonuActivity,ReviewActivity::class.java))
        }
        binding.miniText.setOnClickListener {
            startActivity(Intent(this@SancheonuActivity,MiniGameActivity::class.java))
        }
        binding.miniImage.setOnClickListener {
            startActivity(Intent(this@SancheonuActivity,MiniGameActivity::class.java))
        }
        binding.rtbtn.setOnClickListener {
            startActivity(Intent(this@SancheonuActivity,RouteActivity::class.java))
        }
        binding.infobtn.setOnClickListener {
            startActivity(Intent(this@SancheonuActivity,MapActivity::class.java))
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
        val callgetPath = api.getMap(APIKEY_ID, APIKEY, AppDataYW.doSelectedItem?.doPlace.toString())
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
        naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_TRAFFIC, true)
    }

    fun initList() {

        val layoutManager = LinearLayoutManager(this)
        binding.readReviewList.layoutManager = layoutManager

        reviewAdapter = ReviewAdapter()
        binding.readReviewList.adapter = reviewAdapter

        reviewAdapter?.apply {

            this.items.add(ReviewData("산천어 축제 잘 즐기고 갑니다", "2020-02-08", "정익환",
                "산천어 축제 즐길거리가 많아서 좋았어요. 특히 버블 슈트 체험은 아이들이 너무 좋아했어요!!"))

            this.items.add(ReviewData("산천어 축제에 대한 소감이에요~", "2021-02-08", "성희우",
                "주말에는 지역 주민들이 행사에 몰려 들기 때문에 주말에는 더욱 혼잡 해져서 평일 방문하는 것이 가장 좋습니다."))

            this.items.add(ReviewData("산천어", "2021-01-02", "김주희",
                "사전 예약시스템으로 미리 예약을 하고 가니까 인기 많은 산천어 맨손잡기 체험을 바로 해볼 수 있어서 좋았습니다."))

        }


    }

    fun initReview(){
        binding.refreshReviewButton2.setOnClickListener {
//            var title = reviewData!!.title
//            var date = reviewData!!.date
//            var name = reviewData!!.name
//            var text = reviewData!!.text

            reviewAdapter?.apply {
                items.add(ReviewData(
                    AppDataYW.reviewTitle,
                    AppDataYW.reviewDate,
                    AppDataYW.reviewName,
                    AppDataYW.reviewText
                ))
                notifyDataSetChanged()
            }
        }
    }

}

