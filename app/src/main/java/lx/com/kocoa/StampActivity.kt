package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lx.com.kocoa.databinding.ActivityStampBinding

class StampActivity : AppCompatActivity() {
    lateinit var binding : ActivityStampBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStampBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}