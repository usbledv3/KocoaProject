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
        val item1 = items[position]
        val item2 = items[position]
        holder.setpassItem(item1)//사전예약시스템 아이템 불러오기
        holder.setRsvnItem(item2)//
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
        fun setRsvnItem(item:FestManagerData){
            binding.pasFestNameOut.text = " 축제이름 : ${item.data5}"
            binding.passPassNameOut.text = "패스이름 : ${item.data1}"
            binding.passFestRangeOut.text = "적용인원 : ${item.data3}"
            binding.passTimeOut.text = "패스 적용시작 : ${item.data4}부터 적용"


        }

    }

}