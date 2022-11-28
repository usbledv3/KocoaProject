package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_all_game.*
import lx.com.kocoa.databinding.ActivityAllGameBinding

class AllGameActivity : AppCompatActivity() {

    lateinit var binding: ActivityAllGameBinding

    lateinit var rotationAnimation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.minigameMain.startAnimation(rotationAnimation)

    }
}


