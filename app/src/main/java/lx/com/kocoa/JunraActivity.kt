package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.ActivityChungcheongBinding
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
        val layoutManager = LinearLayoutManager(this)
        binding.junraList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        junraAdapter = DoAdapter()
        binding.junraList.adapter = junraAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        junraAdapter?.apply {
            this.items.clear()
            this.items.add(DoData("고창 청농원 라벤더 축제", R.drawable.gochang_fes,"2023.05.27-2023.06.30", "전북 고창군"))
            this.items.add(DoData("고흥유자석류축제", R.drawable.yuja_fes,"2022.11.10-2022.11.13", "전남 고흥군"))
            this.items.add(DoData("해남미남 축제", R.drawable.heanam_fes,"2022.11.11 ~ 2022.11.13", "전남 해남군"))
        }

        junraAdapter?.listener = object: OnDoItemClickListener {
            override fun onItemClick(holder: DoAdapter.ViewHolder?, view: View?, position: Int) {
                junraAdapter?.apply {
                    val item = items.get(position)
                    AppDataYW.doSelectedItem = item
                    SelectedDoData.selectedItem=item
                    startActivity(Intent(this@JunraActivity,SancheonuActivity::class.java))
                }
            }
        }
    }
}