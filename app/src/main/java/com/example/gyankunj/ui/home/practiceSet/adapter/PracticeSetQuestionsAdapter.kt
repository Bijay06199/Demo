package com.example.gyankunj.ui.home.practiceSet.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gyankunj.R
import com.example.gyankunj.databinding.RecyclerviewCourseLayoutBinding
import com.example.gyankunj.databinding.RecyclerviewPractiseSetQuestionsBinding
import com.example.gyankunj.ui.home.api.BannerRow
import com.example.gyankunj.ui.home.practiceSet.model.PracticeSetQuestionsModel

class PracticeSetQuestionsAdapter :RecyclerView.Adapter<PracticeSetQuestionsAdapter.QuestionsViewHolder>(){

    var itemList=ArrayList<PracticeSetQuestionsModel>()


    inner class QuestionsViewHolder(var mBinding:RecyclerviewPractiseSetQuestionsBinding):RecyclerView.ViewHolder(mBinding.root)

    fun addAll( itemList:ArrayList<PracticeSetQuestionsModel>){
        this.itemList=itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsViewHolder {
        var binding:RecyclerviewPractiseSetQuestionsBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),
        R.layout.recyclerview_practise_set_questions, parent,false)
        return QuestionsViewHolder(binding)
    }

    override fun getItemCount(): Int =itemList.size

    override fun onBindViewHolder(holder: QuestionsViewHolder, position: Int) {
          holder.mBinding.model=itemList[position]
    }
}