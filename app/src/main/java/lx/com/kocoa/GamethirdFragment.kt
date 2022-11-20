package lx.com.kocoa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_gamethird.*
import lx.com.kocoa.databinding.FragmentGamethirdBinding


class GamethirdFragment : Fragment() {
    var _binding : FragmentGamethirdBinding? = null
    val binding get() = _binding!!
    var miniAdapter:MiniAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        _binding = FragmentGamethirdBinding.inflate(inflater,container,false)

        binding.answOButton.setOnClickListener{
            binding.whichIsAnsw.text = "정답은 O로 선택됨"
            SAppData.data11 = "O"
        }
        binding.answXButton.setOnClickListener {
            binding.whichIsAnsw.text = "정답은 X로 선택됨"
            SAppData.data11 = "X"
        }

        binding.makeOXbutton.setOnClickListener {
            val oxname = binding.OXname.text.toString()
            SAppData.data9 = oxname // SAppData에 ox퀴즈 이름 저장


            miniAdapter = MiniAdapter()
            miniAdapter?.apply {
                GamesData.game=MiniData("생성된 문제", binding.OXname.text.toString(), "OX퀴즈")
                val curActivity = activity as SHWMainActivity
                curActivity.replaceView(FestGameListFragment())
            }
        }

        return binding.root
    }

}