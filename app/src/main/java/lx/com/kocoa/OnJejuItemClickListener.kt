package lx.com.kocoa

import android.view.View
import java.text.FieldPosition

interface OnJejuItemClickListener {

    fun onItemClick(holder: JejuAdapter.ViewHolder?,view: View?, position: Int)

}