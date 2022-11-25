package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lx.com.kocoa.databinding.ActivityChungcheongBinding

class ChungcheongActivity : AppCompatActivity() {
    lateinit var binding: ActivityChungcheongBinding

    var chungcheongAdapter:DoAdapter? = null

    val chungcheongInfoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChungcheongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()
    }

    fun initList() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        //val layoutManager = LinearLayoutManager(this)
        val layoutManager = GridLayoutManager(this,2, RecyclerView.VERTICAL,false)
        binding.chungcheongList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        chungcheongAdapter = DoAdapter()
        binding.chungcheongList.adapter = chungcheongAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        chungcheongAdapter?.apply {
            this.items.clear()
            this.items.add(DoData("피나클랜드 국화축제", R.drawable.guckhwa_fes,"2022.09.23-2022.11.27", "충청남도 아산시 월선길 20-42"))
            this.items.add(DoData("피나클랜드 왕새우 축제", R.drawable.shrimp_fes,"2022.10.01-2022.11.30", "충청남도 아산시 월선길 20-42"))
            this.items.add(DoData("태안 빛축제", R.drawable.teaan_fes,"2021.01.0-2023.12.31", "충청남도 태안군 남면 마검포길 200"))
        }

        chungcheongAdapter?.listener = object: OnDoItemClickListener {
            override fun onDoItemClick(holder: DoAdapter.ViewHolder?, view: View?, position: Int) {
                chungcheongAdapter?.apply {
                    val item = items.get(position)
                    AppDataYW.doSelectedItem=item
                    val chungcheongInfoIntent = Intent(this@ChungcheongActivity,SancheonuActivity::class.java)
                    chungcheongInfoLauncher.launch(chungcheongInfoIntent)
                }
            }

        }

    }
}