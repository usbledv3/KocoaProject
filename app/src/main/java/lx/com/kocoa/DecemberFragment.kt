package lx.com.kocoa

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lx.com.kocoa.databinding.FragmentDecemberBinding

class DecemberFragment : Fragment() {
    var _binding: FragmentDecemberBinding? = null
    val binding get() = _binding!!

    var decemberAdapter:DoAdapter? = null
    val decemberInfoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDecemberBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    fun initView() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        //val layoutManager = LinearLayoutManager(context)
        val layoutManager = GridLayoutManager(context,2, RecyclerView.VERTICAL,false)
        binding.decemberList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        decemberAdapter = DoAdapter()
        binding.decemberList.adapter = decemberAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        decemberAdapter?.apply {
            this.items.clear()
            this.items.add(
                DoData(
                    "2022 서울빛초롱축제",
                    R.drawable.bitchorong_fes,
                    "2022.12.16-2022.12.31",
                    "서울특별시 종로구 세종대로 172"
                )
            )
            this.items.add(
                DoData(
                    "서천 마량진항 해넘이·해돋이 축제",
                    R.drawable.sunrise_fes,
                    "2022.12.31-2023.1.1",
                    "충청남도 서천군 서인로 58"
                )
            )
            this.items.add(
                DoData(
                    "펫츠런(Pets Run) 고양",
                    R.drawable.petsrun_fes,
                    "2022.12.2-2022.12.3",
                    "경기도 고양시 일산동구 중앙로 1271-4"
                )
            )
            this.items.add(
                DoData(
                    "유성온천 크리스마스 축제",
                    R.drawable.daejun_fes,
                    "2022.12.02-2022.12.04",
                    "대전광역시 유성구 계룡로123번길 52"
                )
            )
            this.items.add(
                DoData(
                    "부산美아트페스티벌",
                    R.drawable.art_fes,
                    "2022.12.06-2022.12.07",
                    "부산광역시 해운대구 APEC로 55 벡스코"
                )
            )
            this.items.add(
                DoData(
                    "안성두메호수빙어축제",
                    R.drawable.ansung_fes,
                    "2022.12.24-2023.02.05",
                    "경기도 안성시 죽산면 두메호수로 90"
                )
            )
        }

        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
        decemberAdapter?.listener = object: OnDoItemClickListener {
            override fun onDoItemClick(holder: DoAdapter.ViewHolder?, view: View?, position: Int) {
                decemberAdapter?.apply {
                    val item = items.get(position)
                    AppDataYW.doSelectedItem=item
                    activity?.let{
                        val decemberInfoIntent = Intent(it, SancheonuActivity::class.java)
                        decemberInfoLauncher.launch(decemberInfoIntent)
                    }

                }
            }

        }
    }
}