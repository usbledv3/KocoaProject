package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.ActivityReviewBinding

class ReviewActivity : AppCompatActivity() {
    lateinit var binding: ActivityReviewBinding

    var reviewAdapter: ReviewAdapter? = null

    val customerInfoLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()

        initView()
    }

    fun initView() {
        //추가 버튼 눌렀을때
        binding.addButton.setOnClickListener {
            //입력상자에서 글자 가져오기

            val title = binding.titleInput.text.toString()
            val date = binding.dateInput.text.toString()
            val name = binding.nameInput.text.toString()
            val text = binding.textInput.text.toString()

            reviewAdapter?.apply {
                items.add(ReviewData(R.drawable.dragon,title, date, name, text))
                notifyDataSetChanged()
            }


        }

    }

    fun initList() {

        val layoutManager = LinearLayoutManager(this)
        binding.festivalList.layoutManager = layoutManager

        reviewAdapter = ReviewAdapter()
        binding.festivalList.adapter = reviewAdapter

        reviewAdapter?.apply {

            this.items.add(ReviewData(R.drawable.dragon,"빛초롱 축제 잘 즐기고 갑니다", "2020-02-08", "정익환",
                "청계천에서 열리는 빛초롱 축제입니다. 등 작품 하나하나 디테일하며, 특히 전통적인 그림과 한국의 색이 뚜렷한 작품들이 많아서 만족했습니다." +
                        "외국인들에게 많은 홍보가 된다면 보다 더 서울 관광에 도움이 될거 같습니다. "))

            this.items.add(ReviewData(R.drawable.dragon2,"빛초롱 축제에 대한 소감이에요~", "2021-02-08", "성희우",
                "조형물도 많고, 지루하지 않게 애니메이션 캐릭터와 동화 캐릭터도 있어서 아이들도 좋아할것 같아요. " +
                        "남산타워 등의 랜드마크도 있고 위에 설치된 물고기와 청사초롱도 예뻤어요."))


            this.items.add(ReviewData(R.drawable.dragon3,"산천어", "2021-01-02", "김주희",
                "주말에는 지역 주민들이 카니발 행사에 몰려 들기 때문에 주말에는 더욱 혼잡 해져서 평일 방문하는 것이 가장 좋습니다. " +
                        "여유롭게 산책을하면서 길을 따라 사진을 찍을 때 약 1 시간 만에 랜턴 페스티벌 (약 2km로 추정)의 전체 거리를 커버 할 수 있습니다. "))

        }


    }


}