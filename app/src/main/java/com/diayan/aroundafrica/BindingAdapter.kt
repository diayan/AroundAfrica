package com.diayan.aroundafrica

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.diayan.aroundafrica.data.Places
import com.diayan.aroundafrica.ui.home.HomeAdapter

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl:String?){
    val imageUri = imageUrl!!.toUri().buildUpon().scheme("https").build()
    Glide.with(imageView.context)
        .load(imageUri)
        .into(imageView)
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, placesList: List<Places>){
    val adapter = recyclerView.adapter as HomeAdapter
    adapter.submitList(placesList)
}