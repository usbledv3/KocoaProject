package lx.com.kocoa

import android.view.View

interface OnDoItemClickListener {

    fun onItemClick(holder: DoAdapter.ViewHolder?, view: View?, position: Int)

}