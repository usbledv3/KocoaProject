package lx.com.kocoa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lx.com.kocoa.databinding.FragmentFestgameBinding

class FestGameFragment : Fragment() {
    var _binding : FragmentFestgameBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFestgameBinding.inflate(inflater, container, false)

        binding.button5.setOnClickListener {
            onFragmentChanged(0)
            SAppData.data10 = "객관식"
        }
        binding.button6.setOnClickListener {
            onFragmentChanged(1)
            SAppData.data10 = "주관식"
        }
        return binding.root
    }

    fun onFragmentChanged(index: Int) {
        when(index) {
            0 -> {
                childFragmentManager.beginTransaction().replace(R.id.container2, GamefirstFragment()).commit()
            }
            1 -> {
                childFragmentManager.beginTransaction().replace(R.id.container2, GamesecondFragment()).commit()
            }
        }
    }
}