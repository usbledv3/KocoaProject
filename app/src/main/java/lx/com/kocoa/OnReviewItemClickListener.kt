package lx.com.kocoa

import android.view.View

interface OnReviewItemClickListener {
    fun onItemClick(holder:ReviewAdapter.ViewHolder?, view: View?, position: Int)
}
