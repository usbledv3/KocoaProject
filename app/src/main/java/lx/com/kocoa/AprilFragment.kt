package lx.com.kocoa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.FragmentAprilBinding

class AprilFragment : Fragment() {
    var _binding: FragmentAprilBinding? = null
    val binding get() = _binding!!

    var monthAdapter:MonthAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAprilBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    fun initView() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        val layoutManager = LinearLayoutManager(context)
        binding.aprilList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        monthAdapter = MonthAdapter()
        binding.aprilList.adapter = monthAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        monthAdapter?.apply {
            this.items.clear()
            this.items.add(
                MonthData(
                    "광주비엔날레",
                    R.drawable.gwangju_fes,
                    "2023.04.07 ~ 2023.07.09"
                )
            )
            this.items.add(
                MonthData(
                    "광주비엔날레",
                    R.drawable.gwangju_fes,
                    "2023.04.07 ~ 2023.07.09"
                )
            )
            this.items.add(
                MonthData(
                    "광주비엔날레",
                    R.drawable.gwangju_fes,
                    "2023.04.07 ~ 2023.07.09"
                )
            )
            this.items.add(
                MonthData(
                    "광주비엔날레",
                    R.drawable.gwangju_fes,
                    "2023.04.07 ~ 2023.07.09"
                )
            )
            this.items.add(
                MonthData(
                    "광주비엔날레",
                    R.drawable.gwangju_fes,
                    "2023.04.07 ~ 2023.07.09"
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