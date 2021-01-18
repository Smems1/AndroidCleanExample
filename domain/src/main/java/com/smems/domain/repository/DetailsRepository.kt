package com.smems.domain.repository

import androidx.lifecycle.LiveData
import com.smems.domain.entity.Detail

interface DetailsRepository {
    fun getAll(): LiveData<List<Detail>>
}