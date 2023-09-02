package com.dicoding.foodaplicationtegal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Food(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable