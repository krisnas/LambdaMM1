package com.krisna_18102271.ligartani.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.krisna_18102271.ligartani.KangkungDetailActivity
import com.krisna_18102271.ligartani.OrangeDetailActivity
import com.krisna_18102271.ligartani.R
import com.krisna_18102271.ligartani.StrawberryDetailActivity
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
        val txtTitlestr: TextView = item.findViewById(R.id.tv_strw)
        val txtDescriptionstr: TextView = item.findViewById(R.id.tv_descstrw)
        val cardViewTutorialStroberi: CardView = item.findViewById(R.id.cv_tutorialstroberi)

        val txtTitleora: TextView = item.findViewById(R.id.tv_orange)
        val txtDescriptionora: TextView = item.findViewById(R.id.tv_descorange)
        val cardViewTutorialJeruk: CardView = item.findViewById(R.id.cv_tutorialjeruk)

        val txtTitlekang: TextView = item.findViewById(R.id.tv_kangkung)
        val txtDescriptionkang: TextView = item.findViewById(R.id.tv_desckangkung)
        val cardViewTutorialKangkung: CardView = item.findViewById(R.id.cv_tutorialkangkung)

        fun bindmodel(t : Tutorial) {
            txtTitlestr.text = t.getTitle()
            txtDescriptionstr.text = t.getDescription()

            txtTitleora.text = t.getTitle()
            txtDescriptionora.text = t.getDescription()

            txtTitlekang.text = t.getTitle()
            txtDescriptionkang.text = t.getDescription()

            cardViewTutorialStroberi.setOnClickListener {
                var i = Intent(context, StrawberryDetailActivity::class.java)
                i.putExtra("title", t.getTitle())
                i.putExtra("description", t.getDescription())
                context.startActivity(i)
            }
            cardViewTutorialJeruk.setOnClickListener {
                var i = Intent(context, OrangeDetailActivity::class.java)
                i.putExtra("title", t.getTitle())
                i.putExtra("description", t.getDescription())
                context.startActivity(i)
            }
            cardViewTutorialKangkung.setOnClickListener {
                var i = Intent(context, KangkungDetailActivity::class.java)
                i.putExtra("title", t.getTitle())
                i.putExtra("description", t.getDescription())
                context.startActivity(i)
            }
        }

    }
}