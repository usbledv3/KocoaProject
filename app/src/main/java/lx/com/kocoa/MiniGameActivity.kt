package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.JhAppData.Companion.miniGameAdapter
import lx.com.kocoa.databinding.ActivityMiniGameBinding

class MiniGameActivity : AppCompatActivity() {

    lateinit var binding: ActivityMiniGameBinding


    val miniGameLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }
    val nnmainLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMiniGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()

        binding.nnBackButton.setOnClickListener {
            val nnmain = Intent(this, MainActivity::class.java)
            nnmainLauncher.launch(nnmain)
        }

    }

    fun initList() {
        // 리스트의 모양을 담당하는 것
        val layoutManager = LinearLayoutManager(this)
        binding.miniGameList.layoutManager = layoutManager

        // 어댑터를 설정하는 것
        miniGameAdapter = MiniGameAdapter()
        binding.miniGameList.adapter = miniGameAdapter

        // 아이템을 위한 데이터 넣기
        miniGameAdapter?.apply{
            this.items.add(MiniGameData(R.drawable.quiz,"OX퀴즈"))
            this.items.add(MiniGameData(R.drawable.minigame,"객관식 퀴즈"))
            this.items.add(MiniGameData(R.drawable.minigame,"카드 게임"))
        }

        // 아이템을 클릭했을 때 동작할 코드 넣어주기
        miniGameAdapter?.listener = object : OnMinigameItemClickListener {
            override fun onMiniGameItemClick(
                holder: MiniGameAdapter.ViewHolder, view: View?, position: Int) {
                miniGameAdapter?.apply {
                    val item = items.get(position)

                    JhAppData.selectedGameItem = item
                    startActivity(Intent(this@MiniGameActivity,MultipleGameActivity::class.java))

                }
            }
        }

    }

//    fun initView () {
//        miniGameAdapter?.listener = object :OnMinigameItemClickListener{
//            override fun ongameItemClick(holder: MiniGameAdapter.ViewHolder, view: View?, position: Int) {
//                miniGameAdapter?.apply{
//                    val item = items.get(position)
//                    JhAppData.selectedGameItem = item
//
//                    val miniIntent = Intent(applicationContext,QuizMainActivity::class.java)
//                    miniLauncher.launch(miniIntent)
//
//                }
//            }
//        }
//
//    }
//


}