package lx.com.kocoa

import android.view.View

interface OnFestInforItemClickListener {
    fun onItemClick(holder:FestAdapter.ViewHolder?, view: View?, position: Int)
}