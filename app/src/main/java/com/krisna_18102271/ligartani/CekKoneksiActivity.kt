package com.krisna_18102271.ligartani

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_cek_koneksi.*

class CekKoneksiActivity : AppCompatActivity(),ConnectionReceiver.ConnectionReceiverListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cek_koneksi)
        supportActionBar?.hide()

        baseContext.registerReceiver(ConnectionReceiver(), IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        LigarTani.instance.setConnectionListener(this)
    }

    override fun onNetworkConnectionChange(isConnected: Boolean) {
        if (isConnected) {
            connected.visibility = View.VISIBLE
            not_connected.visibility = View.INVISIBLE
        }else{
            connected.visibility = View.INVISIBLE
            not_connected.visibility = View.VISIBLE
        }
    }
}