package lx.com.kocoa

import android.view.View
import java.text.FieldPosition

interface OnGangwonItemClickListener {

    fun onItemClick(holder: GangwonAdapter.ViewHolder?,view: View?, position: Int)

}