package lx.com.kocoa

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lx.com.kocoa.databinding.MiniGameItemBinding


class MiniGameAdapter : RecyclerView.Adapter<MiniGameAdapter.ViewHolder>() {

    // 각 아이템에 보여질 데이터를 담고 있는 것
    var items = ArrayList<MiniGameData>()
    var listener: OnMinigameItemClickListener? = null

    // 리싸이클러뷰가 아이템 개수가 몇 개인지 물어볼 때
    override fun getItemCount()= items.size

    // 각 아이템의 모양이 처음 만들어질 때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiniGameAdapter.ViewHolder {
        val binding = MiniGameItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    // 이미 만들어진 아이템의 모양에 데이터만 설정할 때
    override fun onBindViewHolder(holder: MiniGameAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

    // 각 아이템의 모양을 재사용하기 위해 만들어진 것
    inner class ViewHolder(val binding: MiniGameItemBinding) : RecyclerView.ViewHolder(binding.root) {

        // 데이터 설정
        // 하나의 아이템을 위한 데이터가 전달되었을 때 화면에 어떻게 표시할 지 설정
        fun setItem(item: MiniGameData) {

            // 게임 이미지
           item.minigameImage?.apply{
                binding.miniGameImage.setImageResource(this)
           }
            // 게임이름
            binding.gameName.text = item.gameName
        }
        init {
            binding.root.setOnClickListener {
                listener?.onMiniGameItemClick(this, binding.root, adapterPosition)
            }
        }


    }
}

