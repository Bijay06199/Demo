package com.example.gyankunj.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gyankunj.R
import com.example.gyankunj.databinding.BannerLayoutBinding
import com.example.gyankunj.ui.home.api.BannerRow

class BannerAdapter( var context: Context):RecyclerView.Adapter<BannerAdapter.BannerViewHolder>(){
    var itemList = ArrayList<BannerRow>()

    inner class BannerViewHolder(var mBinding: BannerLayoutBinding):RecyclerView.ViewHolder(mBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
         var binding:BannerLayoutBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context)
            ,R.layout.banner_layout,parent,false)
        return BannerViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return itemList.size
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
     holder.mBinding.model= this.itemList[position]
    }

    fun addAll(itemList: ArrayList<BannerRow>){
        this.itemList= itemList
        notifyDataSetChanged()
    }

}