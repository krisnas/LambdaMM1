package com.krisna_18102271.ligartani

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (R.layout.fragment_account)
        val button: Button = view.findViewById(R.id.btn_aboutus)

        btn_aboutus.setOnClickListener {
            val i = activity?.supportFragmentManager?.beginTransaction()
            i?.replace(R.id.fl_fragment, KontakFragment())
            i?.disallowAddToBackStack()
            i?.commit()
        }
        iv_setting.setOnClickListener {
            val i = Intent (requireActivity(), DashboardActivity::class.java)
            startActivity(i)
        }

        btn_troli.setOnClickListener {
            val i = Intent (requireActivity(), DashboardQuoteActivity::class.java)
            startActivity(i)
        }

        btn_cekkoneksi.setOnClickListener {
            val i = Intent (requireActivity(), CekKoneksiActivity::class.java)
            startActivity(i)
        }
    }
}