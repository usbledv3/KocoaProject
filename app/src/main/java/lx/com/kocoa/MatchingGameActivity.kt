package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import lx.com.kocoa.databinding.ActivityMatchingGameBinding

class MatchingGameActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMatchingGameBinding

    // 버튼 리스트
    private val buttons: Array<ImageButton?> = arrayOfNulls<ImageButton>(8)

    // 이미지 리스트
    private lateinit var imageList: ArrayList<Int>

    // 카드 리스트
    private lateinit var cards: ArrayList<MatchingGameCard>

    // 결과 텍스트
    private lateinit var resultText: TextView

    // 이전 카드 위치
    private var preCardPosition: Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchingGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.matchEndButton.setOnClickListener {
            startActivity(Intent(this@MatchingGameActivity,MiniGameActivity::class.java))
        }

        // 초기화
        resultText = findViewById(R.id.resultText)
        val resetButton: Button = findViewById(R.id.resetButton)
        binding.resetButton.setOnClickListener {

            // 셋팅
            init()
        }

        // 셋팅
        init()

    }

    // 셋팅 함수
    private fun init() {
        // 이미지 리스트 초기화
        imageList = ArrayList()

        // 카드 리스트 초기화
        cards = ArrayList()

        // 리스트에 데이터 등록
        imageList.add(R.drawable.fish)
        imageList.add(R.drawable.shark)
        imageList.add(R.drawable.starfish)
        imageList.add(R.drawable.dolphin)
        imageList.add(R.drawable.fish)
        imageList.add(R.drawable.shark)
        imageList.add(R.drawable.starfish)
        imageList.add(R.drawable.dolphin)

        // 순서 섞기
        imageList.shuffle()

        for ((index, item) in buttons.withIndex()) {

            // 버튼 아이디
            val buttonId = "imageButton${index}"

            // 리소스 아이디
            val resource: Int = resources.getIdentifier(buttonId, "id", packageName)

            // 버튼 초기화
            buttons[index] = findViewById(resource)

            // 각 버튼에 클릭 이벤트 적용
            buttons[index]?.setOnClickListener(this)

            // 카드 리스트에 데이터 담기
            cards.add(MatchingGameCard(imageList[index], false, false))

            //  버튼에 기본 이미지 변경
            buttons[index]?.setImageResource(R.drawable.question)

            // 선명도 설정
            buttons[index]?.alpha = 1.0f
        }
    }

    // 클릭 이벤트
    override fun onClick(view: View?) {

        // view id 가져오기
        val id: Int? = view?.id

        // 위치 변수
        var position: Int = 0

        when (id) {
            R.id.imageButton0 -> position = 0
            R.id.imageButton1 -> position = 1
            R.id.imageButton2 -> position = 2
            R.id.imageButton3 -> position = 3
            R.id.imageButton4 -> position = 4
            R.id.imageButton5 -> position = 5
            R.id.imageButton6 -> position = 6
            R.id.imageButton7 -> position = 7
        }

        // 업데이트 모델
        updateModel(position)

        // 업데이트 뷰
        updateView(position)

    }

    // 업데이트 모델
    private fun updateModel(position: Int) {

        var card: MatchingGameCard = cards[position]

        // 나중에 카드 비교할 때 뒤집고 다시 클릭하는거 방지
        if (card.isFaceUp) {
            Toast.makeText(this, "이미 뒤집었습니다.", Toast.LENGTH_SHORT).show()
            return
        }

        // 뒤집힌 카드: 이전에 뒤집힌 카드 0 또는 2개일 때
        if(preCardPosition == -1) {

            // 카드 초기화
            restoreCard()

            // 위치저장
            preCardPosition = position
        } else { // 이전에 뒤집힌 카드 1개 일 때
            // 카드 비교
            checkForMatch(preCardPosition, position)
            preCardPosition = -1
        }

        // 반대의 값을 넣는다 앞면 -> 뒷면, 뒷면 -> 앞면
        cards[position].isFaceUp = !card.isFaceUp

    }

    // 업데이트 뷰
    private fun updateView(position: Int){

        var card: MatchingGameCard = cards[position]

        // 뒤집었다면 랜덤 이미지로 보여준다.
        if(card.isFaceUp){
            buttons[position]?.setImageResource(card.imageId)
        }else{
            // 기본 이미지
            buttons[position]?.setImageResource(R.drawable.question)
        }
    }

    // 카드 초기화
    private fun restoreCard(){
        for((index, item) in cards.withIndex()) {

            // 매치되지 않은 거
            if(!cards[index].isMatched){

                // 이미지 앞으로
                buttons[index]?.setImageResource(R.drawable.question)

                // 데이터 수정
                cards[index].isFaceUp = false
            }
        }
    }

    // 카드 이미지 비교
    // prePosition --> 이전 카드 위치
    // position --> 현재 카드 위치

    private fun checkForMatch(prePosition: Int, position: Int){

        // 처움 카드와 두 번째 카드 이미지가 같다면
        if(cards[prePosition].imageId == cards[position].imageId){

            resultText.text = "매치 성공"

            // 매치 변경
            cards[prePosition].isMatched = true
            cards[position].isMatched = true

            // 색상변경
            buttons[prePosition]?.alpha = 0.1f
            buttons[position]?.alpha = 0.1f

            // 완료 체크
            checkCompletion()
        }else{
            resultText.text="매치 실패"
        }

    }

    // 완료체크
    private  fun checkCompletion() {

        var count: Int = 0
        for((index, item) in cards.withIndex()){
            if(cards[index].isMatched){
                count++
            }
        }

        // 매치 갯수가 카드 갯수와 같다면 완료
        if(count == cards.size){
            resultText.text = "게임 끝"
        }
    }

}