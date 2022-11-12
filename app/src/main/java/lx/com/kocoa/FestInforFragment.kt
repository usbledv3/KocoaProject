package lx.com.kocoa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lx.com.kocoa.databinding.FragmentFestinforBinding


class FestInforFragment : Fragment() {

    var _binding : FragmentFestinforBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFestinforBinding.inflate(inflater, container, false)

        binding.checkInforButton.setOnClickListener {
            val data1 = binding.festOpenName.text.toString()
            val data2 = binding.festOpenRange.text.toString()
            val data3 = binding.festOpenLocation.text.toString()

            binding.festOutput1.text = "입력한 정보 확인 : ${data1}, ${data2}, ${data3}"
        }


        return binding.root
    }





}