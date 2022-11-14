package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.UiThread
import androidx.core.view.get
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*

import lx.com.kocoa.databinding.ActivitySancheonuBinding

class SancheonuActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var binding: ActivitySancheonuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySancheonuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppDataYW.doSelectedItem?.let {
            binding.imageView9.setImageResource(it.doImage)
            binding.import1.text=it.doDate
            binding.import3.text=it.doPlace
            binding.textView2.text=it.doName
        }
        binding.passbutton.setOnClickListener {
            startActivity(Intent(this@SancheonuActivity,FespassActivity::class.java))
        }

        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.map2) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.map2, it).commit()
            }

        mapFragment.getMapAsync(this)

        binding.reviewbtn.setOnClickListener {
            startActivity(Intent(this@SancheonuActivity,ReviewActivity::class.java))
        }
        binding.minigamebtn.setOnClickListener {
            startActivity(Intent(this@SancheonuActivity,MiniGameActivity::class.java))
        }
    }

    @UiThread
    override fun onMapReady(naverMap: NaverMap) {
        val cameraUpdate = CameraUpdate.scrollTo(LatLng(38.107433, 127.703225))
        naverMap.moveCamera(cameraUpdate)
    }

}

