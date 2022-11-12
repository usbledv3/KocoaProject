package lx.com.kocoa

import android.view.View

interface OnMinigameItemClickListener {

    fun ongameItemClick(holder: MiniGameAdapter.ViewHolder, view: View?, position: Int)

}