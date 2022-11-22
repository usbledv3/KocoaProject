package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.ActivityReviewBinding
import lx.com.kocoa.databinding.AlertdialogEditBinding

class ReviewActivity : AppCompatActivity() {
    lateinit var binding: ActivityReviewBinding

    private var reviewAdapter: ReviewAdapter? = null

    val reviewlauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

    }

//    private val list:MutableList<ReviewData> = mutableListOf()
    private val list = ArrayList<ReviewData>()

    init{
        instance = this
    }

    companion object{
        private var instance: ReviewActivity? = null
        fun getInstance():ReviewActivity?{
            return instance
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        reviewAdapter=ReviewAdapter()
        reviewAdapter!!.items=list


        initList()

        initView()

//        reviewAdapter!!.setOnItemClickListener(object : ReviewAdapter.OnItemClickListener {
//            override fun onItemEditClick(data: ReviewData, pos: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onItemDeleteClick(data: ReviewData, pos: Int) {
//                reviewAdapter!!.reviewDataDelete(pos)
//                reviewAdapter!!.notifyItemRemoved(pos)
//                reviewAdapter!!.notifyItemRangeChanged(pos, list.size)
//            }
//        })

    }

    fun deleteReview(position: Int){
        list.removeAt(position)
        reviewAdapter?.notifyItemChanged(position)
    }

    fun editReview(position: Int, reviewData: ReviewData){

        val builder = AlertDialog.Builder(this)
        val builderItem = AlertdialogEditBinding.inflate(layoutInflater)
        val editTitle = builderItem.editReviewTitleOutput
//        val editProfile = builderItem.editReviewProfile
        val editDate = builderItem.editReviewDateOutput
        val editName = builderItem.editReviewNameOutput
        val editText = builderItem.editReviewTextOutput
        val dialogView = layoutInflater.inflate(R.layout.alertdialog_edit, null)

        builder.setTitle("리뷰 수정")
        builder.setView(dialogView)
            .setPositiveButton("OK"){ dialogInterface, i ->
                reviewData.title = editTitle.text.toString()
                reviewData.date = editDate.text.toString()
                reviewData.name = editName.text.toString()
                reviewData.text = editText.text.toString()
                list[position].title = reviewData.title
                list[position].date = reviewData.date
                list[position].name = reviewData.name
                list[position].text = reviewData.text
            /* 확인일 때 main의 View의 값에 dialog View에 있는 값을 적용 */
            }
            .show()
//        with(builder){
//            setTitle("리뷰 수정")
////                setMessage("")
//            setView(builderItem.root)
//            setPositiveButton("OK") { _: DialogInterface, _: Int ->
//
//                if(list.size != 0) {
//                    reviewData.title = editTitle.text.toString()
//                    reviewData.date = editDate.text.toString()
//                    reviewData.name = editName.text.toString()
//                    reviewData.text = editText.text.toString()
//                    println("수정됨")
//                    Log.d("태그", "리뷰ㄴ")
//                    list[position] = reviewData
//                    reviewData!!.text?.let { Log.d("", it) }
//                    Log.d("태그", "리뷰ㄴ")
//                    //reviewAdapter?.notifyItemChanged(position)
//                    reviewAdapter?.notifyItemRangeChanged(position, 1)
//                }
//            }
//            show()
//        }
    }

    fun initView() {
        //추가 버튼 눌렀을때
        binding.addButton.setOnClickListener {
            //입력상자에서 글자 가져오기

            val title = binding.titleInput.text.toString()
            val date = binding.dateInput.text.toString()
            val name = binding.nameInput.text.toString()
            val text = binding.textInput.text.toString()

            ReviewManagerData.titleofReview = title
            ReviewManagerData.dateofReview = date
            ReviewManagerData.nameofReview = name
            ReviewManagerData.textofReview = text

            reviewAdapter?.apply {
                items.add(ReviewData(title, date, name, text))
                this.notifyItemInserted(items.size)
            }


        }

    }

    fun initList() {

        val layoutManager = LinearLayoutManager(this)
        binding.ReviewList.layoutManager = layoutManager

        reviewAdapter = ReviewAdapter()
        binding.ReviewList.adapter = reviewAdapter

        reviewAdapter?.apply {

            this.items.add(ReviewData("산천어 축제 잘 즐기고 갑니다", "2020-02-08", "정익환",
                "산천어 축제 즐길거리가 많아서 좋았어요. 특히 버블 슈트 체험은 아이들이 너무 좋아했어요!!"))

            this.items.add(ReviewData("산천어 축제에 대한 소감이에요~", "2021-02-08", "성희우",
                "주말에는 지역 주민들이 행사에 몰려 들기 때문에 주말에는 더욱 혼잡 해져서 평일 방문하는 것이 가장 좋습니다."))

            this.items.add(ReviewData("산천어", "2021-01-02", "김주희",
                "사전 예약시스템으로 미리 예약을 하고 가니까 인기 많은 산천어 맨손잡기 체험을 바로 해볼 수 있어서 좋았습니다."))

        }


    }


}