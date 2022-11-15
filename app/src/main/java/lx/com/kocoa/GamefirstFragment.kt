package lx.com.kocoa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lx.com.kocoa.databinding.FragmentGamefirstBinding

class GamefirstFragment : Fragment(){
    var _binding : FragmentGamefirstBinding? = null
    val binding get() = _binding!!
    var miniAdapter:MiniAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentGamefirstBinding.inflate(inflater, container, false)
        
        
        //문제 생성 버튼 클릭
        binding.makequizbtn.setOnClickListener {
            val quizName = binding.quizQuestion.text.toString()
            SAppData.data9 = quizName//SAppData에 저장

            miniAdapter = MiniAdapter()
            miniAdapter?.apply {
                GamesData.game=MiniData("1번 문제", binding.quizQuestion.text.toString(), "객관식")
                val curActivity = activity as SHWMainActivity
                curActivity.replaceView(FestGameListFragment())
            }


            //정답 체크할때 inforstatus에 들어갈 값 넣는 곳
            binding.radiocase1.setOnClickListener {
                selectAnsw(0)
            }
            binding.radiocase2.setOnClickListener {
                selectAnsw(1)
            }
            binding.radiocase3.setOnClickListener {
                selectAnsw(2)
            }
            binding.radiocase4.setOnClickListener {
                selectAnsw(3)
            }

        }
        return binding.root
    }
    fun selectAnsw(index:Int){
        when(index){
            0 -> { SAppData.data11 = "1번" }
            1 -> { SAppData.data11 = "2번" }
            2 -> { SAppData.data11 = "3번" }
            3 -> { SAppData.data11 = "4번" }
        }
    }
}