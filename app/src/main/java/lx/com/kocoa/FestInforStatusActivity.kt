package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lx.com.kocoa.databinding.ActivityFestInforStatusBinding

class FestInforStatusActivity : AppCompatActivity() {
    lateinit var binding:ActivityFestInforStatusBinding
    lateinit var festMapFragment: FestMapFragment // 맵 띄우는거 땡겨올려고

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFestInforStatusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        festMapFragment = FestMapFragment() // 맵 띄우기 위한 프래그먼트 사용

        //선택한 아이템 현황화면에 가져오는거
        SAppData.selelctedItem.apply {
            binding.showpassName.text = "패스이름 : ${SAppData.data1}"
            binding.showpassSort.text = "패스종류 : ${SAppData.data2}"
            binding.showpassPerson.text = "패스인원 : ${SAppData.data3}"
            binding.showpassTime.text = "패스기간 : ${SAppData.data4}"
            binding.showfestName.text = "축제이름 : ${SAppData.data5}"
            binding.showfestRange.text = "축제규모 : ${SAppData.data6}"
            binding.showfestLocation.text = "개최지역 : ${SAppData.data7}"

        }

        //뒤로가기버튼
        binding.backButton.setOnClickListener {
            finish()
        }
    }
}