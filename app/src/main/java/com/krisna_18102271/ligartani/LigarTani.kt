package com.krisna_18102271.ligartani

import android.app.Application

class LigarTani: Application(){

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun setConnectionListener(listener: ConnectionReceiver.ConnectionReceiverListener){
        ConnectionReceiver.connectionReceiverListener = listener
    }

    companion object{
        @get:Synchronized
        lateinit var instance:LigarTani
    }

}