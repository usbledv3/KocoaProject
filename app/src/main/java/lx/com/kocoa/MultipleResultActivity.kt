package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lx.com.kocoa.databinding.ActivityMultipleGameBinding
import lx.com.kocoa.databinding.ActivityMultipleResultBinding

class MultipleResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMultipleResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultipleResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val score = intent.getIntExtra("score", 0)
        val totalSize = intent.getIntExtra("totalSize", 0)

        //점수 보여주기
        binding.scoreText.text = getString(R.string.count_label, score, totalSize)

        //다시하기 버튼
        binding.resetBtn.setOnClickListener {
            val intent = Intent(this@MultipleResultActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}