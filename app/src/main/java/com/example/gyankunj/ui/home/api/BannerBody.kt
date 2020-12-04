package com.example.gyankunj.ui.home.api

import com.google.gson.annotations.SerializedName

data class BannerBody(@SerializedName("name")var name:String, @SerializedName("image")var image:String){
    override fun toString(): String {
        return " {\"name\" :\"$name\" : \"image\" : \"$image\" }"
    }
}