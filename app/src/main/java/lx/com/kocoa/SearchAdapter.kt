package lx.com.kocoa

import android.annotation.SuppressLint
import android.content.Context
import android.text.InputFilter
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.common.util.ArrayUtils.contains
import lx.com.kocoa.databinding.SearchItemBinding
import java.util.*
import java.util.regex.Pattern
import kotlin.collections.ArrayList


class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ViewHolder>(), Filterable{
    //각 아이템에 보여질 데이터를 담고 있는것
    var items = ArrayList<SearchData>()
    var itemsFilter: ArrayList<SearchData>? = ArrayList<SearchData>()
    init {
        itemsFilter!!.addAll(items)
    }


    var context: Context? = null

    var listener:OnSearchItemClickListener? = null


    fun setData(items: ArrayList<SearchData>) {
        this.items = items
        this.itemsFilter = items
        notifyDataSetChanged()
    }

    //리싸이클러뷰가 아이템 개수가 몇 개인지 물어볼때
    override fun getItemCount(): Int = items.size
    //각 아이템의 모양이 처음 만들어 질때
    override fun onCreateViewHolder(parent : ViewGroup, viewType:Int): SearchAdapter.ViewHolder{
        val binding = SearchItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }
    //이미 만들어진 아이템의 모양에 데이터만 설정할 때
    override fun onBindViewHolder(holder: SearchAdapter.ViewHolder, position: Int){
        val item = items[position]
        holder.setItem(item)
    }
    //각 아이템의 모양을 재사용하기 위해 만들어진 것
    inner class ViewHolder(val binding: SearchItemBinding):RecyclerView.ViewHolder(binding.root){
        //데이터 설정
        //하나의 아이템을 위한 데이터가 전달되었을 때 화면에 어떻게 표시할 지 설정
        fun setItem(item:SearchData){
//            //이미지 표시하기
//            item.filepath1?.apply{
//                val uri = Uri.parse("http://172.30.1.30:8001${this}")
//                Glide.with(binding.productListImageView).load(uri).into(binding.productListImageView)
//            }
            //축제이름
            binding.searchListName.text = item.searchName
            //축제 포스터
            item.searchImage?.apply {
                binding.searchImageView.setImageResource(this)
            }
            //축제 기간
            binding.searchListDate.text = item.searchDate
            //축제 장소
            binding.searchListPlace.text = item.searchPlace
        }
        init {
            binding.root.setOnClickListener{
                listener?.onItemClick(this,binding.root,adapterPosition)
            }
        }
    }

    override fun getFilter(): Filter {
        return object: Filter() {
                override fun performFiltering(constraint: CharSequence): FilterResults {
                    val charString = constraint.toString()

                    if (charString.isEmpty()) {
                        itemsFilter!!.clear()
                        itemsFilter!!.addAll(items)
                    } else {
                        val filteringList: ArrayList<SearchData> = ArrayList()

                        val koreanMatcher = KoreanMatcher()

                        for (item in items) {
                            if (koreanMatcher.matchKoreanAndConsonant(item.searchName, charString)) filteringList.add(item)
                            else { // 영어인 경우
                                if (item.searchName.lowercase(Locale.getDefault()).contains(charString.lowercase(Locale.getDefault()))) {
                                    filteringList.add(item)
                                }
                            }
                        }

                        itemsFilter!!.clear()
                        itemsFilter!!.addAll(filteringList)
                    }

                    val filterResults = FilterResults()
                    filterResults.values = itemsFilter
                    return filterResults
                }

                override fun publishResults(constraint: CharSequence, results: FilterResults) {
                    itemsFilter = results.values as ArrayList<SearchData>
                    notifyDataSetChanged()
                }
            }
    }
}
