package br.senai.sp.jandira.rickandmorty.model

data class Character(
    var id: Int = 0,
    var name: String = "",
    var status: String = "",
    var species: String = "",
    var type: String = "",
    var gender: String = "",
    var origin: Origin? = null,
    var location: Location? = null,
    var image: String = "",
    var episodes: List<String>? = null,
    var url: String = "",
    var created: String = ""
)
