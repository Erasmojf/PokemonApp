package com.erasmogames.br.api

import android.util.Log
import com.erasmogames.br.api.models.PokemonsApiResult
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


object PokemonRepository {
   private val service: PokemonService
   init {
       val retrofit = Retrofit.Builder()
           .baseUrl("https://pokeapi.co/api/v2/")
           .addConverterFactory(GsonConverterFactory.create())
           .build()

       service = retrofit.create(PokemonService::class.java)
   }

    fun listPokemons(limit: Int = 151): PokemonsApiResult? {
       val call = service.listPokemons(limit)
        return call.execute().body()

//        call.enqueue(object : Callback<PokemonsApiResult>{
//            override fun onResponse(
//                call: Call<PokemonsApiResult>,
//                response: Response<PokemonsApiResult>
//            ) {
//                if(response.isSuccessful){
//                    val body = response.body()
//
//                    body?.results?.let {
//                        Log.d("POKEMON_API", it[0].name)
//                    }
//                }
//                Log.d("POKEMON_API", "Sucesso")
//          }
//
//            override fun onFailure(call: Call<PokemonsApiResult>, t: Throwable) {
//                Log.e("POKEMON_API", "Deu ruim ao carregar lista dos pokemons...", t)
//            }
//
//        })
    }
}