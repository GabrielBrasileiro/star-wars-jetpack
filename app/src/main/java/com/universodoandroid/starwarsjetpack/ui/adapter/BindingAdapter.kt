package com.universodoandroid.starwarsjetpack.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BindingAdapter<B : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int
) : RecyclerView.Adapter<BindingAdapter<B>.BindingViewHolder<B>>() {

    abstract fun onBindViewHolder(binding: B, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<B> {
        val view = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        return BindingViewHolder(view)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<B>, position: Int) {
        holder.binding?.run { onBindViewHolder(this, position) }
    }

    inner class BindingViewHolder<B : ViewDataBinding>(view: View) : RecyclerView.ViewHolder(view) {
        val binding = DataBindingUtil.bind<B>(view)
    }
}
