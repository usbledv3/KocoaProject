package lx.com.kocoa

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lx.com.kocoa.databinding.FragmentFestGameListBinding
import lx.com.kocoa.databinding.FragmentFestgameBinding

class FestGameListFragment : Fragment() {
    var _binding : FragmentFestGameListBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFestGameListBinding.inflate(inflater, container, false)

        binding.minicreatebtn.setOnClickListener {
            val curActivity = activity as SHWMainActivity
            curActivity.replaceView(FestGameFragment())
        }
        return binding.root
    }
}