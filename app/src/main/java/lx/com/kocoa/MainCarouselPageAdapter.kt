package lx.com.kocoa

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainCarouselPageAdapter(fa:Fragment): FragmentStateAdapter(fa) {
    var mainCarouselFragments = listOf<Fragment>()

    override fun getItemCount(): Int = mainCarouselFragments.size
    override fun createFragment(position: Int): Fragment {
        return mainCarouselFragments.get(position)
    }
}