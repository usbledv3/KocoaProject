package lx.com.kocoa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_search.*
import lx.com.kocoa.databinding.FragmentAfterSearchBinding
import lx.com.kocoa.databinding.FragmentAprilBinding
import lx.com.kocoa.databinding.FragmentSearchBinding

class AfterSearchFragment : Fragment() {
    var _binding: FragmentAfterSearchBinding? = null
    val binding get() = _binding!!

    var searchAdapter:SearchAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAfterSearchBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    fun initView() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        val layoutManager = LinearLayoutManager(context)
        binding.searchList2.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        searchAdapter = SearchAdapter()
        binding.searchList2.adapter = searchAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        searchAdapter?.apply {
            this.items.clear()
            this.items.add(
                SearchData(
                    "2022 서울 빛초롱축제", R.drawable.festival1, "2022.12.16-12.31", "서울시 청계천"
                )
            )
            this.items.add(
                SearchData(
                    "2022 화천 산천어축제", R.drawable.hwachun_festival, "2022.1.7-1.29", "강원도 화천"
                )
            )
            this.items.add(
                SearchData(
                    "2022 노들섬 뮤직페스티벌", R.drawable.nodeul_fes, "2022.10.13-10.16", "서울시 노들섬"
                )
            )
        }

    }

}