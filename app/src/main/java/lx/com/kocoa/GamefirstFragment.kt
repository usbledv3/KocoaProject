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
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentGamefirstBinding.inflate(inflater, container, false)
        return binding.root
    }
}