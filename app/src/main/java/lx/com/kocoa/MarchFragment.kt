package lx.com.kocoa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.FragmentMarchBinding

class MarchFragment : Fragment() {
    var _binding: FragmentMarchBinding? = null
    val binding get() = _binding!!

    var marchAdapter:MonthAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMarchBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    fun initView() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        val layoutManager = LinearLayoutManager(context)
        binding.marchList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        marchAdapter = MonthAdapter()
        binding.marchList.adapter = marchAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        marchAdapter?.apply {
            this.items.clear()
            this.items.add(
                MonthData(
                    "오크밸리 3D 라이팅쇼 '소나타오브라이트'",
                    R.drawable.oakbelly_fes,
                    "2023.1.1-12.31"
                )
            )
            this.items.add(
                MonthData(
                    "안성 남사당놀이",
                    R.drawable.namsadang_fes,
                    "2022.3.26-2022.11.26"
                )
            )
            this.items.add(
                MonthData(
                    "진도토요민속여행",
                    R.drawable.toyo_fes,
                    "2022.03.01 ~ 2022.12.31"
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