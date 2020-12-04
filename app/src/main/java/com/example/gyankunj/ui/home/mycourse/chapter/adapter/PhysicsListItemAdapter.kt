package com.example.gyankunj.ui.home.mycourse.chapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gyankunj.R
import com.example.gyankunj.databinding.PhysicsListItemBinding
import com.example.gyankunj.ui.home.mycourse.chapter.model.PhysicsListItemModel

class PhysicsListItemAdapter(private val listener:onItemClickListener):RecyclerView.Adapter<PhysicsListItemAdapter.PhysicsListViewHolder>() {
    var itemList=ArrayList<PhysicsListItemModel>()

    inner class PhysicsListViewHolder(var mBinding: PhysicsListItemBinding):RecyclerView.ViewHolder(mBinding.root)

    fun addAll(itemList:ArrayList<PhysicsListItemModel>){
        this.itemList=itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhysicsListViewHolder {
        val mBinding:PhysicsListItemBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),
        R.layout.physics_list_item,parent,false)
        return PhysicsListViewHolder(mBinding)
    }

    override fun getItemCount(): Int =itemList.size

    override fun onBindViewHolder(holder: PhysicsListViewHolder, position: Int) {
       holder.mBinding.model=itemList[position]
        holder.mBinding.root.setOnClickListener {
            listener.onTopicsClick(holder.adapterPosition,itemList[holder.adapterPosition])
        }


    }

    interface onItemClickListener{
        fun onTopicsClick(position: Int,itemList: PhysicsListItemModel)
    }
}