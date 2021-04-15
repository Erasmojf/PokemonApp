package com.erasmogames.br.api

import com.erasmogames.br.api.models.PokemonApiResult
import com.erasmogames.br.api.models.PokemonsApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {

    @GET("/pokemon")
    fun listPokemons(@Query("limit") limit: Int): Call<PokemonsApiResult>

    @GET("pokemon/{number}")
    fun getPokemon(number: Int): Call<PokemonApiResult>

}