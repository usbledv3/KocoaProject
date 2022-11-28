package lx.com.kocoa

import android.view.View

interface OnManageReviewItemClickListener {
    fun onItemClick(holder:ManageReviewAdapter.ViewHolder?, view: View?, position: Int)
}
