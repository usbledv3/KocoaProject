package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.ActivityReviewBinding
import lx.com.kocoa.databinding.AlertdialogEditBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ReviewActivity : AppCompatActivity() {
    lateinit var binding: ActivityReviewBinding

//    private var reviewAdapter: ReviewAdapter? = null

    val reviewlauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

    }

    // var list = ArrayList<ReviewData>()

    init{
        instance = this
    }

    companion object{
        private var instance: ReviewActivity? = null
        fun getInstance():ReviewActivity?{
            return instance
        }
    }

    val now = LocalDateTime.now()
    val formatDate = DateTimeFormatter.ISO_DATE
    val nowDate = now.format(formatDate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        reviewAdapter!!.items=list

        binding.dateToday.text=nowDate

        //initList()

        initView()

    }

    fun initView() {

        //추가 버튼 눌렀을때
        binding.addButton.setOnClickListener {
            //입력상자에서 글자 가져오기
            val title = binding.titleInput.text.toString()
            val date = nowDate
            val name = binding.nameInput.text.toString()
            val text = binding.textInput.text.toString()

            ReviewManagerData.titleofReview = title
            ReviewManagerData.dateofReview = date
            ReviewManagerData.nameofReview = name
            ReviewManagerData.textofReview = text

            AppDataYW.reviewTitle = title
            AppDataYW.reviewDate = date
            AppDataYW.reviewName = name
            AppDataYW.reviewText = text


            AppDataYW.reviewAdapter?.apply {
                items.add(ReviewData(title, date, name, text))
                this.notifyItemInserted(items.size)
                notifyDataSetChanged()
            }
//            val reviewIntent = Intent(this@ReviewActivity,SancheonuActivity::class.java)
//            reviewlauncher.launch(reviewIntent)

            finish()
            showToast("리뷰가 등록되었습니다.")
        }

    }

//    fun initList() {
//
//        val layoutManager = LinearLayoutManager(this)
//        binding.ReviewList.layoutManager = layoutManager
//
//        reviewAdapter = ReviewAdapter()
//        binding.ReviewList.adapter = reviewAdapter
//
//        reviewAdapter?.apply {
//
//            this.items.add(ReviewData("산천어 축제 잘 즐기고 갑니다", "2020-02-08", "정익환",
//                "산천어 축제 즐길거리가 많아서 좋았어요. 특히 버블 슈트 체험은 아이들이 너무 좋아했어요!!"))
//
//            this.items.add(ReviewData("산천어 축제에 대한 소감이에요~", "2021-02-08", "성희우",
//                "주말에는 지역 주민들이 행사에 몰려 들기 때문에 주말에는 더욱 혼잡 해져서 평일 방문하는 것이 가장 좋습니다."))
//
//            this.items.add(ReviewData("산천어", "2021-01-02", "김주희",
//                "사전 예약시스템으로 미리 예약을 하고 가니까 인기 많은 산천어 맨손잡기 체험을 바로 해볼 수 있어서 좋았습니다."))
//
//        }
//
//
//    }

    fun showToast(message:String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


}