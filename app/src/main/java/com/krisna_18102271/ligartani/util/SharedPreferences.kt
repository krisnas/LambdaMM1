package com.krisna_18102271.ligartani.util

import android.content.Context
import android.preference.PreferenceManager

class SharedPreferences(val context: Context) {
    companion object{
        private const val ST_INST = "ST_INST"
    }

    private val p = PreferenceManager.getDefaultSharedPreferences(context)

    var stInst = p.getBoolean(ST_INST, false)
    set(value) = p.edit().putBoolean(ST_INST, value).apply()
}