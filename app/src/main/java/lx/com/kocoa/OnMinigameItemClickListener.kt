package lx.com.kocoa

import android.view.View

interface OnMinigameItemClickListener {

    fun onMiniGameItemClick(holder: MiniGameAdapter.ViewHolder, view: View?, position: Int)

}