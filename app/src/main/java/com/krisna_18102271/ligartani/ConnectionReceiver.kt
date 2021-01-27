package com.krisna_18102271.ligartani

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

class ConnectionReceiver: BroadcastReceiver(){
    override fun onReceive(context: Context, intent: Intent?) {

        val isConnected = checkConnection(context)

        if(connectionReceiverListener != null)
            connectionReceiverListener!!.onNetworkConnectionChange(isConnected)
    }

    interface ConnectionReceiverListener{
        fun onNetworkConnectionChange(isConnected: Boolean)
    }

    companion object{
        var connectionReceiverListener: ConnectionReceiverListener? = null

        val isConnected: Boolean
        get() {
            val cm = LigarTani.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val activeNetwork = cm.activeNetworkInfo

            return (activeNetwork != null &&activeNetwork.isConnectedOrConnecting)

        }
    }

    private fun checkConnection(context: Context): Boolean {

        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = cm.activeNetworkInfo

        return (activeNetwork != null &&activeNetwork.isConnectedOrConnecting)



    }
}