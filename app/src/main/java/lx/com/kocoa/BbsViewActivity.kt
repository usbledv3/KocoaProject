package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import lx.com.kocoa.databinding.ActivityBbsViewBinding
import java.nio.file.Files.delete


class BbsViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityBbsViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBbsViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 뒤로가기 버튼 생성
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 이전 화면에서 선택한 아이템의 데이터를 화면에 있는 텍스트뷰에 보여주기
        JhAppData.selectedBbsItem?.apply {
            binding.bbsTitleView.text = this.bbsTitle
            binding.bbsWriterView.text = this.bbsWriter
            binding.bbsContentView.text = this.bbsContent
        }

        }


    // 옵션 메뉴 설정
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.option_menu,menu)

        return true

    }

    // 옵션메뉴 선택 기능
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.edit -> {
                Toast.makeText(this,"수정화면",Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.delete -> {
                Toast.makeText(this,"삭제",Toast.LENGTH_SHORT).show()
                return true
            }

            else -> return false

        }

    }


}