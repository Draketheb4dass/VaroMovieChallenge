package com.jephtecolin.varomoviechallenge.ui

import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jephtecolin.varomoviechallenge.R
import timber.log.Timber

@BindingAdapter(value = ["imageUrl", "placeholder"], requireAll = false)
fun imageUrl(imageView: AppCompatImageView, imageUrl: String?, placeholder: Drawable?) {
    when (imageUrl) {
        null -> {
            Timber.d("Unsetting image url")
            Glide.with(imageView)
                .load(placeholder)
                .into(imageView)
        }
        "" ->{
            Timber.d("Unsetting image url")
            Glide.with(imageView)
                .load(placeholder)
                .into(imageView)
        }
        else -> {
            Glide.with(imageView)
                .load(imageUrl)
                .apply(RequestOptions().placeholder(placeholder))
                .into(imageView)
        }
    }
}

@BindingAdapter("setBookmarked")
fun setBookmarkIcon(imageView: AppCompatImageView, isBookmarked: Boolean) {
    if (isBookmarked) {
        imageView.setBackgroundResource(R.drawable.ic_bookmark_added_24)
    } else {
        imageView.setBackgroundResource(R.drawable.ic_bookmark_24)
    }
}