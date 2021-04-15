package com.erasmogames.br.api.models

import com.erasmogames.br.domain.Pokemon
import com.erasmogames.br.domain.PokemonType


data class PokemonsApiResult(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Pokemon>
)

data class PokemonApiResult(
    val  id: Int,
    val name: String,
    val types: PokemonTypeSlot
)


data class PokemonTypeSlot(
    val slot: Int,
    val type: PokemonType
)