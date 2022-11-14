package lx.com.kocoa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.FragmentMayBinding
import lx.com.kocoa.databinding.FragmentNovemberBinding

class NovemberFragment : Fragment() {
    var _binding: FragmentNovemberBinding? = null
    val binding get() = _binding!!

    var novemberAdapter:MonthAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNovemberBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    fun initView() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        val layoutManager = LinearLayoutManager(context)
        binding.novemberList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        novemberAdapter = MonthAdapter()
        binding.novemberList.adapter = novemberAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        novemberAdapter?.apply {
            this.items.clear()
            this.items.add(
                MonthData(
                    "외계인 대축제",
                    R.drawable.alien_fes,
                    "2022.11.12 ~ 2022.11.13"
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