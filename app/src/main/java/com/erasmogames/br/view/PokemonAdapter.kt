package com.erasmogames.br.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.erasmogames.br.R
import com.erasmogames.br.domain.Pokemon

class PokemonAdapter(private val items: List<Pokemon>)
    : RecyclerView.Adapter<PokemonAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val item = items[position]
        holder.binView(item)
    }

    override fun getItemCount() = items.size

    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
          fun binView(item: Pokemon) =  with(itemView){
                       val tvName = findViewById<TextView>(R.id.tvName)
                       val tvNumber = findViewById<TextView>(R.id.tvNumber)
                       val tvType1 = findViewById<TextView>(R.id.tvType1)
                       val tvType2 = findViewById<TextView>(R.id.tvType2)


                        tvNumber.text = "Nº ${item.formattedNumber}"
              tvName.text = item.name
              tvType1.text = item.types[0].name

              if(item.types.size > 1){
                  tvType2.visibility = View.VISIBLE
                  tvType2.text = item.types[1].name
              }else{
                  tvType2.visibility = View.GONE
              }
          }
    }


}