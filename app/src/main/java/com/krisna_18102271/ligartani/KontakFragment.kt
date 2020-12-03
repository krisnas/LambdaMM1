package com.krisna_18102271.ligartani

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_kontak.*

class KontakFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kontak, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iv_lokasi.setOnClickListener {
            val i = Intent(getActivity(), MapsActivity::class.java)
            startActivity(i)
        }

        iv_telpon.setOnClickListener{
            val phone = "0281-681773"
            val i = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
            startActivity(i)
        }
        iv_pesananda.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse("https://bit.ly/2VvM3gi")
            startActivity(i)
        }
    }
}