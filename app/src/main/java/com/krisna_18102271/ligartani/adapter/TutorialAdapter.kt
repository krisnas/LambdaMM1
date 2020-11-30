package com.krisna_18102271.ligartani.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.krisna_18102271.ligartani.R
import com.krisna_18102271.ligartani.TutorialDetailActivity
import com.krisna_18102271.ligartani.model.Tutorial

class TutorialAdapter(val context: Context): RecyclerView.Adapter<TutorialAdapter.TutorialViewHolder>() {

    private val tutorials : MutableList<Tutorial> =  mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TutorialViewHolder {
        return TutorialViewHolder (LayoutInflater.from(context).inflate(R.layout.item_tutorial,parent, false))
    }

    override fun getItemCount(): Int {
        return tutorials.size
    }

    override fun onBindViewHolder(holder: TutorialAdapter.TutorialViewHolder, position: Int) {
        holder.bindmodel(tutorials[position])
    }

    fun setTutorial(data: List<Tutorial>) {
        tutorials.clear()
        tutorials.addAll(data)
        notifyDataSetChanged()

    }

    inner class TutorialViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val txtTitle: TextView = item.findViewById(R.id.tv_strw)
        val txtDescription: TextView = item.findViewById(R.id.tv_descstrw)
        val cardViewTutorial: CardView = item.findViewById(R.id.cv_tutorial)

        fun bindmodel(t : Tutorial) {
            txtTitle.text = t.getTitle()
            txtDescription.text = t.getDescription()

            cardViewTutorial.setOnClickListener {
                var i = Intent(context, TutorialDetailActivity::class.java)
                i.putExtra("title", t.getTitle())
                i.putExtra("descripstion", t.getDescription())
                context.startActivity(i)
            }
        }

    }
}