package lx.com.kocoa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.FragmentFestPassListBinding

class FestPassListFragment : Fragment() {
    var _binding : FragmentFestPassListBinding? = null
    val binding get() = _binding!!
    var miniAdapter:MiniAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentFestPassListBinding.inflate(inflater, container, false)

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
        val layoutManager = LinearLayoutManager(MainActivity())
        binding.makepassList.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        miniAdapter = MiniAdapter()
        binding.makepassList.adapter = miniAdapter

        miniAdapter?.apply {
            GamesData.game1?.let { items.add(it) }
            GamesData.game2?.let { items.add(it) }
        }

        // 4. 아이템을 클릭했을 때 동작할 코드 넣어주기
        miniAdapter?.listener = object: OnMiniItemClickListener {
            override fun onItemClick(holder: MiniAdapter.ViewHolder, view: View?, position: Int) {
                miniAdapter?.apply {
                    val item = items.get(position)
                }
            }
        }
    }
}