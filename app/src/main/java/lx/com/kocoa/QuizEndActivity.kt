package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lx.com.kocoa.databinding.ActivityQuizEndBinding

class QuizEndActivity : AppCompatActivity() {
    lateinit var binding: ActivityQuizEndBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizEndBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.gameEndButton.setOnClickListener {
            startActivity(Intent(this@QuizEndActivity, MiniGameActivity::class.java))
        }
    }
}