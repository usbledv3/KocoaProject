package lx.com.kocoa

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_multiple_game.*
import kotlinx.android.synthetic.main.activity_multiple_game.view.*
import lx.com.kocoa.MultipleQuestionData.getQuestion
import lx.com.kocoa.databinding.ActivityMultipleGameBinding

class MultipleGameActivity : AppCompatActivity(), View.OnClickListener{

    private  lateinit var binding: ActivityMultipleGameBinding

    private var currentPosition: Int = 1 // 질문 위치
    private var selectedOption: Int = 0 // 선택 답변 값
    private var score: Int = 0 // 점수

    private lateinit var questionList: ArrayList<MultipleQuestion>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultipleGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 질문 리스트 가져오기
        questionList = MultipleQuestionData.getQuestion()

        // 화면 셋팅
        MultipleQuestionData()

        binding.option1.setOnClickListener(this)
        binding.option2.setOnClickListener(this)
        binding.option3.setOnClickListener(this)
        binding.option4.setOnClickListener(this)

        // 답변 체크 이벤트
        binding.submitButton.setOnClickListener {

            if(selectedOption != 0){

                val question = questionList[currentPosition-1]

                // 정답 체크(선택 답변과 정답을 비교)
                if(selectedOption != question.correctAnswer) { //오답

                    setColor(selectedOption, R.drawable.wrong_option_background)

                    callDialog("오답", "정답 ${question.correctAnswer}")
                }else{
                    score++
                }
                setColor(question.correctAnswer, R.drawable.correct_option_background)

                if(currentPosition == questionList.size) {
                    binding.submitButton.text = getString(R.string.submit, "끝")
                }else{
                    binding.submitButton.text = getString(R.string.submit,"다음")
                }

            }else{
                //위치값 상승
                currentPosition++
                when{
                    //전체 문제 숫자가 현재 위치보다 크면 다음 문제로 셋팅
                    currentPosition <= questionList.size -> {
                        //다음 문제 셋팅
                        getQuestion()
                    }

                    else ->{
                        //결과 액티비티로 넘어가는 코드
                        val intent = Intent(this@MultipleGameActivity,MultipleResultActivity::class.java)
                        intent.putExtra("score",score)
                        intent.putExtra("totalSize", questionList.size)
                        startActivity(intent)
                        finish()
                    }
                }
            }
            //선택값 초기화
            selectedOption = 0
        }
    }

    /**
     * 답변 배경색상 변경
     */
    private fun setColor(opt: Int, color: Int){
        when(opt){
            1 -> binding.option1.background = ContextCompat.getDrawable(this, color)
            2 -> binding.option2.background = ContextCompat.getDrawable(this, color)
            3 -> binding.option3.background = ContextCompat.getDrawable(this, color)
            4 -> binding.option4.background = ContextCompat.getDrawable(this, color)
        }
    }

    /**
     * 정답 확인 다이얼로그
     */
    private fun callDialog(alertTitle: String, correctAnswer: String){

        AlertDialog.Builder(this)
            .setTitle(alertTitle)
            .setMessage("정답: $correctAnswer")
            .setPositiveButton("OK"){
                    dialogInterface, i ->
                    dialogInterface.dismiss() //창 닫기
            }
            .setCancelable(false)
            .show()
    }

    // 문제 셋팅팅
   private fun MultipleQuestionData(){

        //답변 설정 초기화
        setOptionStyle()

        // 질문 변수에 담기
        val question = questionList[currentPosition-1]

        // 상태바 위치
        binding.progressBar.progress = currentPosition

        // 상태바 최대값
        binding.progressBar.max = questionList.size

        // 현재 위치 표시
        binding.progressText.text = getString(R.string.count_label,currentPosition,questionList.size)

        // 질문 표시
        binding.questionText.text = question.question

        // 답변표시
        binding.option1.text = question.option_one
        binding.option2.text = question.option_two
        binding.option3.text = question.option_three
        binding.option4.text = question.option_four

       setSubmitButton("제출")
    }

    // 제출버튼 텍스트 설정
    private fun setSubmitButton(name: String) {

        binding.submitButton.text = getString(R.string.submit,name)
    }

    // 답변 스타일 설정
    private fun setOptionStyle(){

        var optionList: ArrayList<TextView> = arrayListOf()
        optionList.add(binding.option1)
        optionList.add(binding.option2)
        optionList.add(binding.option3)
        optionList.add(binding.option4)

        // 답변 텍스트뷰 설정
        for(op in optionList){
            op.setTextColor(Color.parseColor("#555151"))
            op.background = ContextCompat.getDrawable(this, R.drawable.option_background)
            op.typeface = Typeface.DEFAULT
        }
    }

    // 답변 선택 이벤트
    private  fun selectOptionStyle(view: TextView, opt: Int){

        // 옵션 초기화
        setOptionStyle()

        // 위치 담기
        selectedOption = opt

        view.setTextColor((Color.parseColor("#555151")))
        view.background = ContextCompat.getDrawable(this, R.drawable.selected_option_background)
        view.typeface = Typeface.DEFAULT_BOLD
    }

    // 클릭 이벤트 재정의
    override fun onClick(view: View) {
        when(view.id){
            R.id.option1 -> selectOptionStyle(binding.option1,1)
            R.id.option2 -> selectOptionStyle(binding.option2,2)
            R.id.option3 -> selectOptionStyle(binding.option3,3)
            R.id.option4 -> selectOptionStyle(binding.option4,4)
        }
    }

}