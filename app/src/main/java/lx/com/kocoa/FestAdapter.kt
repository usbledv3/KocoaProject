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
        holder.setItem(item)//
    }

    inner class ViewHolder(val binding: FespassItemBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                listener?.onItemClick(this, binding.root, adapterPosition)
            }
        }
        fun setpassItem(item:FestManagerData){
            binding.pasFestNameOut.text = "패스이름 : ${item.data1}"
            binding.passPassNameOut.text = "패스종류 : ${item.data2}"
            binding.passFestRangeOut.text = "패스적용 인원 : ${item.data3}"
            binding.passTimeOut.text = "${item.data4}부터 적용"


        }
        fun setItem(item:FestManagerData){
            //binding.festNameOut.text = item.data4


        }

    }

}