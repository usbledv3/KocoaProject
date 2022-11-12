package lx.com.kocoa

import android.view.View

interface OnMiniClickListener {
    fun onMiniItemClick(holder: MiniAdapter.ViewHolder, view: View?, position: Int)
}