package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lx.com.kocoa.databinding.ActivityMatchingMainBinding

class MatchingMainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMatchingMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchingMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.matchingStartButton.setOnClickListener {
            startActivity(Intent(this@MatchingMainActivity,MatchingGameActivity::class.java))
        }

    }
}