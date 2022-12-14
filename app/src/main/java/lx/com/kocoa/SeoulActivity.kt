package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lx.com.kocoa.databinding.ActivitySeoulBinding

class SeoulActivity : AppCompatActivity() {
    lateinit var binding: ActivitySeoulBinding

    var seoulAdapter:DoAdapter? = null

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
        //val layoutManager = LinearLayoutManager(this)
        val layoutManager = GridLayoutManager(this,2, RecyclerView.VERTICAL,false)
        binding.seoulList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        seoulAdapter = DoAdapter()
        binding.seoulList.adapter = seoulAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        seoulAdapter?.apply {
            this.items.clear()
            this.items.add(DoData("2022 서울 빛초롱축제", R.drawable.festival1,"2022.12.16-12.31", "서울특별시 종로구 세종대로 172 "))
            this.items.add(DoData("펫츠런 고양", R.drawable.petsrun_fes,"2022.12.02-2022.12.03", "경기도 고양시 일산동구 중앙로 1271-4"))
            this.items.add(DoData("서울커피페스티벌", R.drawable.seoulcoffee_fes,"2022.11.23-2022.11.26", "서울특별시 강남구 영동대로 (513, 코엑스)"))
            if(SAppData.data5!=null) {
                this.items.add(DoData(SAppData.data5.toString(), R.drawable.festivalexpic, SAppData.data4.toString(), SAppData.data8.toString()))
            }
        }

        seoulAdapter?.listener = object: OnDoItemClickListener {
            override fun onDoItemClick(holder: DoAdapter.ViewHolder?, view: View?, position: Int) {
                seoulAdapter?.apply {
                    val item = items.get(position)
                    AppDataYW.doSelectedItem=item
                    val seoulInfoIntent = Intent(applicationContext, SancheonuActivity::class.java)
                    seoulInfoLauncher.launch(seoulInfoIntent)
                }
            }
        }

    }
}