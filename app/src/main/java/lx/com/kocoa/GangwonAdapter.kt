package lx.com.kocoa

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lx.com.kocoa.databinding.GangwonItemBinding
import lx.com.kocoa.databinding.SearchItemBinding

class GangwonAdapter : RecyclerView.Adapter<GangwonAdapter.ViewHolder>(){
    //각 아이템에 보여질 데이터를 담고 있는것
    var items = ArrayList<GangwonData>()

    var context: Context? = null

    var listener:OnGangwonItemClickListener? = null

    //리싸이클러뷰가 아이템 개수가 몇 개인지 물어볼때
    override fun getItemCount(): Int = items.size
    //각 아이템의 모양이 처음 만들어 질때
    override fun onCreateViewHolder(parent : ViewGroup, viewType:Int): GangwonAdapter.ViewHolder{
        val binding = GangwonItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }
    //이미 만들어진 아이템의 모양에 데이터만 설정할 때
    override fun onBindViewHolder(holder: GangwonAdapter.ViewHolder, position: Int){
        val item = items[position]
        holder.setItem(item)
    }
    //각 아이템의 모양을 재사용하기 위해 만들어진 것
    inner class ViewHolder(val binding: GangwonItemBinding):RecyclerView.ViewHolder(binding.root){
        //데이터 설정
        //하나의 아이템을 위한 데이터가 전달되었을 때 화면에 어떻게 표시할 지 설정
        fun setItem(item:GangwonData){
//            //이미지 표시하기
//            item.filepath1?.apply{
//                val uri = Uri.parse("http://172.30.1.30:8001${this}")
//                Glide.with(binding.productListImageView).load(uri).into(binding.productListImageView)
//            }
            //축제이름
            binding.gangwonListName.text = item.gangwonName
            //축제 포스터
            item.gangwonImage?.apply {
                binding.gangwonImageView.setImageResource(this)
            }
            //축제 기간
            binding.gangwonListDate.text = item.gangwonDate
            //축제 장소
            binding.gangwonListPlace.text = item.gangwonPlace
        }
        init {
            binding.root.setOnClickListener{
                listener?.onItemClick(this,binding.root,adapterPosition)
            }
        }
    }
}
