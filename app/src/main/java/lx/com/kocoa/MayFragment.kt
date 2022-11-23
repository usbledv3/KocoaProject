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
import lx.com.kocoa.databinding.FragmentMarchBinding
import lx.com.kocoa.databinding.FragmentMayBinding


class MayFragment : Fragment() {
    var _binding: FragmentMayBinding? = null
    val binding get() = _binding!!

    var mayAdapter:DoAdapter? = null
    val mayInfoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMayBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    fun initView() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        val layoutManager = GridLayoutManager(context,2, RecyclerView.VERTICAL,false)
        // val layoutManager = LinearLayoutManager(context)
        binding.mayList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        mayAdapter = DoAdapter()
        binding.mayList.adapter = mayAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        mayAdapter?.apply {
            this.items.clear()
            this.items.add(
                DoData(
                    "강원세계산림엑스포",
                    R.drawable.oakbelly_fes,
                    "2023.5.4-2023.6.6",
                    "강원도 고성군 토성면 잼버리로 244"
                )
            )
            this.items.add(
                DoData(
                    "강릉단오제",
                    R.drawable.dano_fes,
                    "2022.5.30-2022.6.6",
                    "강원도 강릉시 단오장길 1"
                )
            )
            this.items.add(
                DoData(
                    "서울거리공연 [구석구석 라이브]",
                    R.drawable.street_fes,
                    "2022.5.1-2022.12.31",
                    "서울특별시 마포구 연남로1길 55"
                )
            )
        }

        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
        mayAdapter?.listener = object: OnDoItemClickListener {
            override fun onDoItemClick(holder: DoAdapter.ViewHolder?, view: View?, position: Int) {
                mayAdapter?.apply {
                    val item = items.get(position)

                    AppDataYW.doSelectedItem=item

                    activity?.let{
                        val mayInfoIntent = Intent(it,SancheonuActivity::class.java)
                        mayInfoLauncher.launch(mayInfoIntent)
                    }

                }
            }

        }
    }
}