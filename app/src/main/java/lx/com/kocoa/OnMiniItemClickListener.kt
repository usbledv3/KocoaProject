package lx.com.kocoa

import android.view.View

interface OnMiniItemClickListener {
    fun onItemClick(holder: MiniAdapter.ViewHolder, view: View?, position: Int)
}