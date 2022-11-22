package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lx.com.kocoa.databinding.ActivityQuizMainBinding

class QuizMainActivity : AppCompatActivity() {

    lateinit var binding: ActivityQuizMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbarBody = binding.toolbar4
        setSupportActionBar(toolbarBody)
        // 뒤로가기 버튼 생성
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.gameStartButton.setOnClickListener {

        }

    }
}