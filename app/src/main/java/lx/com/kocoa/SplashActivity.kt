package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class SplashActivity : AppCompatActivity() {


    var anim_FadeIn: Animation? = null
    var anim_ball: Animation? = null
    var constraintLayout: ConstraintLayout? = null
    var kocoaMainImageView: ImageView? = null
    var kocoaLineImageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        constraintLayout = findViewById(R.id.constraintLayout)
        kocoaMainImageView = findViewById(R.id.kocoaMain)
        kocoaLineImageView = findViewById(R.id.kocoaLine)

        anim_FadeIn = AnimationUtils.loadAnimation(this,R.anim.anim_splash_fadein)
        anim_ball = AnimationUtils.loadAnimation(this,R.anim.anim_splash_ball)

        kocoaMainImageView?.startAnimation(anim_ball)
        kocoaLineImageView?.startAnimation(anim_FadeIn)

        Handler().postDelayed({
            val intent = Intent(this,MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            finish()
        }, 3000)
    }
}