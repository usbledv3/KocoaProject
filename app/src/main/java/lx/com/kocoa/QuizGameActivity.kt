package lx.com.kocoa

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_quiz_game.*
import lx.com.kocoa.databinding.ActivityQuizGameBinding
import java.util.*
import kotlin.system.measureTimeMillis

class QuizGameActivity : AppCompatActivity() {

    lateinit var binding: ActivityQuizGameBinding


    val mainLauncher = registerForActivityResult(

        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback {
        }
    )


    // 문제 수
    var qCount = 1

    // 포인트 점수
    var qPoint = 5000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 카운트다운
        val countDown = object : CountDownTimer(1000 * 6, 1000) {
            override fun onTick(p0: Long) {
                binding.countDown.text = (p0 / 1000).toString()
            }

            override fun onFinish() {
                qCount += 1
                quizChanged()
                finalQuiz()
            }
        }.start()


        binding.oButton.setOnClickListener {
            countDown.start()
            qCount += 1
            quizChanged()
        }

        binding.xButton.setOnClickListener {
            countDown.start()
            qCount += 1
            quizChanged()
        }

        binding.quizEndButton.setOnClickListener {

            // Alert창 띄우기
            val builder = AlertDialog.Builder(this)
            builder.setTitle("")
                .setMessage("획득한 포인트가 차감됩니다. 정말로 종료하시겠습니까?")
                .setPositiveButton(
                    "확인", DialogInterface.OnClickListener{ dialog, id->
                            startActivity(Intent(this@QuizGameActivity,MiniGameActivity::class.java))
                        showToast("게임이 취소되었습니다.")
                    })
                .setNegativeButton("취소",
                    DialogInterface.OnClickListener {dialog,id ->
                        countDown.start()
                    })
            // 다이얼로그를 띄워주기
            builder.show()

            // 카운트다운 일시 정지
            countDown.cancel()
        }


    }

    // qCount에 따라 다른 문제를 보여주는 함수
    fun quizChanged(){
        if(qCount == 2){
            // 정답 x
            binding.quizOutput.text = "산천어의 수명은 10년이다."
            binding.qNumber.text = "2/5"
            showToast("정답은 X 입니다.")
        }
        else if(qCount == 3) {
            // 정답 x
            binding.quizOutput.text = "산천어 축제가 열리는 곳은 강원도 평창군이다."
            binding.qNumber.text = "3/5"
            showToast("정답은 X 입니다.")
        }
        else if(qCount == 4) {
            // 정답 x
            binding.quizOutput.text = "산천어는 연어과이다."
            binding.qNumber.text = "4/5"
            showToast("정답은 X 입니다.")
        }
        else if(qCount == 5){
            // 정답 o
            binding.quizOutput.text = "산천어와 송어는 서로 같은 종이다"
            binding.qNumber.text = "5/5"
            showToast("정답은 O 입니다.")


            binding.oButton.setOnClickListener {
                if(qCount >= 5 ) {
                    val mainIntent = Intent(applicationContext, QuizEndActivity::class.java)
                    mainLauncher.launch(mainIntent)
                    showToast("모든 문제를 다 푸셨습니다.")

                }

            }

            binding.xButton.setOnClickListener {
                if(qCount >= 5){
                    val mainIntent = Intent(applicationContext, QuizEndActivity::class.java)
                    mainLauncher.launch(mainIntent)
                    showToast("모든 문제를 다 푸셨습니다.")

                }
            }

        }
    }

    // 마지막 문제를 풀었을 때 함수
    fun finalQuiz(){
        if(qCount == 6){
            showToast("모든 문제를 다 푸셨습니다.")

            val mainIntent = Intent(applicationContext, QuizEndActivity::class.java)
            mainLauncher.launch(mainIntent)

        }
    }


    // 정답을 맞췄을 때
    fun getPoint(){
        if(qCount == 2){

        }
    }
    fun showToast(message:String) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show()
    }
}

