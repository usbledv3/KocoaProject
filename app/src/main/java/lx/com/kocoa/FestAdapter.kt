package lx.com.kocoa

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lx.com.kocoa.databinding.FespassItemBinding
import lx.com.kocoa.databinding.FespassaddItemBinding
import lx.com.kocoa.databinding.FestinforItemBinding

class FestAdapter : RecyclerView.Adapter<FestAdapter.ViewHolder>(){
    var items = ArrayList<FestManagerData>()
    var listener:OnFestInforItemClickListener? = null
    var listener1:OnFestInforItemClickListener1? = null


    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FestAdapter.ViewHolder {
        if(PfchkData.chk==1){
            val binding = FespassItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }

        val binding = FespassItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: FestAdapter.ViewHolder, position:Int){
        val item1 = items[position]

        if(PfchkData.chk==1) {
            holder.setpassItem(item1)//사전예약시스템 아이템 불러오기
        }

    }

    inner class ViewHolder(val binding: FespassItemBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                listener?.onItemClick(this, binding.root, adapterPosition)
            }
        }
        fun setpassItem(item:FestManagerData){
            binding.pasFestNameOut.text = "${item.data5}" //축제이름
            binding.passPassNameOut.text = "${item.data7}" // 축제개최지역
            binding.passFestRangeOut.text = "${item.data1}" // 패스이름
            binding.passTimeOut.text = "${item.data4}" // 패스기간
        }

    }

}