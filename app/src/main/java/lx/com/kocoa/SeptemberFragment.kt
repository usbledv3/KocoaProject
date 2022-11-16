package lx.com.kocoa

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.FragmentMayBinding
import lx.com.kocoa.databinding.FragmentSeptemberBinding

class SeptemberFragment : Fragment() {
    var _binding: FragmentSeptemberBinding? = null
    val binding get() = _binding!!

    var septemberAdapter:MonthAdapter? = null
    val septemberInfoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSeptemberBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    fun initView() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        val layoutManager = LinearLayoutManager(context)
        binding.septemberList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        septemberAdapter = MonthAdapter()
        binding.septemberList.adapter = septemberAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        septemberAdapter?.apply {
            this.items.clear()
            this.items.add(
                MonthData(
                    "이월드 가을축제 <인생꽃 사진관>",
                    R.drawable.eworld_fes,
                    "2022.9.17-2022.11.30",
                    "대구광역시 달서구 두류공원로 200"
                )
            )
            this.items.add(
                MonthData(
                    "휴애리 핑크뮬리 축제",
                    R.drawable.pinkmuli_fes,
                    "2022.9.15-2022.11.15",
                    "제주특별자치도 서귀포시 남원읍 신례동로 256"
                )
            )
            this.items.add(
                MonthData(
                    "벽초지수목원 가을꽃 국화축제",
                    R.drawable.bykcho_fes,
                    "2022.9.23-2022.11.20",
                    "경기도 파주시 광탄면 부흥로 242"
                )
            )
        }

        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
        septemberAdapter?.listener = object: OnMonthItemClickListener {
            override fun onItemClick(holder: MonthAdapter.ViewHolder?, view: View?, position: Int) {
                septemberAdapter?.apply {
                    val item = items.get(position)

                    AppDataYW.monthSelectedItem=item

                    activity?.let{
                        val septemberInfoIntent = Intent(it,MonthFestivalInfoActivity::class.java)
                        septemberInfoLauncher.launch(septemberInfoIntent)
                    }

                }
            }

        }
    }
}