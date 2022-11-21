package lx.com.kocoa

import android.media.Image
import android.widget.ImageView


data class FestManagerData (
        val data1:String? = null, //패스이름
        val data2:String? = null, //패스종류
        val data3:String? = null, //패스적용인원
        val data4:String? = null, //패스적용시간
        val data5:String? = null, //축제이름
        val data6:String? = null, //축제규모
        val data7:String? = null, //축제개최지역
        val data8:String? = null, //지도입력 도로명주소입력
        val data9:String? = null, //미니게임객관식 문제이름입력
        val data10:String? = null, //미니게임 종류입력
        val data11:String? = null, //미니게임 정답입력
        val data12: ImageView? = null//갤러리사진 넣기
)