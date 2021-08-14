package com.rodrigo.nasaapi.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rodrigo.nasaapi.R
import com.rodrigo.nasaapi.api.Apod

class NasaRv: RecyclerView.Adapter<NasaRv.ViewHolder>() {

    private var apod = emptyList<Apod>()

    fun setData(newApod: List<Apod>) {
        apod  = newApod
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(response: Apod){
            itemView.apply {
                findViewById<TextView>(R.id.title).text = response.title
                findViewById<TextView>(R.id.explanation).text = response.explanation
                findViewById<TextView>(R.id.date).text = response.date
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val card = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_apod, parent, false)

        return ViewHolder(card)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        apod?.let {
            holder.bind(it[position])
        }
    }

    override fun getItemCount(): Int {
       return  apod.size
    }
}