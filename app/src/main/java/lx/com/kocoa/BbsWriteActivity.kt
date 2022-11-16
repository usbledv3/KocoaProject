package lx.com.kocoa

import android.R
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import lx.com.kocoa.databinding.ActivityBbsWriteBinding


class BbsWriteActivity : AppCompatActivity() {

    lateinit var binding: ActivityBbsWriteBinding

    var bbsActivity:BbsActivity? = null
    var bbsAdapter:BbsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBbsWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbarBody = binding.toolbar5
        setSupportActionBar(toolbarBody)
        // 뒤로가기 버튼 생성
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        binding.bbsSaveButton.setOnClickListener {
            val bbsTitle = binding.bbsInTitle.text.toString()
            val bbsWriter = binding.bbsInWriter.text.toString()
            val bbsContent = binding.bbsInContent.text.toString()

            JhAppData.data1 = bbsTitle

            bbsAdapter?.apply{
                items.add(
                    BbsData(bbsTitle)
                )
                notifyDataSetChanged()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.home -> {
                //toolbar의 back키 눌렀을 때 동작
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}





