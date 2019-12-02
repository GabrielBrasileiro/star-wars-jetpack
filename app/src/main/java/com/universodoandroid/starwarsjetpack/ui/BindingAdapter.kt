package com.universodoandroid.starwarsjetpack.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BindingAdapter<B : ViewDataBinding> : RecyclerView.Adapter<BindingAdapter<B>.BindingViewHolder<B>>() {

    @LayoutRes
    abstract fun getLayoutResId(): Int
    abstract fun onBindViewHolder(binding: B, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<B> {
        val view = LayoutInflater.from(parent.context).inflate(getLayoutResId(), parent, false)
        return BindingViewHolder(view)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<B>, position: Int) {
        holder.binding?.let { onBindViewHolder(it, position) }
    }

    inner class BindingViewHolder<B : ViewDataBinding>(view: View) : RecyclerView.ViewHolder(view) {
        val binding = DataBindingUtil.bind<B>(view)
    }

}
