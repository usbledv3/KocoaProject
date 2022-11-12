package lx.com.kocoa

import android.view.View

interface OnPassItemClickListener {
    fun onItemClick(holder: PassItemAdapter.ViewHolder?, view: View?, position: Int)
}