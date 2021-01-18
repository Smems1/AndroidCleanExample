package com.smems.androidcleanexample

import android.app.Activity
import androidx.lifecycle.LiveData
import com.smems.androidcleanexample.base.App
import com.smems.androidcleanexample.base.BaseViewModel
import com.smems.domain.entity.Detail
import com.smems.domain.usecase.GetDetailsUseCase
import javax.inject.Inject

class MainViewModel(activity: Activity) : BaseViewModel(activity) {

    @Inject
    protected lateinit var getDetailsUseCase: GetDetailsUseCase

    init {
        App.applicationComponent.detailsComponent().inject(this)
    }

    val details: LiveData<List<Detail>> by lazy { getDetailsUseCase.execute(null) {} }
}