package lx.com.kocoa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import lx.com.kocoa.databinding.FragmentShwfifthBinding

class ShwFifthFragment : Fragment() {
    var _binding: FragmentShwfifthBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentShwfifthBinding.inflate(inflater, container, false)

        return binding.root
    }

}