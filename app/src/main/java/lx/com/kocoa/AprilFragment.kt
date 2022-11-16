package lx.com.kocoa

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.FragmentAprilBinding

class AprilFragment : Fragment() {
    var _binding: FragmentAprilBinding? = null
    val binding get() = _binding!!

    var aprilAdapter:MonthAdapter? = null
    val aprilInfoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }

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
        aprilAdapter = MonthAdapter()
        binding.aprilList.adapter = aprilAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        aprilAdapter?.apply {
            this.items.clear()
            this.items.add(
                MonthData(
                    "광주비엔날레",
                    R.drawable.gwangju_fes,
                    "2023.4.7-2023.7.9",
                    "광주광역시 북구 비엔날레로 111"
                )
            )
            this.items.add(
                MonthData(
                    "근현대사 추리여행, '사라진 열쇠를 찾아라'",
                    R.drawable.detective_fes,
                    "2022.4.23-2022.12.31",
                    "서울특별시 강북구 삼양로 561"
                )
            )
            this.items.add(
                MonthData(
                    "정선아리랑극 아리아라리",
                    R.drawable.ari_fes,
                    "2022.4.02-2022.11.27",
                    "강원도 정선군 정선읍 애산로 51"
                )
            )
        }

        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
        aprilAdapter?.listener = object: OnMonthItemClickListener {
            override fun onItemClick(holder: MonthAdapter.ViewHolder?, view: View?, position: Int) {
                aprilAdapter?.apply {
                    val item = items.get(position)

                    AppDataYW.monthSelectedItem=item

                    activity?.let{
                        val aprilInfoIntent = Intent(it,MonthFestivalInfoActivity::class.java)
                        aprilInfoLauncher.launch(aprilInfoIntent)
                    }

                }
            }

        }
    }
}