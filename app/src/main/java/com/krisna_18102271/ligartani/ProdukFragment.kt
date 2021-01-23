package com.krisna_18102271.ligartani

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.tv_kategori
import kotlinx.android.synthetic.main.fragment_home.tv_produk
import kotlinx.android.synthetic.main.fragment_home.tv_tutorial
import kotlinx.android.synthetic.main.fragment_produk.*

class ProdukFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_produk, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_produk.setOnClickListener {
            val i = activity?.supportFragmentManager?.beginTransaction()
            i?.replace(R.id.fl_fragment, ProdukFragment())
            i?.disallowAddToBackStack()
            i?.commit()
        }

        tv_kategori.setOnClickListener {
            val i = activity?.supportFragmentManager?.beginTransaction()
            i?.replace(R.id.fl_fragment, KategoriFragment())
            i?.disallowAddToBackStack()
            i?.commit()
        }

        tv_tutorial.setOnClickListener {
            val i = activity?.supportFragmentManager?.beginTransaction()
            i?.replace(R.id.fl_fragment, TutorialFragment())
            i?.disallowAddToBackStack()
            i?.commit()
        }

        btn_alattani.setOnClickListener {
            val i = activity?.supportFragmentManager?.beginTransaction()
            i?.replace(R.id.fl_fragment, AlatTaniFragment())
            i?.disallowAddToBackStack()
            i?.commit()
        }

        btn_pupuk.setOnClickListener {
            val i = activity?.supportFragmentManager?.beginTransaction()
            i?.replace(R.id.fl_fragment, PupukFragment())
            i?.disallowAddToBackStack()
            i?.commit()
        }
    }
}