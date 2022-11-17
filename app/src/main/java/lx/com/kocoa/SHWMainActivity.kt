package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import lx.com.kocoa.databinding.ActivityShwmainBinding

class SHWMainActivity : AppCompatActivity() {

    lateinit var binding: ActivityShwmainBinding

    lateinit var festinforFragment: FestInforFragment // 축제정보 프레그먼트
    lateinit var festmapFragment: FestMapFragment // 지도 프레그먼트
    lateinit var festgameFragment: FestGameListFragment // 미니게임 프레그먼트
    lateinit var festpassFragment: FestPassFragment // 페스패스 프레그먼트
    lateinit var shwFirstFragment:ShwFirstFragment// 등록현황 프레그먼트
    lateinit var festPassFragment: FestPassFragment // 이거도 있어야함!! 위에꺼랑 다른거임!!
    var festAdapter:FestAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityShwmainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbarBody = binding.operateToolbar //퉅바 선언
        setSupportActionBar(toolbarBody)
        // 툴바 내 뒤로가기 버튼 생성
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        shwFirstFragment = ShwFirstFragment()//등록현황 프레그먼트로 이동
        festPassFragment = FestPassFragment()
        festinforFragment = FestInforFragment() // 축제정보 프레그먼트로 화면연결
        festmapFragment = FestMapFragment() // 지도 프레그먼트로 화면연결
        festgameFragment = FestGameListFragment() // 미니게임 프레그먼트로 화면연결
        festpassFragment = FestPassFragment() // 페스패스 프레그먼트로 화면연결

        binding.registerButton.setOnClickListener {//등록현황Fragment로 넘어가는 버튼

            festAdapter?.apply {
                items.add(
                    FestManagerData(
                        SAppData.data1,
                        SAppData.data2,
                        SAppData.data3,
                        SAppData.data4,
                        SAppData.data5,
                        SAppData.data6,
                        SAppData.data7,
                        SAppData.data8, // 이거 추가함/ 종인이가 수정한거랑 충돌되는지 확인해야함
                        SAppData.data9, //객관식 미니게임 이름
                        SAppData.data10, //미니게임 종류
                        SAppData.data11 //미니게임 정답
                    )
                )
                notifyDataSetChanged()
            }
            //버튼 눌렀을때 축제등록현황화면으로 복귀
            //startActivity(Intent(this,HamburgerMain::class.java))
            finish()

        }

        supportFragmentManager.beginTransaction().add(R.id.frameLayout, festinforFragment).commit()
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0->{
                        replaceView(festinforFragment)
                    }
                    1->{
                        replaceView(festmapFragment)
                    }
                    2->{
                        replaceView(festgameFragment)
                    }
                    3->{
                        replaceView(festpassFragment)
                    }
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
            override fun onTabReselected(tab: TabLayout.Tab?){

            }
        })

    }
    fun replaceView(tab: Fragment){
        var selectedFragment : Fragment? = null
        selectedFragment = tab
        selectedFragment?.let{
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, it).commit()
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean { //툴바 뒤로가기버튼 활성화
        when (item.getItemId()) {
            android.R.id.home -> {
                //toolbar의 back키 눌렀을 때 동작
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}