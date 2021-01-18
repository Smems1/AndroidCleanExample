package com.smems.androidcleanexample.base

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.smems.data.AnyError
import java.lang.IllegalStateException

abstract class BaseViewModel : AndroidViewModel {

    constructor(activity: Activity) : super(activity.application)
    constructor(fragment: Fragment) : this(fragment.activity ?: throw IllegalStateException())

    val errors by lazy { MutableLiveData<List<AnyError>>() }
}