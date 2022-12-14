package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lx.com.kocoa.databinding.ActivityJunraBinding

class JunraActivity : AppCompatActivity() {
    lateinit var binding: ActivityJunraBinding

    var junraAdapter:DoAdapter? = null

    val junraInfoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJunraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()
    }

    fun initList() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        //val layoutManager = LinearLayoutManager(this)
        val layoutManager = GridLayoutManager(this,2, RecyclerView.VERTICAL,false)
        binding.junraList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        junraAdapter = DoAdapter()
        binding.junraList.adapter = junraAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        junraAdapter?.apply {
            this.items.clear()
            this.items.add(DoData("고창 청농원 라벤더 축제", R.drawable.gochang_fes,"2023.05.27-2023.06.30", "전라북도 고창군 공음면 청천길 41-27"))
            this.items.add(DoData("고흥유자석류축제", R.drawable.yuja_fes,"2022.11.10-2022.11.13", "전라남도 고흥군 풍양면 고흥로 1021"))
            this.items.add(DoData("해남미남 축제", R.drawable.heanam_fes,"2022.11.11 ~ 2022.11.13", "전라남도 해남군 삼산면 구림큰길 32-61"))
        }

        junraAdapter?.listener = object: OnDoItemClickListener {
            override fun onDoItemClick(holder: DoAdapter.ViewHolder?, view: View?, position: Int) {
                junraAdapter?.apply {
                    val item = items.get(position)
                    AppDataYW.doSelectedItem=item
                    val junraInfoIntent = Intent(this@JunraActivity,SancheonuActivity::class.java)
                    junraInfoLauncher.launch(junraInfoIntent)
                }
            }
        }
    }
}