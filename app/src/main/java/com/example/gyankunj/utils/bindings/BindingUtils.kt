package com.example.gyankunj.utils.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.with
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey
import com.example.gyankunj.R

object BindingUtils {
    @BindingAdapter("imageSrc")
    @JvmStatic
    fun setImageSrc(imageView: ImageView, imageSrc: String?) {
        with(imageView) {
            GlideApp.with(context)
                .load(imageSrc)
                .apply(RequestOptions()
                    .placeholder(R.color.background_fade_color)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                )

                .into(imageView)
        }
//
//        GlideApp.with(imageView)
//            .load(imageSrc)
//            .placeholder(R.color.background_fade_color)
//            .error(R.color.background_fade_color)
//            .into(imageView)
    }

    @BindingAdapter("intImageSrc")
    @JvmStatic
    fun setImageSrc(imageView:ImageView,imageSrc:Int){
        imageView.setImageResource(imageSrc)
    }




    }
