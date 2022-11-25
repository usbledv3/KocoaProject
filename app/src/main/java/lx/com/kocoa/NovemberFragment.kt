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
import lx.com.kocoa.databinding.FragmentMayBinding
import lx.com.kocoa.databinding.FragmentNovemberBinding

class NovemberFragment : Fragment() {
    var _binding: FragmentNovemberBinding? = null
    val binding get() = _binding!!

    var novemberAdapter:DoAdapter? = null
    val novemberInfoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }

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
        //val layoutManager = LinearLayoutManager(context)
        val layoutManager = GridLayoutManager(context,2, RecyclerView.VERTICAL,false)
        binding.novemberList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        novemberAdapter = DoAdapter()
        binding.novemberList.adapter = novemberAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        novemberAdapter?.apply {
            this.items.clear()
            this.items.add(
                DoData(
                    "외계인 대축제",
                    R.drawable.alien_fes,
                    "2022.11.12-2022.11.13",
                    "경상남도 밀양시 밀양대공원로 86"
                )
            )
            this.items.add(
                DoData(
                    "대한민국 우리술 대축제",
                    R.drawable.alcohol_fes,
                    "2022.11.18-2022.11.20",
                    "서울특별시 서초구 강남대로 27 AT센터"
                )
            )
            this.items.add(
                DoData(
                    "프로방스 크리스마스 산타마을 빛축제",
                    R.drawable.santa_fes,
                    "32022.11.12-2023.1.31",
                    "경상북도 청도군 화양읍 이슬미로 272-23"
                )
            )
        }

        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
        novemberAdapter?.listener = object: OnDoItemClickListener {
            override fun onDoItemClick(holder: DoAdapter.ViewHolder?, view: View?, position: Int) {
                novemberAdapter?.apply {
                    val item = items.get(position)

                    AppDataYW.doSelectedItem=item

                    activity?.let{
                        val novemberInfoIntent = Intent(it,SancheonuActivity::class.java)
                        novemberInfoLauncher.launch(novemberInfoIntent)
                    }

                }
            }

        }
    }
}