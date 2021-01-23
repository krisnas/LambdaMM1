package com.krisna_18102271.ligartani

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.krisna_18102271.ligartani.adapter.TutorialAdapter
import com.krisna_18102271.ligartani.model.Tutorial
import kotlinx.android.synthetic.main.fragment_tutorial.*

class TutorialFragment : Fragment() {

    lateinit var tutorialAdapter: TutorialAdapter
    val lm = LinearLayoutManager(activity)
    val addTutorialList: MutableList<Tutorial> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tutorial, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    fun initView() {
        rv_tutorial.layoutManager = lm
        tutorialAdapter = TutorialAdapter(activity!!)
        rv_tutorial.adapter = tutorialAdapter

        addTutorialList.add(Tutorial("Strawberry", "Ini adalah tutorial dari menanam strawberry"))
        tutorialAdapter.setTutorial(addTutorialList)
    }
}