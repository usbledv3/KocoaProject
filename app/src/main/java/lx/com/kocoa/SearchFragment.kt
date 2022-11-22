package lx.com.kocoa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    var _binding: FragmentSearchBinding? = null
    val binding get() = _binding!!

    var searchAdapter:SearchAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    fun initView() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        val layoutManager = LinearLayoutManager(context)
        binding.searchList1.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        searchAdapter = SearchAdapter()
        binding.searchList1.adapter = searchAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        searchAdapter?.apply {
            this.items.clear()
            this.items.add(
                SearchData(
                    "마노르블랑 핑크뮬리축제", R.drawable.pinkmuli_fes,"2021.09.13-11.30", "제주도 서귀포시 안덕면 일주서로"
                )
            )
            this.items.add(
                SearchData(
                    "펫츠런(Pets Run) 고양",
                    R.drawable.petsrun_fes,
                    "2021.12.2-12.3",
                    "경기도 고양시 일산동구 중앙로 1271-4"
                )
            )
            this.items.add(
                SearchData(
                    "숲 속 모두의, 포레포레",
                    R.drawable.fore_fes,
                    "2021.8.27-11.26",
                    "경기도 수원시 권선구 서둔로 166"
                )
            )
            this.items.add(
                SearchData(
                    "태안 빛축제",
                    R.drawable.teaan_fes,
                    "2023.1.1-12.31",
                    "충청남도 태안군 남면 마검포길 200"
                )
            )
            this.items.add(
                SearchData(
                    "강릉단오제",
                    R.drawable.dano_fes,
                    "2022.5.30-2022.6.6",
                    "강원도 강릉시 단오장길 1"
                )
            )
        }

    }
}