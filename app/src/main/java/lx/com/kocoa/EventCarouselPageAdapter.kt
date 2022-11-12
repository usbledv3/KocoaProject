package lx.com.kocoa

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class EventCarouselPageAdapter(fa:Fragment): FragmentStateAdapter(fa) {
    var eventCarouselFragments = listOf<Fragment>()

    override fun getItemCount(): Int = eventCarouselFragments.size
    override fun createFragment(position: Int): Fragment {
        return eventCarouselFragments.get(position)
    }
}