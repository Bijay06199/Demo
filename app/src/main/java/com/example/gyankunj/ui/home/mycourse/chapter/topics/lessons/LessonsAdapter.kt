package com.example.gyankunj.ui.home.mycourse.chapter.topics.lessons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gyankunj.R
import com.example.gyankunj.databinding.PhysicsListItemBinding
import com.example.gyankunj.ui.home.mycourse.chapter.model.PhysicsListItemModel

class LessonsAdapter(private val listener:onItemClickListener):RecyclerView.Adapter<LessonsAdapter.LessonsViewHolder>() {
    var itemList=ArrayList<PhysicsListItemModel>()


    inner class LessonsViewHolder(var mBinding:PhysicsListItemBinding):RecyclerView.ViewHolder(mBinding.root)

    fun addAll(itemList:ArrayList<PhysicsListItemModel>){
        this.itemList=itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonsViewHolder {
        val mBinding:PhysicsListItemBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),
        R.layout.physics_list_item,parent,false)
        return LessonsViewHolder(mBinding)

    }

    override fun getItemCount(): Int =itemList.size

    override fun onBindViewHolder(holder: LessonsViewHolder, position: Int) {
        holder.mBinding.model=itemList[position]
        holder.mBinding.root.setOnClickListener {
            listener.onLessonsClick(holder.adapterPosition,itemList[holder.adapterPosition])
        }

    }

    interface onItemClickListener{
        fun onLessonsClick(position: Int,itemModel: PhysicsListItemModel)
    }


}