package com.example.gyankunj.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gyankunj.R
import com.example.gyankunj.databinding.PracticeSetLayoutBinding
import com.example.gyankunj.ui.home.model.PracticeSetModel

class PracticeSetAdapter(private val listener:OnItemClickListener) :RecyclerView.Adapter<PracticeSetAdapter.PracticeSetViewHolder>(){

    var itemList=ArrayList<PracticeSetModel>()

    inner class PracticeSetViewHolder(var mBinding: PracticeSetLayoutBinding):RecyclerView.ViewHolder(mBinding.root)

    fun addAll(itemList:ArrayList<PracticeSetModel>){
        this.itemList=itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PracticeSetViewHolder {
        val binding:PracticeSetLayoutBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.practice_set_layout,parent,false)
        return PracticeSetViewHolder(binding)
    }

    override fun getItemCount(): Int=itemList.size

    override fun onBindViewHolder(holder: PracticeSetViewHolder, position: Int) {
        holder.mBinding.model=itemList[position]
        holder.mBinding.root.setOnClickListener {
          listener.onPracticeSetClicked(holder.adapterPosition,itemList[holder.adapterPosition])
        }
    }
    interface OnItemClickListener{
        fun onPracticeSetClicked(position: Int,itemList:PracticeSetModel)
    }
}