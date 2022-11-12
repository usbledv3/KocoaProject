package lx.com.kocoa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lx.com.kocoa.databinding.FragmentGamefirstBinding
import lx.com.kocoa.databinding.FragmentGamesecondBinding

class GamesecondFragment : Fragment() {
    var _binding : FragmentGamesecondBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentGamesecondBinding.inflate(inflater, container, false)
        return binding.root
    }
}