package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.ActivityFespassBinding

class FespassActivity : AppCompatActivity() {
    lateinit var binding: ActivityFespassBinding
    var passitemAdapter:PassItemAdapter? = null
    val passBookingLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFespassBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //리스트 초기화
        initList()
        //뷰 초기화
        initView()
    }

    fun initView() {

    }

    fun initList() {
        // 1. 리스트의 모양을 담당하는 것
        // (아래쪽으로 아이템들이 보이는 것, GridLayoutManager : 격자 형태로 보이는 것)
        val layoutManager = LinearLayoutManager(this)
        binding.fespassList.layoutManager = layoutManager
        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        passitemAdapter = PassItemAdapter()
        binding.fespassList.adapter = passitemAdapter
        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        passitemAdapter?.apply {
            this.items.add(PassItemData(R.drawable.handfishing, "산천어 맨손낚시", 13000))
            this.items.add(PassItemData(R.drawable.bubblesuit, "버블슈트",10000))
            this.items.add(PassItemData(R.drawable.skyline, "하늘가르기",12000))
        }
        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
        passitemAdapter?.listener = object: OnPassItemClickListener {
            override fun onItemClick(holder: PassItemAdapter.ViewHolder?, view: View?, position: Int) {
                passitemAdapter?.apply {
                    val item = items.get(position)
                    showToast("선택한 활동 : ${item.name}")
                    SelectedPassData.selectedItem = item
                    val passbookingIntent = Intent(applicationContext, PassBookingActivity::class.java)
                    passBookingLauncher.launch(passbookingIntent)
                }
            }
        }
    }
    fun showToast(message:String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}