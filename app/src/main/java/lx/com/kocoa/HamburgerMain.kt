package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import lx.com.kocoa.databinding.ActivityHamburgerMainBinding

class HamburgerMain : AppCompatActivity() {
    lateinit var binding: ActivityHamburgerMainBinding

    //부분화면 구분자
    enum class FragmentItem {
        ITEM1, ITEM5
    }
    enum class ActivityItem{ // 축제등록 Activity
        ITEM4
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHamburgerMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //툴바 설정
        setSupportActionBar(binding.toolbar)

        //드로어 설정
        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        //바로가기 메뉴화면에서 선택할때
        binding.navigationView.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.item1 -> {
                    showToast("축제등록 현황")
                    onFragmentChanged(FragmentItem.ITEM1, null)
                }
//                R.id.item2 -> {
//                    showToast("지도")
//                    onFragmentChanged(FragmentItem.ITEM2, null)
//                }
//                R.id.item3 -> {
//                    showToast("미니게임+")
//                    onFragmentChanged(FragmentItem.ITEM3, null)
//                }
                R.id.item2 -> {
                    showToast("축제 등록하기")
                    onActivityChanged(ActivityItem.ITEM4) // Activity로 넘어가는 부분이라서 null필요없음.
                }
                R.id.item3 -> {
                    showToast("축제후기 관리")
                    onFragmentChanged(FragmentItem.ITEM5, null)
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }
        onFragmentChanged(FragmentItem.ITEM1, null)
    }
    //부분 화면 변경하고자 하는 경우 호출
    fun onFragmentChanged(item:FragmentItem, bundle: Bundle?){
        var fragment : Fragment
        when(item){
            FragmentItem.ITEM1 -> {
                binding.toolbar.title = "축제등록 현황"
                fragment = ShwFirstFragment()
            }
//            FragmentItem.ITEM2 -> {
//                binding.toolbar.title = "지도"
//                fragment = SecondFragment()
//            }
//            FragmentItem.ITEM3 -> {
//                binding.toolbar.title = "미니게임+"
//                fragment = ThirdFragment()
//            }
            FragmentItem.ITEM5 -> {
                binding.toolbar.title = "축제후기 관리"
                fragment = ShwFifthFragment()
            }
        }
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
    fun onActivityChanged(item:ActivityItem){ //축제등록Activity로 넘어가는 코드
        var activity : AppCompatActivity
        when(item){
            ActivityItem.ITEM4 -> {
                binding.toolbar.title = "축제 등록"
                activity = SHWMainActivity()
            }
        }
        startActivity(Intent(this@HamburgerMain,SHWMainActivity::class.java))
    }
    // 시스템 BACK 키 눌렀을 때
    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    // 토스트 메시지 보여주기
    fun showToast(message:String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}