package lx.com.kocoa

import android.view.View
import com.lx.list.PointShopAdapter

interface OnPointShopClickListner {
    fun onItemClick(holder: PointShopAdapter.ViewHolder, view: View?, position: Int)
}