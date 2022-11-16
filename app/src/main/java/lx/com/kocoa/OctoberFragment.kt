package lx.com.kocoa

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.FragmentOctoberBinding
import lx.com.kocoa.databinding.FragmentSeptemberBinding

class OctoberFragment : Fragment() {
    var _binding: FragmentOctoberBinding? = null
    val binding get() = _binding!!

    var octoberAdapter:MonthAdapter? = null
    val octoberInfoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOctoberBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    fun initView() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        val layoutManager = LinearLayoutManager(context)
        binding.octoberList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        octoberAdapter = MonthAdapter()
        binding.octoberList.adapter = octoberAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        octoberAdapter?.apply {
            this.items.clear()
            this.items.add(
                MonthData(
                    "화담숲 가을 단풍 축제",
                    R.drawable.hwadam,
                    "2022.10.15-2022.11.13",
                    "경기도 광주시 도척윗로 278-1"
                )
            )
            this.items.add(
                MonthData(
                    "피나클랜드 왕새우 축제",
                    R.drawable.shrimp_fes,
                    "2022.10.01-2022.11.30",
                    "충청남도 아산시 월선길 20-42"
                )
            )
            this.items.add(
                MonthData(
                    "신산 빛의거리",
                    R.drawable.sinsan_fes,
                    "2022.10.23-2022.11.28",
                    "제주특별자치도 제주시 고마로5길 5"
                )
            )
        }

        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
        octoberAdapter?.listener = object: OnMonthItemClickListener {
            override fun onItemClick(holder: MonthAdapter.ViewHolder?, view: View?, position: Int) {
                octoberAdapter?.apply {
                    val item = items.get(position)

                    AppDataYW.monthSelectedItem=item

                    activity?.let{
                        val octoberInfoIntent = Intent(it,MonthFestivalInfoActivity::class.java)
                        octoberInfoLauncher.launch(octoberInfoIntent)
                    }

                }
            }

        }
    }
}