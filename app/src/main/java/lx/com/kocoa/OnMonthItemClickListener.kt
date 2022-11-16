package lx.com.kocoa

import android.view.View

interface OnMonthItemClickListener {

    fun onItemClick(holder: MonthAdapter.ViewHolder?, view: View?, position: Int)

}