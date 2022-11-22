package lx.com.kocoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import lx.com.kocoa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // 커밋에 문제가 있나요?
    // 문제가 없네요!

    lateinit var binding: ActivityMainBinding

    //부분화면 구분자
    enum class FragmentItem {
        ITEM1, ITEM5
    }
    enum class ActivityItem{ // 축제등록 Activity
        ITEM4
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setSupportActionBar(binding.toolbar2)

        //드로어 설정
        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.toolbar2,
            R.string.drawer_open,
            R.string.drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportFragmentManager.beginTransaction().replace(R.id.container, MainFragment()).commit()

        //바로가기 메뉴화면에서 선택할때
        binding.navigationView.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.item1 -> {
                    showToast("축제등록 현황")
                    onFragmentChanged(FragmentItem.ITEM1, null)
                }
                R.id.item2 -> {
                    showToast("축제 등록하기")
                    onActivityChanged(ActivityItem.ITEM4) // Activity로 넘어가는 부분이라서 null필요없음.
                }
                R.id.item3 -> {
                    showToast("축제후기 관리")
                    onFragmentChanged(FragmentItem.ITEM5, null)
                }
                R.id.item4 -> {
                    showToast("게시판")
                    startActivity(Intent(this@MainActivity, BbsActivity::class.java))
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }

        //하단 네비게이션바 메뉴
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.tab1 -> {
                    startActivity(Intent(this@MainActivity,CalendarActivity::class.java))

                }
                R.id.tab2 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container, MainFragment()).commit()

                }
                R.id.tab3 -> {
                    startActivity(Intent(this@MainActivity,MyPageActivity::class.java))
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
    fun onFragmentChanged(item:FragmentItem, bundle: Bundle?){
        var fragment : Fragment
        when(item){
            FragmentItem.ITEM1 -> {
                fragment = ShwFirstFragment()
            }
            FragmentItem.ITEM5 -> {
                fragment = ShwFifthFragment()
            }
        }
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
    fun onActivityChanged(item: ActivityItem){ //축제등록Activity로 넘어가는 코드
        var activity : AppCompatActivity
        when(item){
            ActivityItem.ITEM4 -> {
                activity = SHWMainActivity()
            }
        }
        startActivity(Intent(this@MainActivity,SHWMainActivity::class.java))
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