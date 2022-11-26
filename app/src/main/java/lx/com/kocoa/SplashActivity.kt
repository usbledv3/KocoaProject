package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.annotation.UiThread
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // 일정 시간 지연 이후 실행하기 위한 코드
        Handler(Looper.getMainLooper()).postDelayed({

            // 일정 시간이 지나면 MainActivity로 이동
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // 이전 키를 눌렀을 때 스플래시 스크린 화면으로 이동을 방지하기 위하여
            // 이동한 다음 사용안함으로 finish 처리
            finish()
        }, 1000)  // 시간 2초 이후 실행

    }

}