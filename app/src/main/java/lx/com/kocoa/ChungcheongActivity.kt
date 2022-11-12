package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.ActivityChungcheongBinding
import lx.com.kocoa.databinding.ActivityGangwonBinding

class ChungcheongActivity : AppCompatActivity() {
    lateinit var binding: ActivityChungcheongBinding

    var chungcheongAdapter:ChungcheongAdapter? = null

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
        val layoutManager = LinearLayoutManager(this)
        binding.chungcheongList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        chungcheongAdapter = ChungcheongAdapter()
        binding.chungcheongList.adapter = chungcheongAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        chungcheongAdapter?.apply {
            this.items.add(ChungcheongData("제2회 피나클랜드 국화축제", R.drawable.guckhwa_fes,"2022.09.23-2022.11.27", "충남 아산시"))
            this.items.add(ChungcheongData("피나클랜드 왕새우 축제", R.drawable.shrimp_fes,"2022.10.01-2022.11.30", "충남 아산시"))
            this.items.add(ChungcheongData("태안 빛축제", R.drawable.teaan_fes,"2021.01.0-2023.12.31", "충남 태안군"))
        }

//        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
//        chungcheongAdapter?.listner = object: OnChungcheongItemClickListner {
//            override fun onItemClick(holder: ChungcheongAdapter.ViewHolder?, view: View?, position: Int) {
//                chungcheongAdapter?.apply {
//                    val item = items.get(position)
//
//                    AppData.chungcheongSelectedItem = item
//
//                }
//
//            }
//
//        }

    }
}