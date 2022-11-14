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
            miniAdapter = MiniAdapter()
            miniAdapter?.apply {
                this.items.add(MiniData("1번 문제", binding.quizQuestion.text.toString(), "객관식"))
                notifyDataSetChanged()
            }
        }
        return binding.root
    }
}