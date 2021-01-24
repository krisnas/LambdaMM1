package com.krisna_18102271.ligartani

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_pembayaran.*

class PembayaranFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pembayaran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iv_bank.setOnClickListener {
            val i = activity?.supportFragmentManager?.beginTransaction()
            i?.replace(R.id.fl_fragment, DetailPembayaranFragment())
            i?.disallowAddToBackStack()
            i?.commit()
        }
    }
}