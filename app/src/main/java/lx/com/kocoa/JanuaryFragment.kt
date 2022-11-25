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
import lx.com.kocoa.databinding.FragmentJanuaryBinding


class JanuaryFragment : Fragment() {

    var _binding: FragmentJanuaryBinding? = null
    val binding get() = _binding!!

    var januaryAdapter:DoAdapter? = null
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
        //val layoutManager = LinearLayoutManager(context)
        val layoutManager = GridLayoutManager(context,2, RecyclerView.VERTICAL,false)
        binding.januaryList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        januaryAdapter = DoAdapter()
        binding.januaryList.adapter = januaryAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        januaryAdapter?.apply {
            this.items.clear()
            this.items.add(DoData("2023 화천 산천어축제", R.drawable.sanchun_fes,"2023.1.7-1.29","강원도 화천군 화천읍 산천어길 137"))
            this.items.add(DoData("포항국제사진제 PIFF", R.drawable.piff_fes,"2023.1.19-2023.1.30","경상북도 포항시 남구 희망대로 850(대도동)"))
            this.items.add(DoData("별빛정원우주 365일 별빛축제", R.drawable.byul_fes,"2022.1.1-2022.12.31","경기도 이천시 마장면 덕이로154번길 287-76"))
            this.items.add(DoData("퍼스트가든 빛축제", R.drawable.firstgarden,"2022.01.01-2022.12.31","경기도 파주시 탑삭골길 260"))
            this.items.add(DoData("부산국제광고제", R.drawable.adver_fes,"2022.1.1-2022.12.31","부산광역시 해운대구 APEC로 55(우동)"))
            this.items.add(DoData("수원화성의 비밀", R.drawable.suwon_2,"2022.1.1-2022.12.31","경기도 수원시 팔달구 행궁로 11"))
        }

        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
        januaryAdapter?.listener = object: OnDoItemClickListener {
            override fun onDoItemClick(holder: DoAdapter.ViewHolder?, view: View?, position: Int) {
                januaryAdapter?.apply {
                    val item = items.get(position)

                    AppDataYW.doSelectedItem=item

                    activity?.let{
                        val januaryInfoIntent = Intent(it,SancheonuActivity::class.java)
                        januaryInfoLauncher.launch(januaryInfoIntent)
                    }

                }
            }

        }
    }

}