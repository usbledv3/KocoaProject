package lx.com.kocoa

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.FragmentShwfirstBinding


class ShwFirstFragment : Fragment() {

    var _binding: FragmentShwfirstBinding? = null
    val binding get() = _binding!!
    var festAdapter:FestAdapter? = null




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentShwfirstBinding.inflate(inflater, container, false)

        initList()
        initView()


        return binding.root
    }

    fun initView(){

        binding.refreshButton.setOnClickListener{

            festAdapter?.apply {
                items.add(FestManagerData(
                    SAppData.data1,
                    SAppData.data2,
                    SAppData.data3,
                    SAppData.data4
                ))
                notifyDataSetChanged()
            }
        }

    }

    fun initList(){
        //리스트 모양잡기
        val layoutManager = LinearLayoutManager(getActivity())
        binding.festPassList.layoutManager = layoutManager

        //각 아이템 오먕 잡아주기
        festAdapter = FestAdapter()
        binding.festPassList.adapter = festAdapter

        //들어가는지 확인용 -> 들어가는거 확인됨
        festAdapter?.apply {
            this.items.add(FestManagerData("축제이름1", "패스종류예시1","패스적용범위예시1","패스기간예시1"))
            this.items.add(FestManagerData("축제이름2", "패스종류예시2","패스적용범위예시2","패스기간예시2"))
        }


    }



}