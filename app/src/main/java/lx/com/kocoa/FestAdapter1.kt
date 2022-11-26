package lx.com.kocoa

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lx.com.kocoa.databinding.FespassItemBinding
import lx.com.kocoa.databinding.FespassaddItemBinding
import lx.com.kocoa.databinding.FestinforItemBinding

class FestAdapter1 : RecyclerView.Adapter<FestAdapter1.ViewHolder>(){
    var items = ArrayList<FestManagerData>()
    var listener:OnFestInforItemClickListener? = null
    var listener1:OnFestInforItemClickListener1? = null


    override fun getItemCount() = items.size



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FestAdapter1.ViewHolder {
        if(PfchkData.chk==2){
            val binding = FespassaddItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }
        val binding = FespassaddItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FestAdapter1.ViewHolder, position:Int){
        val item2 = items[position]

        if(PfchkData.chk==2) {
            holder.setRsvnItem(item2)//
        }
    }

    inner class ViewHolder(val binding: FespassaddItemBinding):RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                listener1?.onItemClick1(this, binding.root, adapterPosition)
            }
        }
        fun setRsvnItem(item:FestManagerData){
            binding.pasFestANameOut.text = " ${item.data5}" //축제이름
            binding.passPassANameOut.text = "${item.data1}" //패스이름
            binding.passFestARangeOut.text = "${item.data3}" //패스적용인원
            binding.passATimeOut.text = "${item.data4}부터 적용" //패스기간
        }

    }

}