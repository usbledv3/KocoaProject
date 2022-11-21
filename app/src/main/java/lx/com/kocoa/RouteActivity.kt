package lx.com.kocoa

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        binding.button13.setOnClickListener {
            if(fesplace=="제34회 춘천인형극제") {
                showToast("'언주로133길' 방면으로 우회전, '언주로' 방면으로 우회전, 서울세관에서 유턴, 성수대교남단에서 '올림픽대로(종합운동장)' 방면으로 오른쪽 도시고속도로 진입, 강일IC에서 '서울/양양고속도로,춘천,덕소삼패' 방면으로 고속도로 진입," +
                        " 남양주톨케이트, 남춘천IC에서 '남춘천,비발디파크,라비에벨' 방면으로 오른쪽 고속도로 출구, 남춘천톨게이트(통행료 3,900원), 남춘천IC삼거리에서 '양평,춘천,비발디파크' 방면으로 우회전," +
                        " 광판삼거리에서 '춘천,'김유정역' 방면으로 우회전, 온의사거리에서 '소양강댐' 방면으로 좌회전, 호반사거리에서 '강원도교육청' 방면으로 좌회전, 사우사거리에서 '강원도교육청' 방면으로 좌회전," +
                        " 인형극장사거리에서 유턴, 우회전, 우회전, 우회전, 목적지")
            }
            if(fesplace=="화천산천어축제") {
                showToast("'언주로133길' 방면으로 우회전, '언주로' 방면으로 우회전, 서울세관에서 유턴, 성수대교남단에서 '올림픽대로(종합운동장)' 방면으로 오른쪽 도시고속도로 진입, 강일IC에서 '서울/양양고속도로,춘천,덕소삼패' 방면으로 고속도로 진입," +
                        " 남양주톨케이트, 동산톨게이트(통행룡 4,100원), 춘천분기점에서 '춘천(중앙선),원주,홍천' 방면으로 오른쪽 방향, 춘천분기점에서 '중앙고속도로,춘천' 방면으로 왼쪽 방향, 춘천톨게이트(통행료 1,500원)," +
                        " 춘천IC에서 '인제,양구,화천' 방면으로 오른쪽 고속도로 출구, 지내교차로에서 '고탄, 신북로' 방면으로 오른쪽 방향, 지내교차로에서 '화천' 방면으로 회전교차로에서 12시 방향," +
                        " 화천대교오거리에서 '철원,김화' 방면으로 회전교차로에서 1시 방향, '산수화로' 방면으로 우회전, 좌회전, '산천어길' 방면으로 좌회전, 우회전, 목적지")
            }
        }
    }

    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap
        naverMap.locationSource = locationSource
        naverMap.locationTrackingMode = LocationTrackingMode.Follow
        val path = ArrowheadPathOverlay()
        if(fesplace=="화천산천어축제"){
            path.coords = fishroute.data
            path.color = Color.GREEN
            path.width = 30
            path.map=naverMap
        }
        if(fesplace=="제34회 춘천인형극제") {
            path.coords = dollroute.data
            path.color = Color.GREEN
            path.width = 30
            path.map=naverMap
        }
        val uiSettings = naverMap.uiSettings
        uiSettings.isLocationButtonEnabled = true
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000
    }
    fun showToast(message:String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}