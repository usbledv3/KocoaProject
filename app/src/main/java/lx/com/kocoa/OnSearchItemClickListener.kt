package lx.com.kocoa

import android.view.View
import java.text.FieldPosition

interface OnSearchItemClickListener {

    fun onItemClick(holder: SearchAdapter.ViewHolder?,view: View?, position: Int)

}