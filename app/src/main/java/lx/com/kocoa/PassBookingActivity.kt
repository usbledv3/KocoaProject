package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import lx.com.kocoa.databinding.ActivityPassBookingBinding

class PassBookingActivity : AppCompatActivity() {
    lateinit var binding: ActivityPassBookingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPassBookingBinding.inflate(layoutInflater)
        var srd : String? = null
        var sdate : String? = null
        setContentView(binding.root)
        SelectedPassData.selectedItem?.apply {
            binding.bookname.text = this.name
            binding.bookprice.text = this.price.toString()+"원"
            this.picture?.let { binding.bookingimageView.setImageResource(it) }
        }
        binding.bookbutton.setOnClickListener {
            showToast("${binding.bookname.text}가(이) ${sdate}, ${srd}에 ${binding.sbCount.text} 예약되었습니다.")
            BookData.bname = SelectedPassData.selectedItem?.name
            BookData.bprice = SelectedPassData.selectedItem?.price.toString()
            BookData.bdate = sdate
            BookData.btime = srd
            BookData.bpeople = binding.sbCount.text.toString()
            finish()
        }
        binding.calendarView.setOnDateChangeListener { calendarView, i, i2, i3 ->
            sdate = String.format("%d / %d / %d", i, i2+1, i3)
        }
        binding.radiogroup.setOnCheckedChangeListener { radioGroup, i ->
            when(i) {
                R.id.am09 -> {
                    srd = "오전 9시"
                }
                R.id.am11 -> {
                    srd = "오전 11시"
                }
                R.id.pm01 -> {
                    srd = "오후 1시"
                }
                R.id.pm03 -> {
                    srd = "오후 3시"
                }
            }
        }
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
                binding.sbCount.text="${binding.seekBar.progress}명"
            }

        })
    }
    fun showToast(message:String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
