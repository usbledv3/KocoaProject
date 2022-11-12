package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.ActivityRankingBinding

class RankingActivity : AppCompatActivity() {

    lateinit var binding: ActivityRankingBinding

    var rankAdapter:RankAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRankingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()

        initView()
    }

    fun initList() {

        val layoutManager = LinearLayoutManager(this)
        binding.rankList.layoutManager = layoutManager

        rankAdapter = RankAdapter()
        binding.rankList.adapter = rankAdapter

        rankAdapter?.apply {
            this.items.add(RankData(R.drawable.one,"도치토치또치","1,000,000"))
            this.items.add(RankData(R.drawable.two,"공간정보9기","990,000"))
            this.items.add(RankData(R.drawable.three,"막자는내가해","950,000"))
            this.items.add(RankData(R.drawable.four,"ㅇㅇㅇ님","800,000"))
        }
    }

    fun initView() {
        rankAdapter?.listener = object :OnRankItemClickListener{
            override fun onRankItemClick(holder: RankAdapter.ViewHolder, view: View?, position: Int) {
                rankAdapter?.apply {
                    val item = items.get(position)
                    JhAppData.selectedRankItem = item
                }
            }
        }
    }
}