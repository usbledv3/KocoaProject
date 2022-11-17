package lx.com.kocoa

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.FragmentFebruaryBinding


class FebruaryFragment : Fragment() {
    var _binding: FragmentFebruaryBinding? = null
    val binding get() = _binding!!

    var februaryAdapter:DoAdapter? = null
    val februaryInfoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFebruaryBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    fun initView() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        val layoutManager = LinearLayoutManager(context)
        binding.februaryList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        februaryAdapter = DoAdapter()
        binding.februaryList.adapter = februaryAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        februaryAdapter?.apply {
            this.items.clear()
            this.items.add(
                DoData(
                    "태안 빛축제",
                    R.drawable.teaan_fes,
                    "2023.1.1-12.31",
                    "충청남도 태안군 남면 마검포길 200"
                )
            )
            this.items.add(
                DoData(
                    "K-일러스트레이션페어 서울 2023",
                    R.drawable.illu_fes,
                    "2023.2.16-2023.2.19",
                    "서울특별시 강남구 영동대로 513 코엑스"
                )
            )
            this.items.add(
                DoData(
                    "강진청자축제",
                    R.drawable.gangjin_fes,
                    "2023.2.1-2.15",
                    "전라남도 강진군 대구면 청자촌길 8-3"
                )
            )
        }

        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
        februaryAdapter?.listener = object: OnDoItemClickListener {
            override fun onDoItemClick(holder: DoAdapter.ViewHolder?, view: View?, position: Int) {
                februaryAdapter?.apply {
                    val item = items.get(position)

                    AppDataYW.doSelectedItem=item

                    activity?.let{
                        val februaryInfoIntent = Intent(it, SancheonuActivity::class.java)
                        februaryInfoLauncher.launch(februaryInfoIntent)
                    }

                }
            }

        }
    }
}