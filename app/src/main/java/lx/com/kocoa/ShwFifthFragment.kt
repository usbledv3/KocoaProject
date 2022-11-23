package lx.com.kocoa

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.FragmentShwfifthBinding

class ShwFifthFragment : Fragment() {
    var _binding: FragmentShwfifthBinding? = null
    val binding get() = _binding!!
    var reviewAdapter:ReviewAdapter? = null
    val ManagereviewLauuncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentShwfifthBinding.inflate(inflater, container, false)

        initList()
        initView()

        return binding.root
    }
    fun initList(){
        val layoutManager = LinearLayoutManager(getActivity())
        binding.SHWFestreviewList.layoutManager = layoutManager

        reviewAdapter = ReviewAdapter()
        binding.SHWFestreviewList.adapter = reviewAdapter

        reviewAdapter?.apply {

            this.items.add(ReviewData("산천어 축제 잘 즐기고 갑니다", "2020-02-08", "정익환",
                "산천어 축제 즐길거리가 많아서 좋았어요. 특히 버블 슈트 체험은 아이들이 너무 좋아했어요!!"))

            this.items.add(ReviewData("산천어 축제에 대한 소감이에요~", "2021-02-08", "성희우",
                "주말에는 지역 주민들이 행사에 몰려 들기 때문에 주말에는 더욱 혼잡 해져서 평일 방문하는 것이 가장 좋습니다."))

            this.items.add(ReviewData("산천어", "2021-01-02", "김주희",
                "사전 예약시스템으로 미리 예약을 하고 가니까 인기 많은 산천어 맨손잡기 체험을 바로 해볼 수 있어서 좋았습니다."))

        }

        //늘렀을때 화면 이동
        reviewAdapter?.listener = object:OnReviewItemClickListener{
            override fun onItemClick(holder: ReviewAdapter.ViewHolder?, view: View?, position: Int) {
                reviewAdapter?.apply {
                    val item = items.get(position)

                    ReviewManagerData.selectedItem = item
                    activity?.let {
                        val managereview = Intent(it, ManageReview::class.java)
                        ManagereviewLauuncher.launch(managereview)
                    }
                }
            }
        }



    }
    fun initView(){
        binding.refreshReviewButton.setOnClickListener {

            reviewAdapter?.apply {
                items.add(ReviewData(
                    ReviewManagerData.titleofReview,
                    ReviewManagerData.dateofReview,
                    ReviewManagerData.nameofReview,
                    ReviewManagerData.textofReview
                ))
                notifyDataSetChanged()
            }
        }
    }

}