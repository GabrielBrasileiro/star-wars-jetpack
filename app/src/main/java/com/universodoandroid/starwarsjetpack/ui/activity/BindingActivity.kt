package com.universodoandroid.starwarsjetpack.ui.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BindingActivity<T : ViewDataBinding>(
    @LayoutRes val layoutResId: Int
) : AppCompatActivity(layoutResId) {

    protected lateinit var binding: T
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<T>(this, layoutResId)
    }
}