package lx.com.kocoa

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lx.com.kocoa.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    var _binding: FragmentMainBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        mainCarouselList()
        eventCarouselList()

        binding.searchButton.setOnClickListener {
            val searchIntent= Intent(activity,SearchActivity::class.java)
            startActivity(searchIntent)
        }

        binding.searchIcon.setOnClickListener {
            val searchIntent= Intent(activity,SearchActivity::class.java)
            startActivity(searchIntent)
        }

        binding.seoulImage.setOnClickListener {
            val seoulIntent= Intent(activity,SeoulActivity::class.java)
            startActivity(seoulIntent)
        }

        binding.gangwonImage.setOnClickListener {
            val gangwonIntent= Intent(activity,GangwonActivity::class.java)
            startActivity(gangwonIntent)
        }

        binding.chungcheongImage.setOnClickListener {
            val chungcheongIntent= Intent(activity,ChungcheongActivity::class.java)
            startActivity(chungcheongIntent)
        }

        binding.busanImage.setOnClickListener {
            val busanIntent= Intent(activity,BusanActivity::class.java)
            startActivity(busanIntent)
        }

        binding.junraImage.setOnClickListener {
            val junraIntent= Intent(activity,JunraActivity::class.java)
            startActivity(junraIntent)
        }

        binding.jejuImage.setOnClickListener {
            val jejuIntent= Intent(activity,JejuActivity::class.java)
            startActivity(jejuIntent)
        }
        return binding.root
    }

    //메인 캐러셀 함수
    fun mainCarouselList() {
        val mainCarouselList = listOf(MainCarouselFragment1(), MainCarouselFragment2(), MainCarouselFragment3())
        val mainCarouselAdapter = MainCarouselPageAdapter(this)
        mainCarouselAdapter.mainCarouselFragments = mainCarouselList
        binding.mainCarouselViewPager.adapter = mainCarouselAdapter
    }

    // 이벤트 캐러셀 함수
    fun eventCarouselList() {
        val eventCarouselList = listOf(EventCarouselFragment1(), EventCarouselFragment2(), EventCarouselFragment3())
        val eventCarouselAdapter = EventCarouselPageAdapter(this)
        eventCarouselAdapter.eventCarouselFragments = eventCarouselList
        binding.eventCarouselViewPager.adapter = eventCarouselAdapter
    }

}