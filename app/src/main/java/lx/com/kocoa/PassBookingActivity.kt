package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import lx.com.kocoa.databinding.ActivityMainBinding
import lx.com.kocoa.databinding.ActivityPassBookingBinding

class PassBookingActivity : AppCompatActivity() {
    lateinit var binding: ActivityPassBookingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPassBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SelectedPassData.selectedItem?.apply {
            binding.bookname.text = this.name
            binding.bookprice.text = this.price.toString()+"원"
            this.picture?.let { binding.bookingimageView.setImageResource(it) }
        }
        binding.bookbutton.setOnClickListener {
            showToast("${binding.bookname.text}가(이) ${binding.sbCount.text} 예약되었습니다.")
            finish()
        }
        binding.radiogroup.setOnCheckedChangeListener { radioGroup, i ->
            when(i) {
                R.id.radioButton -> {

                }
                R.id.radioButton2 -> {

                }
                R.id.radioButton3 -> {

                }
                R.id.radioButton4 -> {

                }
            }
        }
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
                binding.sbCount.text="예약 인원 : "+ binding.seekBar.progress+"명"
            }

        })
    }
    fun showToast(message:String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
