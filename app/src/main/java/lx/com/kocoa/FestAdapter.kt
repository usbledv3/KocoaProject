package lx.com.kocoa

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lx.com.kocoa.databinding.FespassItemBinding
import lx.com.kocoa.databinding.FestinforItemBinding

class FestAdapter : RecyclerView.Adapter<FestAdapter.ViewHolder>(){
    var items = ArrayList<FestManagerData>()
    var listener:OnFestInforItemClickListener? = null


    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FestAdapter.ViewHolder {
        val binding = FespassItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: FestAdapter.ViewHolder, position:Int){
        val item = items[position]
        holder.setpassItem(item)//사전예약시스템 아이템 불러오기
        holder.setStatusItem(item)//
    }

    inner class ViewHolder(val binding: FespassItemBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                listener?.onItemClick(this, binding.root, adapterPosition)
            }
        }
        fun setpassItem(item:FestManagerData){
            binding.pasFestNameOut.text = " 축제명 : ${item.data5}"
            binding.passPassNameOut.text = "개최지역 : ${item.data7}"
            binding.passFestRangeOut.text = "패스명 : ${item.data1}"
            binding.passTimeOut.text = "패스 적용시작 : ${item.data4}부터 적용"


        }
        fun setStatusItem(item:FestManagerData){
            //binding.festNameOut.text = item.data1


        }

    }

}