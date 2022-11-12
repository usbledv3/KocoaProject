package lx.com.kocoa

import android.view.View
import java.text.FieldPosition

interface OnJunraItemClickListener {

    fun onItemClick(holder: JunraAdapter.ViewHolder?,view: View?, position: Int)

}