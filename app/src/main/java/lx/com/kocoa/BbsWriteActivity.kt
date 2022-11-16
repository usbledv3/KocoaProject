package lx.com.kocoa

import android.R
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import lx.com.kocoa.JhAppData.Companion.bbsAdapter
import lx.com.kocoa.databinding.ActivityBbsWriteBinding


class BbsWriteActivity : AppCompatActivity() {

    lateinit var binding: ActivityBbsWriteBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBbsWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbarBody = binding.toolbar5
        setSupportActionBar(toolbarBody)
        // 뒤로가기 버튼 생성
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initView()



    }
    fun initView(){
        binding.bbsSaveButton.setOnClickListener {
            val bbsTitle = binding.bbsInTitle.text.toString()
            val bbsWriter = binding.bbsInWriter.text.toString()
            val bbsContent = binding.bbsInContent.text.toString()


            JhAppData.bbsAdapter?.apply{
                items.add(
                    BbsData(bbsTitle, bbsWriter, bbsContent)
                )
                notifyDataSetChanged()
            }
            finish()
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





