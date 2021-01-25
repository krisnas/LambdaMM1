package com.krisna_18102271.ligartani.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SettingModel (
        var name: String? = null,
        var email: String? = null,
        var age: Int = 0,
        var phoneNumber: String? = null,
        var gender: String? = null,
        var address: String? = null,
        var isDarkTheme: Boolean = false
): Parcelable
