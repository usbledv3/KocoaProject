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