package br.senai.sp.jandira.rickandmorty.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//Esse arquivo que vai pro backend e requisitar os coiso
class RetrofitFactory {

    private val baseUrl = "https://rickandmortyapi.com/api/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCharacterService(): CharacterService{
        return retrofitFactory.create(CharacterService::class.java)
    }
}