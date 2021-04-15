package com.erasmogames.br.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erasmogames.br.R
import com.erasmogames.br.api.PokemonRepository

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         recyclerView = findViewById(R.id.rvPokemons)


       Thread(Runnable {
           loadPokemons()
       }).start()

    }

    private fun loadPokemons() {

        val pokemonsApiResult = PokemonRepository.listPokemons()

        pokemonsApiResult?.results?.let {

            val layoutManager = LinearLayoutManager(this)
            recyclerView.post{
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = PokemonAdapter(it)
            }
        }
        }

}