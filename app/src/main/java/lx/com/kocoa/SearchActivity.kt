package lx.com.kocoa

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    lateinit var binding: ActivitySearchBinding

    var searchAdapter:SearchAdapter? = null

    val searchInfoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()
    }

    fun initList() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        val layoutManager = LinearLayoutManager(this)
        binding.searchList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        searchAdapter = SearchAdapter()
        binding.searchList.adapter = searchAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        searchAdapter?.apply {
            this.items.add(SearchData("2022 서울 빛초롱축제", R.drawable.festival1,"2022.12.16-12.31", "서울시 청계천"))
            this.items.add(SearchData("2023 화천 산천어축제", R.drawable.hwachun_festival,"2023.1.7-1.29", "강원도 화천"))
            this.items.add(SearchData("2022 노들섬 뮤직페스티벌", R.drawable.nodeul_fes,"2022.10.13-10.16", "서울시 노들섬"))
        }

//        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
//        searchAdapter?.listner = object: OnSearchItemClickListner {
//            override fun onItemClick(holder: SearchAdapter.ViewHolder?, view: View?, position: Int) {
//                searchAdapter?.apply {
//                    val item = items.get(position)
//
//                    AppData.selectedItem = item
//
//                }
//
//            }
//
//        }

    }
}