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
import lx.com.kocoa.databinding.FragmentFebruaryBinding
import lx.com.kocoa.databinding.FragmentJuneBinding

class JuneFragment : Fragment() {
    var _binding: FragmentJuneBinding? = null
    val binding get() = _binding!!

    var juneAdapter:DoAdapter? = null
    val juneInfoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJuneBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    fun initView() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        //val layoutManager = LinearLayoutManager(context)
        val layoutManager = GridLayoutManager(context,2, RecyclerView.VERTICAL,false)
        binding.juneList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        juneAdapter = DoAdapter()
        binding.juneList.adapter = juneAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        juneAdapter?.apply {
            this.items.clear()
            this.items.add(
                DoData(
                    "고창 청농원 라벤더 축제",
                    R.drawable.gochang_fes,
                    "2023.5.27-2023.6.30",
                    "전라북도 고창군 공음면 청천길 41-27"
                )
            )
            this.items.add(
                DoData(
                    "목포해상W쇼",
                    R.drawable.mokpo_fes,
                    "2022.06.03-2022.11.26",
                    "전라남도 목포시 평화로 82"
                )
            )
            this.items.add(
                DoData(
                    "부산커피쇼",
                    R.drawable.coffee_fes,
                    "2022.6.29-2022.7.2",
                    "부산광역시 해운대구 APEC로 55"
                )
            )
        }

        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
        juneAdapter?.listener = object: OnDoItemClickListener {
            override fun onDoItemClick(holder: DoAdapter.ViewHolder?, view: View?, position: Int) {
                juneAdapter?.apply {
                    val item = items.get(position)

                    AppDataYW.doSelectedItem=item

                    activity?.let{
                        val juneInfoIntent = Intent(it,SancheonuActivity::class.java)
                        juneInfoLauncher.launch(juneInfoIntent)
                    }

                }
            }

        }
    }
}