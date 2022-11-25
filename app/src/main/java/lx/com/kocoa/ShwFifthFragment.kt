package lx.com.kocoa

import android.content.Intent
import android.nfc.tech.MifareUltralight.PAGE_SIZE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lx.com.kocoa.databinding.FragmentShwfifthBinding

class ShwFifthFragment : Fragment() {
    var _binding: FragmentShwfifthBinding? = null
    val binding get() = _binding!!
    var manageReviewAdapter:ManageReviewAdapter? = null
    val ManagereviewLauuncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentShwfifthBinding.inflate(inflater, container, false)

        initList()
        initView()

        return binding.root
    }

    fun initList(){
        val layoutManager = LinearLayoutManager(activity)
        binding.SHWFestreviewList.layoutManager = layoutManager

        manageReviewAdapter = ManageReviewAdapter()
        binding.SHWFestreviewList.adapter = manageReviewAdapter

        manageReviewAdapter?.apply {

            this.items.add(ReviewData("산천어 축제 잘 즐기고 갑니다", "2020-02-08", "정익환",
                "산천어 축제 즐길거리가 많아서 좋았어요. 특히 버블 슈트 체험은 아이들이 너무 좋아했어요!!"))

        }

        //늘렀을때 화면 이동
        manageReviewAdapter?.listener = object:OnManageReviewItemClickListener {
            override fun onItemClick(holder: ManageReviewAdapter.ViewHolder?, view: View?, position: Int) {
                manageReviewAdapter?.apply {
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

            manageReviewAdapter?.apply {
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