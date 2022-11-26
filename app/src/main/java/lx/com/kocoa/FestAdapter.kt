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
            binding.pasFestNameOut.text = "${item.data5}"
            binding.passPassNameOut.text = "${item.data7}"
            binding.passFestRangeOut.text = "${item.data1}"
            binding.passTimeOut.text = "${item.data4}"


        }
        fun setStatusItem(item:FestManagerData){
            //binding.festNameOut.text = item.data1


        }

    }

}