package com.example.gyankunj.ui.home.mycourse.chapter.topics.formulas.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gyankunj.R
import com.example.gyankunj.databinding.RecyclerviewFormulaLayoutBinding
import com.example.gyankunj.ui.home.mycourse.chapter.topics.formulas.model.FormulaModel

class FormulaAdapter: RecyclerView.Adapter<FormulaAdapter.FormulaBindViewHolder>() {

    var itemList=ArrayList<FormulaModel>()

    inner class FormulaBindViewHolder(var mBinding:RecyclerviewFormulaLayoutBinding):RecyclerView.ViewHolder(mBinding.root)

    fun addAll(itemList:ArrayList<FormulaModel>){
        this.itemList=itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormulaBindViewHolder {
        var binding:RecyclerviewFormulaLayoutBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),
        R.layout.recyclerview_formula_layout,parent,false)
        return FormulaBindViewHolder(binding)

    }

    override fun getItemCount(): Int=itemList.size

    override fun onBindViewHolder(holder: FormulaBindViewHolder, position: Int) {
        holder.mBinding.model=itemList[position]
    }

}