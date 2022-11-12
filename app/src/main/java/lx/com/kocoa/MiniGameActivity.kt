package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.ActivityMiniGameBinding

class MiniGameActivity : AppCompatActivity() {

    lateinit var binding: ActivityMiniGameBinding

    var miniGameAdapter:MiniGameAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMiniGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()

        initView()
    }

    fun initList() {

        val layoutManager = LinearLayoutManager(this)
        binding.miniGameList.layoutManager = layoutManager

        miniGameAdapter = MiniGameAdapter()
        binding.miniGameList.adapter = miniGameAdapter

        miniGameAdapter?.apply{
            this.items.add(MiniGameData(R.drawable.quiz,"축제 정보 퀴즈"))
            this.items.add(MiniGameData(R.drawable.minigame,"미니게임"))
        }
    }

    fun initView () {
        miniGameAdapter?.listener = object :OnMinigameItemClickListener{
            override fun ongameItemClick(holder: MiniGameAdapter.ViewHolder, view: View?, position: Int) {
                miniGameAdapter?.apply{
                    val item = items.get(position)
                    JhAppData.selectedGameItem = item

                }
            }
        }
    }


}