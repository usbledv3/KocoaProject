package lx.com.kocoa

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.review_item.view.*
import lx.com.kocoa.databinding.ReviewItemBinding
import java.lang.reflect.Member
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar.getInstance

class ReviewAdapter : RecyclerView.Adapter <ReviewAdapter.ViewHolder>(){
    var listener:OnReviewItemClickListener? = null

//    interface OnItemClickListener {
//        fun onItemEditClick(data: ReviewData, pos: Int)
//        fun onItemDeleteClick(data: ReviewData, pos: Int)
//    }

//    private var clickListener: AdapterView.OnItemClickListener? = null
//    fun setOnItemClickListener(listener: AdapterView.OnItemClickListener) {
//        this.clickListener = listener
//    }

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
        holder.setData(item,position)
    }

    fun reviewDataDelete(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun reviewDataUpdate(pos: Int, usr: ReviewData) {
        items[pos] = usr
    }

    inner class ViewHolder(val binding: ReviewItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val reviewActivity=ReviewActivity.getInstance()
        var rReview: ReviewData? = null
        var rPosition: Int? = null

        fun setData(item:ReviewData, position: Int) {
//            item.profile?.apply{
            //                   binding.profileView.setImageResource(this)
            //           }
            binding.reviewTitleOutput.text = item.title
            binding.dateOutput.text = item.date
            binding.nameOutput.text = item.name
            binding.reviewTextOutput.text = item.text
            this.rReview=item
            this.rPosition=position
        }

        init {
            binding.root.setOnClickListener {
                listener?.onItemClick(this,binding.root,adapterPosition)
            }

            binding.deleteButton.setOnClickListener {
                reviewDataDelete(rPosition!!)
            }
        }
    }
}