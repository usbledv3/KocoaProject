package lx.com.kocoa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_gamefirst.*
import lx.com.kocoa.databinding.FragmentGamefirstBinding

class GamefirstFragment : Fragment(){
    var _binding : FragmentGamefirstBinding? = null
    val binding get() = _binding!!
    var miniAdapter:MiniAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentGamefirstBinding.inflate(inflater, container, false)
        val radioGp = binding.RadioGp

        
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


            if(radiocase1.isChecked){
                SAppData.data11 = "1번"
            }else if(radiocase2.isChecked){
                SAppData.data11 = "2번"
            }else if(radiocase3.isChecked){
                SAppData.data11 = "3번"
            }else if(radiocase4.isChecked){
                SAppData.data11 = "4번"
            }


        }
        return binding.root
    }

}