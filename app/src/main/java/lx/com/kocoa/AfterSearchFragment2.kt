package lx.com.kocoa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.FragmentAfterSearch2Binding
import lx.com.kocoa.databinding.FragmentAfterSearchBinding

class AfterSearchFragment2 : Fragment() {
    var _binding: FragmentAfterSearch2Binding? = null
    val binding get() = _binding!!

    var searchAdapter:SearchAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAfterSearch2Binding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    fun initView() {
        // 리스트의 모양을 담당하는 것
        // (LinearLayoutManager : 아래쪽으로 아이템들이 보이는 것, GridLayoutManager: 격자 형태로 보이는 것)
        val layoutManager = LinearLayoutManager(context)
        binding.searchList3.layoutManager = layoutManager

        // 2. 어댑터를 설정하는 것
        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어주는 것
        searchAdapter = SearchAdapter()
        binding.searchList3.adapter = searchAdapter

        // 3. 테스트로 아이템을 위한 데이터 넣어보기
        searchAdapter?.apply {
            this.items.clear()
            this.items.add(
                SearchData("별빛정원우주 365일 별빛축제", R.drawable.byul_fes,"2022.1.1-2022.12.31","경기도 이천시 마장면 덕이로154번길 287-76"
                )
            )
            this.items.add(
                SearchData(
                    "2022 화천 산천어축제", R.drawable.hwachun_festival, "2022.1.7-1.29", "강원도 화천"
                )
            )
            this.items.add(
                SearchData(
                    "2022 서울 빛초롱축제", R.drawable.festival1, "2022.12.16-12.31", "서울시 청계천"
                )
            )
            this.items.add(SearchData("태안 빛축제",
                R.drawable.teaan_fes,
                "2023.1.1-12.31",
                "충청남도 태안군 남면 마검포길 200"))
            this.items.add(SearchData("강진청자축제",
                R.drawable.gangjin_fes,
                "2023.2.1-2.15",
                "전라남도 강진군 대구면 청자촌길 8-3"))
            this.items.add(SearchData("고창 청농원 라벤더 축제",
                R.drawable.gochang_fes,
                "2023.5.27-2023.6.30",
                "전라북도 고창군 공음면 청천길 41-27"))
            this.items.add(SearchData("렛츠런파크 서울 여름 수국축제",
                R.drawable.suguk_fes,
                "2023.7.30-2023.8.21",
                "경기도 과천시 경마공원대로 107"))
            this.items.add(SearchData("춘천막국수닭갈비축제",
                R.drawable.chuncheon_fes,
                "2023.8.30-2023.9.4",
                "강원도 춘천시 스포츠타운길 245"))
            this.items.add(SearchData("휴애리 핑크뮬리 축제",
                R.drawable.pinkmuli_fes,
                "2022.9.15-2022.11.15",
                "제주특별자치도 서귀포시 남원읍 신례동로 256"))
            this.items.add(SearchData("벽초지수목원 가을꽃 국화축제",
                R.drawable.bykcho_fes,
                "2022.9.23-2022.11.20",
                "경기도 파주시 광탄면 부흥로 242"))
            this.items.add(SearchData("화담숲 가을 단풍 축제",
                R.drawable.hwadam,
                "2022.10.15-2022.11.13",
                "경기도 광주시 도척윗로 278-1"))
            this.items.add(SearchData("외계인 대축제",
                R.drawable.alien_fes,
                "2022.11.12-2022.11.13",
                "경상남도 밀양시 밀양대공원로 86"))
            this.items.add(SearchData("피나클랜드 왕새우 축제",
                R.drawable.shrimp_fes,
                "2022.10.01-2022.11.30",
                "충청남도 아산시 월선길 20-42"))
            this.items.add(SearchData("대한민국 우리술 대축제",
                R.drawable.alcohol_fes,
                "2022.11.18-2022.11.20",
                "서울특별시 서초구 강남대로 27 AT센터"))
            this.items.add(SearchData("프로방스 크리스마스 산타마을 빛축제",
                R.drawable.santa_fes,
                "32022.11.12-2023.1.31",
                "경상북도 청도군 화양읍 이슬미로 272-23"))
            this.items.add(SearchData("서천 마량진항 해넘이·해돋이 축제",
                R.drawable.sunrise_fes,
                "2022.12.31-2023.1.1",
                "충청남도 서천군 서인로 58"))

        }

    }
}