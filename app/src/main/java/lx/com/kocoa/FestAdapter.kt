package lx.com.kocoa

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lx.com.kocoa.databinding.FespassItemBinding

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
        if(PfchkData.chk==1) {
            holder.setpassItem(item1)//사전예약시스템 아이템 불러오기
        }
        if(PfchkData.chk==2) {
            holder.setRsvnItem(item2)//
        }
    }

    inner class ViewHolder(val binding: FespassItemBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                listener?.onItemClick(this, binding.root, adapterPosition)
            }
        }
        fun setpassItem(item:FestManagerData){
            binding.pasFestNameOut.text = "${item.data5}"
            binding.passPassNameOut.text = "${item.data7}"
            binding.passFestRangeOut.text = "${item.data1}"
            binding.passTimeOut.text = "${item.data4}"
        }
        fun setRsvnItem(item:FestManagerData){
            binding.pasFestNameOut.text = " ${item.data5}"
            binding.passPassNameOut.text = "${item.data1}"
            binding.passFestRangeOut.text = "${item.data3}"
            binding.passTimeOut.text = "${item.data4}부터 적용"
        }

    }

}