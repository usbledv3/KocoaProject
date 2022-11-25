package lx.com.kocoa

import android.view.View

interface OnMakepassItemClickListener {

    fun onItemClick(holder: MakepassAdapter.ViewHolder?, view: View?, position: Int)

}