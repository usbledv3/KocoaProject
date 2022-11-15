package lx.com.kocoa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.FragmentAugustBinding

class AugustFragment : Fragment() {
    var _binding: FragmentAugustBinding? = null
    val binding get() = _binding!!

    var augustAdapter:MonthAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAugustBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    fun initView() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        val layoutManager = LinearLayoutManager(context)
        binding.augustList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        augustAdapter = MonthAdapter()
        binding.augustList.adapter = augustAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        augustAdapter?.apply {
            this.items.clear()
            this.items.add(
                MonthData(
                    "춘천막국수닭갈비축제",
                    R.drawable.chuncheon_fes,
                    "2023.8.30-2023.9.4",
                    "강원도 춘천시 스포츠타운길 245"
                )
            )
            this.items.add(
                MonthData(
                    "숲 속 모두의, 포레포레",
                    R.drawable.fore_fes,
                    "2022.8.27-2022.11.26",
                    "경기도 수원시 권선구 서둔로 166"
                )
            )
            this.items.add(
                MonthData(
                    "NewYork Arts Society Festival",
                    R.drawable.newyork_fes,
                    "2022.8.1-2022.12.31",
                    "서울시"
                )
            )
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