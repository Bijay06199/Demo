package com.example.gyankunj.ui.home.noticeBoard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gyankunj.R
import com.example.gyankunj.databinding.RecyclerviewNoticeBoardBinding
import com.example.gyankunj.ui.home.noticeBoard.model.NoticeBoardModel

class NoticeBoardAdapter(private val listener:OnItemClickListener) :RecyclerView.Adapter<NoticeBoardAdapter.NoticeBoardViewHolder>(){
    var itemList=ArrayList<NoticeBoardModel>()

    inner class NoticeBoardViewHolder(var mBinding:RecyclerviewNoticeBoardBinding):RecyclerView.ViewHolder(mBinding.root)

    fun addAll(itemList:ArrayList<NoticeBoardModel>){
        this.itemList=itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeBoardViewHolder {
        val binding:RecyclerviewNoticeBoardBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),
        R.layout.recyclerview_notice_board,parent,false)
        return NoticeBoardViewHolder(binding)
    }

    override fun getItemCount(): Int =itemList.size

    override fun onBindViewHolder(holder: NoticeBoardViewHolder, position: Int) {
        holder.mBinding.model=itemList[position]
        holder.mBinding.root.setOnClickListener{
            listener.onBoardItemClickListener(holder.adapterPosition,itemList[holder.adapterPosition])
        }
    }

    interface OnItemClickListener{
        fun onBoardItemClickListener(position: Int,itemList:NoticeBoardModel)
    }

}
