package lx.com.kocoa

import android.view.View

interface OnRankItemClickListener {

    fun onRankItemClick(holder: RankAdapter.ViewHolder, view: View?, position: Int)

}