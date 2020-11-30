package com.krisna_18102271.ligartani

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_produk.setOnClickListener {
            val i = Intent(requireContext(), TutorialDetailActivity::class.java)
            startActivity(i)
        }

        btn_kategori.setOnClickListener {
            val i = Intent(requireContext(), KategoriFragment::class.java)
            startActivity(i)
        }

        btn_tutorial.setOnClickListener {
            val i = activity?.supportFragmentManager?.beginTransaction()
            i?.replace(R.id.fl_fragment, TutorialFragment())
            i?.disallowAddToBackStack()
            i?.commit()
        }
    }
}