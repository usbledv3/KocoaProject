package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lx.com.kocoa.databinding.ActivityBusanBinding

class BusanActivity : AppCompatActivity() {
    lateinit var binding: ActivityBusanBinding

    var doAdapter:DoAdapter? = null

    val busanInfoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBusanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()
    }

    fun initList() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        //val layoutManager = LinearLayoutManager(this)
        val layoutManager = GridLayoutManager(this,2, RecyclerView.VERTICAL,false)
        binding.busanList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        doAdapter = DoAdapter()
        binding.busanList.adapter = doAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        doAdapter?.apply {
            this.items.clear()
            this.items.add(DoData("별바다부산 나이트페스타", R.drawable.busan_festival,"2022.10.01-2022.11.13", " 부산광역시 영도구 맛자랑길 63(청학동)"))
            this.items.add(DoData("부산국제매직페스티벌", R.drawable.magic_fes,"2022.06.01-2022.11.13", "부산광역시 남구 못골번영로71번길 74 부산예술대학"))
            this.items.add(DoData("청송사과축제", R.drawable.apple_fes,"2022.11.09-2022.11.13", "경상북도 청송군 청송읍 군청로 13-7"))
        }

        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
        doAdapter?.listener = object: OnDoItemClickListener {
            override fun onDoItemClick(holder: DoAdapter.ViewHolder?, view: View?, position: Int) {
                doAdapter?.apply {
                    val item = items.get(position)
                    AppDataYW.doSelectedItem=item
                    val busanInfoIntent = Intent(this@BusanActivity,SancheonuActivity::class.java)
                    busanInfoLauncher.launch(busanInfoIntent)
                }
            }

        }

    }
}