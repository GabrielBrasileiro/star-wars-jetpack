package com.universodoandroid.starwarsjetpack.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BindingFragment<T : ViewDataBinding>(
    @LayoutRes layoutResId: Int
) : NavigationFragment(layoutResId) {

    protected lateinit var binding: T
        private set

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DataBindingUtil.inflate<T>(inflater, layoutResId, container, false).apply { binding = this }.root
    }
}