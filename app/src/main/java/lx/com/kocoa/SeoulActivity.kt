package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.ActivitySearchBinding
import lx.com.kocoa.databinding.ActivitySeoulBinding

class SeoulActivity : AppCompatActivity() {
    lateinit var binding: ActivitySeoulBinding

    var seoulAdapter:SeoulAdapter? = null

    val seoulInfoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeoulBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()
    }

    fun initList() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        val layoutManager = LinearLayoutManager(this)
        binding.seoulList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        seoulAdapter = SeoulAdapter()
        binding.seoulList.adapter = seoulAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        seoulAdapter?.apply {
            this.items.add(SeoulData("2022 서울 빛초롱축제", R.drawable.festival1,"2022.12.16-12.31", "서울 청계천"))
            this.items.add(SeoulData("2022 펫츠런 고양", R.drawable.petsrun_fes,"2022.12.02-2022.12.03", "경기 고양시"))
            this.items.add(SeoulData("서울커피페스티벌", R.drawable.seoulcoffee_fes,"2022.11.23-2022.11.26", "서울 강남구"))
        }

//        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
//        seoulAdapter?.listner = object: OnSeoulItemClickListner {
//            override fun onItemClick(holder: SeoulAdapter.ViewHolder?, view: View?, position: Int) {
//                seoulAdapter?.apply {
//                    val item = items.get(position)
//
//                    AppData.seoulSelectedItem = item
//
//                }
//
//            }
//
//        }

    }
}