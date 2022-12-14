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

class MarchFragment : Fragment() {
    var _binding: FragmentMarchBinding? = null
    val binding get() = _binding!!

    var marchAdapter:DoAdapter? = null
    val marchInfoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMarchBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    fun initView() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        //val layoutManager = LinearLayoutManager(context)
        val layoutManager = GridLayoutManager(context,2, RecyclerView.VERTICAL,false)
        binding.marchList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        marchAdapter = DoAdapter()
        binding.marchList.adapter = marchAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        marchAdapter?.apply {
            this.items.clear()
            this.items.add(
                DoData(
                    "오크밸리 3D 라이팅쇼 '소나타오브라이트'",
                    R.drawable.oakbelly_fes,
                    "2023.1.1-12.31",
                    "강원도 원주시 지정면 오크밸리1길 66"
                )
            )
            this.items.add(
                DoData(
                    "안성 남사당놀이",
                    R.drawable.namsadang_fes,
                    "2022.3.26-2022.11.26",
                    "경기도 안성시 보개면 남사당로 198-2"
                )
            )
            this.items.add(
                DoData(
                    "진도토요민속여행",
                    R.drawable.toyo_fes,
                    "2022.03.01 ~ 2022.12.31",
                    "전라남도 진도군 진도읍 진도대로 7197"
                )
            )
        }

        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
        marchAdapter?.listener = object: OnDoItemClickListener {
            override fun onDoItemClick(holder: DoAdapter.ViewHolder?, view: View?, position: Int) {
                marchAdapter?.apply {
                    val item = items.get(position)

                    AppDataYW.doSelectedItem=item

                    activity?.let{
                        val marchInfoIntent = Intent(it,SancheonuActivity::class.java)
                        marchInfoLauncher.launch(marchInfoIntent)
                    }

                }
            }

        }
    }
}