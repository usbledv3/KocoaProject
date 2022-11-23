package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lx.com.kocoa.databinding.ActivityInfoBinding
import lx.com.kocoa.databinding.ActivityManageReviewBinding

class ManageReview : AppCompatActivity() {
    lateinit var binding : ActivityManageReviewBinding

    var reviewAdapter:ReviewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManageReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initList()
        initView()
    }

    fun initView(){
            reviewAdapter?.apply {
                items.add(ReviewData(
                    ReviewManagerData.titleofReview,
                    ReviewManagerData.dateofReview,
                    ReviewManagerData.nameofReview,
                    ReviewManagerData.textofReview
                ))
            }
        }
    }
