package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lx.com.kocoa.databinding.ActivityRouteInputBinding

class RouteInputActivity : AppCompatActivity() {
    lateinit var binding: ActivityRouteInputBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRouteInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.routingbtn.setOnClickListener {
            RouteData.startpoint = binding.startInput.text
            RouteData.endpoint = binding.endInput.text
            startActivity(Intent(this,MylocaActivity::class.java))
        }
    }
}