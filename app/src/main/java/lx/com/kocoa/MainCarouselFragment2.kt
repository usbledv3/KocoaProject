package lx.com.kocoa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lx.com.kocoa.databinding.FragmentMainCarousel1Binding
import lx.com.kocoa.databinding.FragmentMainCarousel2Binding


class MainCarouselFragment2 : Fragment() {
    var _binding: FragmentMainCarousel2Binding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainCarousel2Binding.inflate(inflater, container, false)

        binding.carouselImage2.setOnClickListener {

        }

        return binding.root
    }


}