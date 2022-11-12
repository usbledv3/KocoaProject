package com.lx.list

import android.app.AlertDialog
import android.widget.Button

// 코틀린에서 생성자함수 형태로 클래스를만듬
data class PointShopData (

    val profile:Int? = null,
    val name:String? = null,
    val price: String? = null,
    var button : Button? = null

    )