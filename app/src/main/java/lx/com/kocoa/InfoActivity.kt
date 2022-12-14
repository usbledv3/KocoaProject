package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.lx.list.PointAppData
import lx.com.kocoa.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {

    lateinit var binding : ActivityInfoBinding

    val userLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback {
            showToast("수정하고 돌아옴")
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.renameButton.setOnClickListener {
            if(binding.nameInfo.text.toString() == "") {
                showToast("빈칸없이 작성하세요")
            } else {
                PointAppData.data1 = binding.nameInfo.text.toString()
                val userIntent = Intent(applicationContext, MyPageActivity::class.java)
                userLauncher.launch(userIntent)
                showToast("회원정보 수정완료")
            }
        }

        binding.nownick.text = "현재 아이디 : ${PointAppData.data1}"

        binding.nbackButton.setOnClickListener {
            showToast("취소를 누르셨습니다")
            finish()
        }

    }
    fun showToast(message:String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}