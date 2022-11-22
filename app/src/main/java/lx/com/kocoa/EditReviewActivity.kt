package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.fragment_festpass.*
import lx.com.kocoa.databinding.ActivityEditReviewBinding
import lx.com.kocoa.databinding.ActivityReviewBinding

class EditReviewActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditReviewBinding

    private val list = ArrayList<ReviewData>()

    val reviewData = ReviewData()
    val reviewAdapter = ReviewAdapter()

    val editReviewlauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.editReviewTitleInput.setText(AppDataYW.reviewSelectedItem?.title)

        AppDataYW.reviewSelectedItem?.apply {
            binding.editReviewTitleInput.setText(this.title).toString()
        }
        val title = reviewData.title
        binding.editReviewTitleInput.setText(reviewData.title)

//        val title = AppDataYW.reviewSelectedItem?.title


        binding.updateButton.setOnClickListener {
            val title = binding.editReviewTitleInput.text.toString()
            val date = binding.editReviewDateInput.text.toString()
            val name = binding.editReviewNameInput.text.toString()
            val text = binding.editReviewTextInput.text.toString()
//            reviewData.title = title
//            reviewData.date = date
//            reviewData.name = name
//            reviewData.text = text

            reviewAdapter?.apply {
                items.clear()
                items.add(ReviewData(title, date, name, text))
                this.notifyItemInserted(items.size)
            }

            val editReviewIntent = Intent(this@EditReviewActivity,ReviewActivity::class.java)
            editReviewlauncher.launch(editReviewIntent)

        }

    }
}