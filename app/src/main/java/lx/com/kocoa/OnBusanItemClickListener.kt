package lx.com.kocoa

import android.view.View
import java.text.FieldPosition

interface OnBusanItemClickListener {

    fun onItemClick(holder: BusanAdapter.ViewHolder?,view: View?, position: Int)

}