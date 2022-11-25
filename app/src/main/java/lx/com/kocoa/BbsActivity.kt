package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.JhAppData.Companion.bbsAdapter
import lx.com.kocoa.databinding.ActivityBbsBinding


class BbsActivity : AppCompatActivity() {

    lateinit var binding: ActivityBbsBinding


    val bbsLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBbsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 플러팅 버튼 눌렀을 시
        binding.writeButton.setOnClickListener {
            startActivity(Intent(this@BbsActivity, BbsWriteActivity::class.java))
        }

        // 리스트 초기화
        initList()

    }

    fun initList() {
        // 리스트의 모양을 담당하는 것
        val layoutManager = LinearLayoutManager(this)
        binding.bbsList.layoutManager = layoutManager

        // 어댑터를 설정하는 것 --> 실제 데이터를 관리하고 각 아이템의 모양을 만들어 주는 것

        bbsAdapter = BbsAdapter()
        binding.bbsList.adapter = bbsAdapter

        // 아이템을 위한 데이터 넣기
        bbsAdapter?.apply {
            this.items.add(BbsData("[공지사항]", "운영자", "건의사항", "[건의사항]"))
        }

        // 아이템을 클릭했을 때 동작할 코드 넣어주기
        bbsAdapter?.listener = object : OnBbsItemClickListener {
            override fun onBbsItemClick(holder: BbsAdapter.ViewHolder, view: View?, position: Int) {
                bbsAdapter?.apply{
                    val item = items.get(position)

                    JhAppData.selectedBbsItem = item

                    val bbsIntent = Intent(applicationContext,BbsViewActivity::class.java)
                    bbsLauncher.launch(bbsIntent)
                }
            }
        }
    }

}