package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.lx.list.PointAppData
import lx.com.kocoa.databinding.ActivityMyPageBinding

class MyPageActivity : AppCompatActivity() {
    lateinit var binding: ActivityMyPageBinding

    /*외부*/
    var qrCodeScan = QRCodeScan(this)
    var count = 0

    val pointLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback { }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*내부*/

        /* 회원정보수정 이동 */
        binding.infoButton.setOnClickListener {
            val infoIntent = Intent(applicationContext, InfoActivity::class.java)
            pointLauncher.launch(infoIntent)
        }

        //* 포인트샵 이동 *//*
        binding.pointshopButton.setOnClickListener {
            val pointIntent = Intent(applicationContext, PointShopActivity::class.java)
            pointLauncher.launch(pointIntent)
        }

        binding.infoView.setImageResource(R.drawable.digda)
        binding.infoText.text = "${PointAppData.data1}님 환영합니다!"

        // 화면실행시 스탬프 몇개인지? 1.0 -> 1개
        binding.ratingBar.rating = 0F

        // 스탬프
        binding.ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            binding.ntextView2.text = "${rating} 개"
        }

        // 스탬프 새로고침
        binding.stampButton.setOnClickListener {

            if (count == 0) {
                binding.ratingBar.rating = 1F
                binding.ntextView2.text = "1개"
                count += 1
            } else if (count == 1) {
                binding.ratingBar.rating = 2f
                binding.ntextView2.text = "2개"
                count += 1
            } else if (count == 2) {
                binding.ratingBar.rating = 3f
                binding.ntextView2.text = "3개"
                count += 1
            } else if (count == 3) {
                binding.ratingBar.rating = 4f
                binding.ntextView2.text = "4개"
                count += 1
            } else if (count == 4) {
                binding.ratingBar.rating = 5f
                binding.ntextView2.text = "5개"
                count += 1
            }
        }

        //* QR 촬영 버튼 눌렀을때 *//*
        binding.qrButton.setOnClickListener {
            qrCodeScan.startQRScan()
        }

    }

    //*함수*//*
    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

    }
}