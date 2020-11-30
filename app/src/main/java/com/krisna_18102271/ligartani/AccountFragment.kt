package com.krisna_18102271.ligartani

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (R.layout.fragment_account)
        val button : Button = view.findViewById(R.id.btn_aboutus)

        btn_aboutus.setOnClickListener{
            val i = Intent(requireContext(), AboutUsActivity::class.java)
            startActivity(i)
        }
    }
}