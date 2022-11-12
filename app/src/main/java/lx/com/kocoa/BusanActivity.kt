package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.ActivityBusanBinding
import lx.com.kocoa.databinding.ActivityGangwonBinding

class BusanActivity : AppCompatActivity() {
    lateinit var binding: ActivityBusanBinding

    var busanAdapter:BusanAdapter? = null

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
        val layoutManager = LinearLayoutManager(this)
        binding.busanList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        busanAdapter = BusanAdapter()
        binding.busanList.adapter = busanAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        busanAdapter?.apply {
            this.items.add(BusanData("별바다부산 나이트페스타", R.drawable.busan_festival,"2022.10.01-2022.11.13", "부산 영도구"))
            this.items.add(BusanData("부산국제매직페스티벌", R.drawable.magic_fes,"2022.06.01-2022.11.13", "부산 남구"))
            this.items.add(BusanData("청송사과축제", R.drawable.apple_fes,"2022.11.09-2022.11.13", "경북 청송군"))
        }

//        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
//        busanAdapter?.listner = object: OnBusanItemClickListner {
//            override fun onItemClick(holder: BusanAdapter.ViewHolder?, view: View?, position: Int) {
//                busandapter?.apply {
//                    val item = items.get(position)
//
//                    AppData.busanSelectedItem = item
//
//                }
//
//            }
//
//        }

    }
}