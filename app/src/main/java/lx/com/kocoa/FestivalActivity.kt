package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.ActivityFestivalBinding

class FestivalActivity : AppCompatActivity() {
    lateinit var binding: ActivityFestivalBinding
    var fesAdapter:FestivalAdapter? = null
    val fesLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFestivalBinding.inflate(layoutInflater)
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
        binding.festivalList.layoutManager = layoutManager
        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        fesAdapter = FestivalAdapter()
        binding.festivalList.adapter = fesAdapter
        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        fesAdapter?.apply {
            this.items.add(FestivalData(R.drawable.jungsun, "정선아리랑제", "기간: 2022.09.15~09.18", "장소: 정선공설운동장 일대"))
            this.items.add(FestivalData(R.drawable.hanu, "횡성한우축제", "기간: 2022.09.30~10.04", "장소: 횡성종합운동장"))
            this.items.add(FestivalData(R.drawable.yunu, "2022 양양 연어축제", "기간: 2022.10.28~10.30", "장소: 양양군 남대천 둔치"))
        }
        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
        fesAdapter?.listener = object: OnFestivalItemClickListener {
            override fun onItemClick(holder: FestivalAdapter.ViewHolder?, view: View?, position: Int) {
                fesAdapter?.apply {
                    val item = items.get(position)
                    showToast("선택한 활동 : ${item.name}")
                    SelectedFesData.selectedItem = item
                }
            }
        }
    }
    fun showToast(message:String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}