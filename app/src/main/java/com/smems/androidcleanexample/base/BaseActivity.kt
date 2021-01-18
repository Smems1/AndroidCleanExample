package com.smems.androidcleanexample.base

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.smems.data.AnyError

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val fragmentContainerId: Int

    open fun start(
        fragment: Fragment, toBackStack: Boolean = false,
        container: Int = fragmentContainerId, vararg sharedViews: View
    ) {
        supportFragmentManager
            .beginTransaction()
            .apply {
                if (toBackStack)
                    addToBackStack(fragment.javaClass.name)
                replace(container, fragment)
            }.commitAllowingStateLoss()
    }

    fun onErrors(errors: List<AnyError>?) {
        errors?.forEach { onError(it) }
    }

    protected open fun onError(error: AnyError) {
        viewForError()?.showMessage(error.getString(this))
    }

    protected abstract fun viewForError(): View?
}