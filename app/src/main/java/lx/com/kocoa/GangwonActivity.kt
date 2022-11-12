package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.ActivityGangwonBinding
import lx.com.kocoa.databinding.ActivitySeoulBinding

class GangwonActivity : AppCompatActivity() {
    lateinit var binding: ActivityGangwonBinding

    var gangwonAdapter:GangwonAdapter? = null

    val gangwonInfoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGangwonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()
    }

    fun initList() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        val layoutManager = LinearLayoutManager(this)
        binding.gangwonList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        gangwonAdapter = GangwonAdapter()
        binding.gangwonList.adapter = gangwonAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        gangwonAdapter?.apply {
            this.items.add(GangwonData("화천산천어축제", R.drawable.hwachun_festival,"2023.1.7-1.29", "강원 화천군"))
            this.items.add(GangwonData("제8회 고니골빛축제", R.drawable.gony_fes,"2022.11.19-2023.02.05", "강원 원주시"))
            this.items.add(GangwonData("제34회 춘천인형극제", R.drawable.doll_fes,"2022.04.01-2022.12.31", "강원 춘천시"))
        }

        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
        gangwonAdapter?.listener = object: OnGangwonItemClickListener {
            override fun onItemClick(holder: GangwonAdapter.ViewHolder?, view: View?, position: Int) {
                gangwonAdapter?.apply {
                    val item = items.get(position)

                    AppDataYW.gangwonSelectedItem = item
                    startActivity(Intent(this@GangwonActivity,SancheonuActivity::class.java))
                }

            }

        }

    }
}