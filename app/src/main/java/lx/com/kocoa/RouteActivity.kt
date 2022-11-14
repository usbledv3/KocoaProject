package lx.com.kocoa

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.UiThread
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.overlay.ArrowheadPathOverlay
import com.naver.maps.map.overlay.OverlayImage
import com.naver.maps.map.overlay.PathOverlay
import com.naver.maps.map.util.FusedLocationSource
import lx.com.kocoa.databinding.ActivityRouteBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RouteActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var binding: ActivityRouteBinding

    private lateinit var locationSource: FusedLocationSource
    private lateinit var naverMap: NaverMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRouteBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        path.coords = listOf(
            LatLng(37.5162796,127.0347236),
            LatLng(37.5163175,127.0347223),
            LatLng(37.5163562,127.0347220),
            LatLng(37.5164537,127.0352046),
            LatLng(37.5164638,127.0352657),
            LatLng(37.5164832,127.0353742),
            LatLng(37.5156648,127.0353747),
            LatLng(37.5154061,127.0353695),
            LatLng(37.5153754,127.0353686),
            LatLng(37.5154061,127.0353695),
            LatLng(37.5156648,127.0353747),
            LatLng(37.5164832,127.0353742),
            LatLng(37.5170845,127.0353931),
            LatLng(37.5174252,127.0354045),
            LatLng(37.5176794,127.0353984),
            LatLng(37.5178262,127.0353806),
            LatLng(37.5179821,127.0353558),
            LatLng(37.5180811,127.0353280),
            LatLng(37.5182576,127.0352760),
            LatLng(37.5184016,127.0352231),
            LatLng(37.5184268,127.0352139),
            LatLng(37.5188245,127.0350270),
            LatLng(37.5196172,127.0346791),
            LatLng(37.5199088,127.0345608),
            LatLng(37.5199618,127.0345389),
            LatLng(37.5200167,127.0345182),
            LatLng(37.5202030,127.0344322),
            LatLng(37.5204378,127.0343255),
            LatLng(37.5207518,127.0341742),
            LatLng(37.5209911,127.0340686),
            LatLng(37.5214295,127.0339029),
            LatLng(37.5214861,127.0338810),
            LatLng(37.5215231,127.0338672),
            LatLng(37.5215563,127.0338523),
            LatLng(37.5220926,127.0336102),
            LatLng(37.5223814,127.0334749),
            LatLng(37.5230079,127.0332639),
            LatLng(37.5231699,127.0332108),
            LatLng(37.5234662,127.0331365),
            LatLng(37.5234959,127.0331352),
            LatLng(37.5237780,127.0331244),
            LatLng(37.5239528,127.0331176),
            LatLng(37.5243658,127.0331490),
            LatLng(37.5246994,127.0331865),
            LatLng(37.5253821,127.0332638),
            LatLng(37.5255732,127.0332852),
            LatLng(37.5258663,127.0333117),
            LatLng(37.5259357,127.0333226),
            LatLng(37.5259375,127.0333226),
            LatLng(37.5261847,127.0333674),
            LatLng(37.5263579,127.0333992),
            LatLng(37.5265825,127.0334374),
            LatLng(37.5271660,127.0335367),
            LatLng(37.5275619,127.0335773),
            LatLng(37.5276899,127.0335889),
            LatLng(37.5278910,127.0336114),
            LatLng(37.5284123,127.0336840),
            LatLng(37.5288740,127.0337524),
            LatLng(37.5289038,127.0337557),
            LatLng(37.5289696,127.0337643),
            LatLng(37.5290914,127.0337783),
            LatLng(37.5291428,127.0337847),
            LatLng(37.5294494,127.0338224),
            LatLng(37.5304333,127.0339623),
            LatLng(37.5309471,127.0341934),
            LatLng(37.5312727,127.0342480),
            LatLng(37.5319934,127.0343702)
            )
        path.color = Color.GREEN
        path.width = 30
        path.map=naverMap
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000
    }
}