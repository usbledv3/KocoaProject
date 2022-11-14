package lx.com.kocoa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.FragmentJulyBinding
import lx.com.kocoa.databinding.FragmentJuneBinding

class JulyFragment : Fragment() {
    var _binding: FragmentJulyBinding? = null
    val binding get() = _binding!!

    var julyAdapter:MonthAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJulyBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    fun initView() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        val layoutManager = LinearLayoutManager(context)
        binding.julyList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        julyAdapter = MonthAdapter()
        binding.julyList.adapter = julyAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        julyAdapter?.apply {
            this.items.clear()
            this.items.add(
                MonthData(
                    "렛츠런파크 서울 여름 수국축제",
                    R.drawable.suguk_fes,
                    "2023.07.30 ~ 2023.08.21"
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