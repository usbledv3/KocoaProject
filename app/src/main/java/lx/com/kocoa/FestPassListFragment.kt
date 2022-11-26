package lx.com.kocoa

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.FragmentFestPassListBinding

class FestPassListFragment : Fragment() {
    var _binding : FragmentFestPassListBinding? = null
    val binding get() = _binding!!
    var festAdapter:FestAdapter? = null
    val FestPassLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentFestPassListBinding.inflate(inflater, container, false)

        PfchkData.chk=2
        initList()

        binding.makepassbtn.setOnClickListener {
            val curActivity = activity as SHWMainActivity
            curActivity.replaceView(FestPassFragment())
        }
        return binding.root
    }
    fun initList() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        val layoutManager = LinearLayoutManager(activity)
        binding.makepassList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        festAdapter = FestAdapter()
        binding.makepassList.adapter = festAdapter

        festAdapter?.apply {
            this.items.add(FestManagerData("패스등록예시","","적용인원예시","적용기간예시","축제이름"))
            if(SAppData.data1!=null) {
                this.items.add(FestManagerData(SAppData.data1, "", SAppData.data3, SAppData.data4, SAppData.data5))
            }
        }

        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
        festAdapter?.listener = object:OnFestInforItemClickListener {
            override fun onItemClick(holder: FestAdapter.ViewHolder?, view: View?, position: Int) {
                festAdapter?.apply {
                    val item2 = items.get(position)

                    SAppData.selelctedItem = item2
                    activity?.let {
                        val FestPassIntent = Intent(it, FestPassFragment::class.java)
                        FestPassLauncher.launch(FestPassIntent)
                    }
                }
            }
        }
    }
}