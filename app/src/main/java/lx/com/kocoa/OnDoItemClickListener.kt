package lx.com.kocoa

import android.view.View

interface OnDoItemClickListener {

    fun onDoItemClick(holder: DoAdapter.ViewHolder?, view: View?, position: Int)

}