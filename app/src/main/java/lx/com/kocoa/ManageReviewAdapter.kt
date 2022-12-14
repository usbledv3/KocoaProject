package lx.com.kocoa

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import lx.com.kocoa.databinding.ManagereviewItemBinding

class ManageReviewAdapter : RecyclerView.Adapter <ManageReviewAdapter.ViewHolder>(){
    var listener:OnManageReviewItemClickListener? = null
    private val context: Context? = null

//    interface OnItemClickListener {
//        fun onItemEditClick(data: ReviewData, pos: Int)
//        fun onItemDeleteClick(data: ReviewData, pos: Int)
//    }

//    private var clickListener: AdapterView.OnItemClickListener? = null
//    fun setOnItemClickListener(listener: AdapterView.OnItemClickListener) {
//        this.clickListener = listener
//    }

    // 각 아이템에 보여질 데이터를 담고 있는 것
//    var items = mutableListOf<ReviewData>()

    var items = ArrayList<ReviewData>()



    // 리싸이 클러뷰가 아이템 개수가 몇 개인지 물어 볼때
    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManageReviewAdapter.ViewHolder {
        val binding = ManagereviewItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ManageReviewAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.setData(item,position)

//        holder.run {
//            itemView.tag = items[position]
//
//            itemView.editButton?.setOnClickListener {
//                clickListener?.onItemEditClick(items[position], position)
//
//            }
//
//            itemView.deleteButton?.setOnClickListener {
//                reviewActivity
//            }
//        }
    }


    fun reviewDataDelete(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun reviewDataUpdate(pos: Int, usr: ReviewData) {
        items[pos] = usr
    }

    inner class ViewHolder(val binding: ManagereviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                listener?.onItemClick(this,binding.root,adapterPosition)
            }
        }

        private val reviewActivity=ReviewActivity.getInstance()
        var rReview: ReviewData? = null
        var rPosition: Int? = null


        init {
           // binding.editButton.setOnClickListener {
           //     val reviewIntent = Intent(reviewActivity,EditReviewActivity::class.java)
          //      reviewActivity?.reviewlauncher?.launch(reviewIntent)
//                reviewActivity?.editReview(rPosition!!,rReview!!)
    //        }
            binding.addOpinionButton.setOnClickListener {//신고하는 기능으로
                reviewDataDelete(rPosition!!)
                //Toast.makeText(context,"정상적으로 신고되었습니다.",Toast.LENGTH_SHORT).show() //들어가긴하는데 구동하면 팅김
            }
        }

        fun setData(item:ReviewData, position: Int) {
//            item.profile?.apply{
 //                   binding.profileView.setImageResource(this)
 //           }//
            binding.MreviewTitleOutput.text = item.title
            binding.MdateOutput.text = item.date
            binding.MnameOutput.text = item.name
            binding.MreviewTextOutput.text = item.text
            this.rReview=item
            this.rPosition=position
        }

    }
}