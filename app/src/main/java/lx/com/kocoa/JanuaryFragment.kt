package lx.com.kocoa

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.FragmentJanuaryBinding


class JanuaryFragment : Fragment() {

    var _binding: FragmentJanuaryBinding? = null
    val binding get() = _binding!!

    var januaryAdapter:MonthAdapter? = null
    val januaryInfoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJanuaryBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    fun initView() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        val layoutManager = LinearLayoutManager(context)
        binding.januaryList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        januaryAdapter = MonthAdapter()
        binding.januaryList.adapter = januaryAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        januaryAdapter?.apply {
            this.items.clear()
            this.items.add(MonthData("2023 화천 산천어축제", R.drawable.hwachun_festival,"2023.1.7-1.29","강원도 화천군 화천읍 산천어길 137"))
            this.items.add(MonthData("포항국제사진제 PIFF", R.drawable.piff_fes,"2023.1.19-2023.1.30","경상북도 포항시 남구 희망대로 850(대도동)"))
            this.items.add(MonthData("별빛정원우주 365일 별빛축제", R.drawable.byul_fes,"2022.1.1-2022.12.31","경기도 이천시 마장면 덕이로154번길 287-76"))
        }

        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
        januaryAdapter?.listener = object: OnMonthItemClickListener {
            override fun onItemClick(holder: MonthAdapter.ViewHolder?, view: View?, position: Int) {
                januaryAdapter?.apply {
                    val item = items.get(position)

                    AppDataYW.monthSelectedItem=item

                    activity?.let{
                        val januaryInfoIntent = Intent(it,MonthFestivalInfoActivity::class.java)
                        januaryInfoLauncher.launch(januaryInfoIntent)
                    }

                }
            }

        }
    }

}