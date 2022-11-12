package lx.com.kocoa

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lx.com.kocoa.databinding.ReviewItemBinding

class ReviewAdapter : RecyclerView.Adapter <ReviewAdapter.ViewHolder>(){

    // 각 아이템에 보여질 데이터를 담고 있는 것
    var items = ArrayList<ReviewData>()

    // 리싸이 클러뷰가 아이템 개수가 몇 개인지 물어 볼때
    override fun getItemCount() = items.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewAdapter.ViewHolder {
        val binding = ReviewItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)

    }

    inner class ViewHolder(val binding: ReviewItemBinding) : RecyclerView.ViewHolder(binding.root) {



        fun setItem(item:ReviewData) {
                item.profile?.apply{
                    binding.profileView.setImageResource(this)
                }
                binding.titleOutput.text = item.title
                binding.dateOutput.text = item.date
                binding.nameOutput.text = item.name
                binding.textOutput.text = item.text
        }
    }
}