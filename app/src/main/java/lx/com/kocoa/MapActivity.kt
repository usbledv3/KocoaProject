package lx.com.kocoa

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.UiThread
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.util.MarkerIcons
import lx.com.kocoa.databinding.ActivityMapBinding

class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var binding: ActivityMapBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.mapinfo) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.mapinfo, it).commit()
            }
        //지도 출력
        mapFragment.getMapAsync(this)
    }

    @UiThread
    override fun onMapReady(naverMap: NaverMap) {
        //지정된 위치로 지도 위치 변경
        val cameraUpdate = CameraUpdate.scrollTo(LatLng(38.1077740, 127.7046630))
        naverMap.moveCamera(cameraUpdate)
        naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_TRAFFIC, true)
        val marker1 = Marker()
        marker1.position = LatLng(38.1061548, 127.7029062)
        marker1.icon = MarkerIcons.BLACK
        marker1.iconTintColor = Color.BLUE
        marker1.captionText = "실내얼음조각광장"
        marker1.map = naverMap
        val marker2 = Marker()
        marker2.position = LatLng(38.1059855, 127.7037428)
        marker2.captionText = "산천어 커피박물관"
        marker2.map = naverMap
        val marker3 = Marker()
        marker3.position = LatLng(38.106557, 127.710749)
        marker3.icon = MarkerIcons.BLACK
        marker3.iconTintColor = Color.RED
        marker3.captionText = "예매/얼음낚시터"
        marker3.map = naverMap
        val marker4 = Marker()
        marker4.position = LatLng(38.111592, 127.708927)
        marker4.icon = MarkerIcons.BLACK
        marker4.iconTintColor = Color.YELLOW
        marker4.captionText = "맨손낚시"
        marker4.map = naverMap
        val marker5 = Marker()
        marker5.position = LatLng(38.103809, 127.707114)
        marker5.icon = MarkerIcons.BLACK
        marker5.iconTintColor = Color.YELLOW
        marker5.captionText = "선등거리"
        marker5.map = naverMap
        val marker6 = Marker()
        marker6.position = LatLng(38.102821, 127.710064)
        marker6.captionText = "수상낚시/루어낚시"
        marker6.map = naverMap
        val marker7 = Marker()
        marker7.position = LatLng(38.112276, 127.710000)
        marker7.captionText = "산천어식당"
        marker7.map = naverMap
    }
}