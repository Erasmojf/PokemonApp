package com.erasmogames.br.domain

data class Pokemon(
        val imageUrl: String? = null,
        val number: Int? = null,
        val name: String,
        val url: String,
        val types: List<PokemonType>? = null

)
{
    val formattedNumber = number.toString().padStart(3,'0')
}
