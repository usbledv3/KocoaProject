package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lx.com.kocoa.databinding.ActivityBbsBinding
import lx.com.kocoa.databinding.ActivityBbsWriteBinding
import lx.com.kocoa.databinding.ActivityBookcheckBinding

class BookcheckActivity : AppCompatActivity() {
    lateinit var binding: ActivityBookcheckBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookcheckBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnameOutput.text=BookData.bname
        binding.bpriceOutput.text="인당 ${BookData.bprice}원"
        binding.bdateOutput.text=BookData.bdate
        binding.btimeOutput.text=BookData.btime
        binding.bpeopleOutput.text=BookData.bpeople
    }
}