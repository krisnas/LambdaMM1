package com.krisna_18102271.ligartani

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_konfirmasi_pembayaran.*

class KonfirmasiPembayaranFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_konfirmasi_pembayaran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_buy.setOnClickListener {
            val i = activity?.supportFragmentManager?.beginTransaction()
            i?.replace(R.id.fl_fragment, HomeFragment())
            i?.disallowAddToBackStack()
            i?.commit()
        }

        iv_back.setOnClickListener {
            val i = activity?.supportFragmentManager?.beginTransaction()
            i?.replace(R.id.fl_fragment, DetailPembayaranFragment())
            i?.disallowAddToBackStack()
            i?.commit()
        }
    }
}