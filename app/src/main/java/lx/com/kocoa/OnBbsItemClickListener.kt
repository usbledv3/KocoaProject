package lx.com.kocoa

import android.view.View

interface OnBbsItemClickListener {

    fun onBbsItemClick(holder: BbsAdapter.ViewHolder, view: View?, position: Int)

}