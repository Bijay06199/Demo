package com.example.gyankunj.ui.home.quiz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gyankunj.R
import com.example.gyankunj.databinding.RecyclerviewQuizSubjectBinding
import com.example.gyankunj.ui.home.quiz.model.QuizModel

class QuizAdapter( private val listener:onItemClickListener): RecyclerView.Adapter<QuizAdapter.BannerViewHolder>(){
    var itemList = ArrayList<QuizModel>()

    inner class BannerViewHolder(var mBinding: RecyclerviewQuizSubjectBinding): RecyclerView.ViewHolder(mBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        var binding: RecyclerviewQuizSubjectBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context)
            , R.layout.recyclerview_quiz_subject,parent,false)
        return BannerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.mBinding.model= this.itemList[position]
        holder.mBinding.root.setOnClickListener {
            listener.onCourseClickListener(holder.adapterPosition,itemList[holder.adapterPosition])
        }
    }

    fun addAll(itemList: ArrayList<QuizModel>){
        this.itemList= itemList
        notifyDataSetChanged()
    }
    interface onItemClickListener{
        fun onCourseClickListener(position: Int,itemList: QuizModel)
    }

}