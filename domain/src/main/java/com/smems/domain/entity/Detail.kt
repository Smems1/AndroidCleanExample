package com.smems.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Detail(
    val id: Int,
    val title: String,
    val description: String,
    val address: String
) : Parcelable