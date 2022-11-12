package lx.com.kocoa

import android.view.View

interface OnFestivalItemClickListener {
    fun onItemClick(holder: FestivalAdapter.ViewHolder?, view: View?, position: Int)
}