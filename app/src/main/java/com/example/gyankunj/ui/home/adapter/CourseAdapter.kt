package com.example.gyankunj.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gyankunj.R
import com.example.gyankunj.databinding.RecyclerviewCourseLayoutBinding
import com.example.gyankunj.ui.home.api.BannerRow

class CourseAdapter( private val listener: onItemClickListener): RecyclerView.Adapter<CourseAdapter.BannerViewHolder>(){
    var itemList = ArrayList<BannerRow>()

    inner class BannerViewHolder(var mBinding: RecyclerviewCourseLayoutBinding): RecyclerView.ViewHolder(mBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        var binding: RecyclerviewCourseLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context)
            , R.layout.recyclerview_course_layout,parent,false)
        return BannerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.mBinding.model=itemList[position]
        holder.mBinding.root.setOnClickListener {
            listener.onCourseClickListener(holder.adapterPosition,itemList[holder.adapterPosition])
        }
    }

    fun addAll(itemList: ArrayList<BannerRow>){
        this.itemList= itemList
        notifyDataSetChanged()
    }
    interface onItemClickListener{
        fun onCourseClickListener(position: Int,itemList: BannerRow)
    }

}