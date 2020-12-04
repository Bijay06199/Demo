package com.example.gyankunj.ui.home.mycourse.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gyankunj.R
import com.example.gyankunj.databinding.RecyclerviewChaptersLayoutBinding
import com.example.gyankunj.ui.home.mycourse.model.CourseChapterModel



class CourseAdapter(private val listener:onItemClickListener):RecyclerView.Adapter<CourseAdapter.PhysicsViewHolder>() {
    var itemList=ArrayList<CourseChapterModel>()

    inner class PhysicsViewHolder(var mBinding:RecyclerviewChaptersLayoutBinding):RecyclerView.ViewHolder(mBinding.root)

    fun addAll( itemList:ArrayList<CourseChapterModel>){
        this.itemList=itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhysicsViewHolder {
        var binding:RecyclerviewChaptersLayoutBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),
        R.layout.recyclerview_chapters_layout,parent,false)
        return PhysicsViewHolder(binding)

    }

    override fun getItemCount(): Int =itemList.size


    override fun onBindViewHolder(holder: PhysicsViewHolder, position: Int) {
        holder.mBinding.model=itemList[position]
        holder.mBinding.root.setOnClickListener {
            listener.onChapterClickListener(holder.adapterPosition,itemList[holder.adapterPosition])
        }
    }

    interface onItemClickListener{
        fun onChapterClickListener(position: Int,itemList: CourseChapterModel)
    }
}