package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MenuItem
import android.widget.TextView
import lx.com.kocoa.databinding.ActivityQuizMainBinding

class QuizMainActivity : AppCompatActivity() {

    lateinit var binding: ActivityQuizMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbarBody = binding.qqtoolbar4
        setSupportActionBar(toolbarBody)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.gameStartButton.setOnClickListener {
           startActivity(Intent(this@QuizMainActivity, QuizGameActivity::class.java))

        }


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean { //툴바 뒤로가기버튼 활성화
        when (item.getItemId()) {
            android.R.id.home -> {
                //toolbar의 back키 눌렀을 때 동작
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}