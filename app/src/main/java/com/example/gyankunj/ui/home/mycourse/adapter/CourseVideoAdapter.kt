package com.example.gyankunj.ui.home.mycourse.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gyankunj.R
import com.example.gyankunj.databinding.RecyclerviewVideosLayoutBinding
import com.example.gyankunj.ui.home.mycourse.model.CourseVideosModel

class CourseVideoAdapter(private val listener:onItemClickListener): RecyclerView.Adapter<CourseVideoAdapter.PhysicsVideoViewHolder>() {
    var itemList=ArrayList<CourseVideosModel>()

    inner class PhysicsVideoViewHolder(var mBinding: RecyclerviewVideosLayoutBinding): RecyclerView.ViewHolder(mBinding.root)

    fun addAll( itemList:ArrayList<CourseVideosModel>){
        this.itemList=itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhysicsVideoViewHolder {
        var binding: RecyclerviewVideosLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recyclerview_videos_layout,parent,false)
        return PhysicsVideoViewHolder(binding)

    }

    override fun getItemCount(): Int =itemList.size


    override fun onBindViewHolder(holder: PhysicsVideoViewHolder, position: Int) {
        holder.mBinding.model=itemList[position]
        holder.mBinding.root.setOnClickListener {
            listener.onVideoClickListener(holder.adapterPosition,itemList[holder.adapterPosition])
        }
    }

    interface onItemClickListener{
        fun onVideoClickListener(position: Int,itemList: CourseVideosModel)
    }
}