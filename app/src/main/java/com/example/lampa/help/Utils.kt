package com.example.lampa.help

import com.example.lampa.model.NewsModel

fun handleClickUrl(model:NewsModel):String?{
    return if(model.clickUrl?.isNotEmpty() == true){
        model.clickUrl
    }else if(model.url?.isNotEmpty() == true){
        model.url
    }else{
        ""
    }
}