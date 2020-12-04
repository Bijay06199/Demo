package com.example.gyankunj.ui.onBoarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gyankunj.R

class IntroSliderAdapter (private val introSlides: List<IntroSlide>):RecyclerView.Adapter<IntroSliderAdapter.IntroSlideViewHolder>(){


    inner class IntroSlideViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val textTitle=view.findViewById<TextView>(R.id.title_text)
        private val image=view.findViewById<ImageView>(R.id.slider_imageView)

        fun bind(introSlides: IntroSlide){
          textTitle.text=introSlides.title
            image.setImageResource(introSlides.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewHolder {
        return IntroSlideViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.intro_slides_layout,parent,false
        ))
    }

    override fun getItemCount(): Int =introSlides.size

    override fun onBindViewHolder(holder: IntroSlideViewHolder, position: Int) {
       holder.bind(introSlides[position])
    }


}
