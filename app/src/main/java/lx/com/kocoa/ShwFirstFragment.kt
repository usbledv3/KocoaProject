package lx.com.kocoa


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import lx.com.kocoa.databinding.FragmentShwfirstBinding


class ShwFirstFragment : Fragment() {

    var _binding: FragmentShwfirstBinding? = null
    val binding get() = _binding!!
    var festAdapter:FestAdapter? = null
    val FestInforStatusLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
    }


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
                    SAppData.data4,
                    SAppData.data5,
                    SAppData.data6,
                    SAppData.data7
                ))
                notifyDataSetChanged()
            }
        }
    }

    fun initList(){
        //리스트 모양잡기
        val layoutManager = LinearLayoutManager(activity)
        binding.festPassList.layoutManager = layoutManager

        //각 아이템 모양 잡아주기
        festAdapter = FestAdapter()
        binding.festPassList.adapter = festAdapter

        //들어가는지 확인용 -> 들어가는거 확인됨
        festAdapter?.apply {
            this.items.add(FestManagerData("스윗패스", "","","2022년11월25일부터 2022년11월30일까지","코코아축제","","대구광역시","팔현길 212"))
            this.items.add(FestManagerData("익스트림패스", "","","2023년1월6일부터 2023년1월8일까지","소프트웨어개발포럼","","대전광역시","둔산로 100"))
        }

        festAdapter?.listener = object:OnFestInforItemClickListener{
            override fun onItemClick(holder: FestAdapter.ViewHolder?, view: View?, position: Int) {
                festAdapter?.apply {
                    val item = items.get(position)

                    SAppData.selelctedItem = item
                    activity?.let {
                        val FestInforStatusIntent = Intent(it, FestInforStatusActivity::class.java)
                        FestInforStatusLauncher.launch(FestInforStatusIntent)
                    }

                }
            }
        }


    }



}