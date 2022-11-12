package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    lateinit var festPassFragment: FestPassFragment
    var festAdapter:FestAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityShwmainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        shwFirstFragment = ShwFirstFragment()//등록현황 프레그먼트로 이동
        festPassFragment = FestPassFragment()
        festinforFragment = FestInforFragment() // 축제정보 프레그먼트로 화면연결
        festmapFragment = FestMapFragment() // 지도 프레그먼트로 화면연결
        festgameFragment = FestGameListFragment() // 미니게임 프레그먼트로 화면연결
        festpassFragment = FestPassFragment() // 페스패스 프레그먼트로 화면연결

        binding.registerButton.setOnClickListener {//등록현황Fragment로 넘어가는 버튼
//            val passfestname = festPassFragment.passFestNameIn.text.toString()
//            val passname = festPassFragment.passPassNameIn.text.toString()
//            val passrange = festPassFragment.passFestRangeIn.text.toString()
//            val passtime = festPassFragment.passTimeIn.text.toString()
//
            festAdapter?.apply {
                items.add(
                    FestManagerData(
                        SAppData.data1,
                        SAppData.data2,
                        SAppData.data3,
                        SAppData.data4
                    )
                )
                notifyDataSetChanged()

                supportFragmentManager.beginTransaction().replace(R.id.toshwFirstLayout, shwFirstFragment).commit()
            }

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

}