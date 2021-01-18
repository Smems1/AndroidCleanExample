package com.smems.androidcleanexample.base

import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.*
import com.google.android.material.snackbar.Snackbar

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, block: (result: T?) -> Unit) =
    liveData.observe(this, Observer(block))

inline fun <reified T : ViewModel> FragmentActivity.withViewModel(
    crossinline factory: () -> T, block: T.() -> Unit
): T {
    val vm = getViewModel(factory)
    vm.block()

    if (vm is LifecycleObserver)
        lifecycle.addObserver(vm)

    if (this is BaseActivity && vm is BaseViewModel)
        observe(vm.errors, ::onErrors)

    return vm
}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(crossinline body: () -> T): T {
    val a = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <VM : ViewModel?> create(modelClass: Class<VM>): VM = body() as VM
    }
    return ViewModelProvider(this, a)[T::class.java]
}

fun View.showMessage(text: String, @ColorRes color: Int? = null) =
    Snackbar.make(this, text, Snackbar.LENGTH_LONG).apply {
        if (color != null) {
            view.setBackgroundColor(ContextCompat.getColor(context, color))
        }
    }.show()