package com.lx.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lx.com.kocoa.OnPointShopClickListner
import lx.com.kocoa.databinding.PointshopItemBinding

class PointShopAdapter : RecyclerView.Adapter<PointShopAdapter.ViewHolder>() {
    // 각 아이템에 보여질 데이터를 담고 있는 것
    var items = ArrayList<PointShopData>()

    var listener: OnPointShopClickListner? = null

    // 리싸이클러뷰가 아이템 갯수가 몇개인지 물어볼 때 / 아이템몇개 가지고있는지 알수있는 함수
    override fun getItemCount() = items.size

    // 각 아이템의 모양이 처음 만들어질 때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointShopAdapter.ViewHolder {
        val binding = PointshopItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // 이미 만들어진 아이템의 모양에 데이터만 설정할 때
    override fun onBindViewHolder(holder: PointShopAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }
    //각 아이템의 모양을 재사용 하기위해 만들어진것
    inner class ViewHolder(val binding: PointshopItemBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener{
                listener?.onItemClick(this, binding.root, adapterPosition)
            }
        }

        // 데이터 설정
        fun setItem(item: PointShopData) {
            // 이미지 표시하기
            item.profile?.apply {
                binding.profileView.setImageResource(this)
            }
            // 이름 표시하기
            binding.nameOutput.text = item.name

            // 가격 표시하기
            binding.priceOutput.text = item.price

            // 버튼 표시하기
            binding.pointButton.setOnClickListener {
                println("버튼 로그 찍었음")
            }
        }
    }

}