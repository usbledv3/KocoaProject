package lx.com.kocoa

import android.view.View
import java.text.FieldPosition

interface OnSeoulItemClickListener {

    fun onItemClick(holder: SeoulAdapter.ViewHolder?,view: View?, position: Int)

}