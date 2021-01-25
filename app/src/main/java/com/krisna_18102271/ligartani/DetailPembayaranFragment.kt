package com.krisna_18102271.ligartani

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_detail_pembayaran.*

class DetailPembayaranFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_pembayaran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backto.setOnClickListener {
            val i = activity?.supportFragmentManager?.beginTransaction()
            i?.replace(R.id.fl_fragment, PembayaranFragment())
            i?.disallowAddToBackStack()
            i?.commit()
        }

        btn_next.setOnClickListener {
            val i = activity?.supportFragmentManager?.beginTransaction()
            i?.replace(R.id.fl_fragment, KonfirmasiPembayaranFragment())
            i?.disallowAddToBackStack()
            i?.commit()
        }
    }
}