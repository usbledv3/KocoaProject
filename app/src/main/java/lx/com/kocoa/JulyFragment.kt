package lx.com.kocoa

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.FragmentJulyBinding
import lx.com.kocoa.databinding.FragmentJuneBinding

class JulyFragment : Fragment() {
    var _binding: FragmentJulyBinding? = null
    val binding get() = _binding!!

    var julyAdapter:DoAdapter? = null
    val julyInfoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }

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
        julyAdapter = DoAdapter()
        binding.julyList.adapter = julyAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        julyAdapter?.apply {
            this.items.clear()
            this.items.add(
               DoData(
                    "렛츠런파크 서울 여름 수국축제",
                    R.drawable.suguk_fes,
                    "2023.7.30-2023.8.21",
                    "경기도 과천시 경마공원대로 107"
                )
            )
            this.items.add(
                DoData(
                    "주문진 불꽃크루즈",
                    R.drawable.jumunjin_fes,
                    "2022.7.1-2022.12.31",
                    "강원도 강릉시 해안로 1730 강릉시수협"
                )
            )
            this.items.add(
                DoData(
                    "국제해양영화제",
                    R.drawable.seamovie_fes,
                    "2022.7.28-2022.7.31",
                    "부산광역시 해운대구 수영강변대로 120"
                )
            )
        }

        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
        julyAdapter?.listener = object: OnDoItemClickListener {
            override fun onDoItemClick(holder: DoAdapter.ViewHolder?, view: View?, position: Int) {
                julyAdapter?.apply {
                    val item = items.get(position)

                    AppDataYW.doSelectedItem=item

                    activity?.let{
                        val julyInfoIntent = Intent(it,SancheonuActivity::class.java)
                        julyInfoLauncher.launch(julyInfoIntent)
                    }

                }
            }

        }
    }
}