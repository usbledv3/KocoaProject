package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.ActivityJejuBinding

class JejuActivity : AppCompatActivity() {
    lateinit var binding: ActivityJejuBinding

    var jejuAdapter:DoAdapter? = null

    val jejuInfoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJejuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()
    }

    fun initList() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        val layoutManager = LinearLayoutManager(this)
        binding.jejuList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        jejuAdapter = DoAdapter()
        binding.jejuList.adapter = jejuAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        jejuAdapter?.apply {
            this.items.clear()
            this.items.add(DoData("휴애리 동백축제", R.drawable.dongbek_fes,"2022.11.14-23.01.31", "제주특별자치도 서귀포시 남원읍 신례동로 256"))
            this.items.add(DoData("마노르블랑 핑크뮬리축제", R.drawable.pinkmuli_fes,"2022.09.13-2022.11.30", "제주특별자치도 서귀포시 안덕면 일주서로2100번길 46"))
            this.items.add(DoData("사계로 페스티벌", R.drawable.sagyero_fes,"2022.11.19-2022.11.19", "제주특별자치도 서귀포시 사계남로 202"))
        }

        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
        jejuAdapter?.listener = object: OnDoItemClickListener {
            override fun onDoItemClick(holder: DoAdapter.ViewHolder?, view: View?, position: Int) {
                jejuAdapter?.apply {
                    val item = items.get(position)

                    SelectedDoData.selectedItem=item
                    val jejuInfoIntent = Intent(this@JejuActivity,FestivalInfoActivity::class.java)
                    jejuInfoLauncher.launch(jejuInfoIntent)
                }

            }

        }

    }
}