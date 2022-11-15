package lx.com.kocoa

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naver.maps.map.*
import com.naver.maps.map.overlay.ArrowheadPathOverlay
import com.naver.maps.map.util.FusedLocationSource
import lx.com.kocoa.databinding.ActivityRouteBinding

class RouteActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var binding: ActivityRouteBinding
    var fesplace : String? = null

    private lateinit var locationSource: FusedLocationSource
    private lateinit var naverMap: NaverMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRouteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppDataYW.doSelectedItem?.let {
            fesplace=it.doName
        }

        locationSource = FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)
        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.Mylocamap) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.Mylocamap, it).commit()
            }
        //지도 출력
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap
        naverMap.locationSource = locationSource
        naverMap.locationTrackingMode = LocationTrackingMode.Follow
        val path = ArrowheadPathOverlay()
        if(fesplace=="화천산천어축제"){
            path.coords = fishroute.data
        }
        if(fesplace=="제34회 춘천인형극제") {
            path.coords = dollroute.data
        }
        path.color = Color.GREEN
        path.width = 30
        path.map=naverMap
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000
    }
}