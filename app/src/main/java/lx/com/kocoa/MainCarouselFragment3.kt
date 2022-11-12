package lx.com.kocoa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lx.com.kocoa.databinding.FragmentMainCarousel2Binding
import lx.com.kocoa.databinding.FragmentMainCarousel3Binding


class MainCarouselFragment3 : Fragment() {
    var _binding: FragmentMainCarousel3Binding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainCarousel3Binding.inflate(inflater, container, false)

        binding.carouselImage3.setOnClickListener {

        }

        return binding.root
    }

}