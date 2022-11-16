package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
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


    }





