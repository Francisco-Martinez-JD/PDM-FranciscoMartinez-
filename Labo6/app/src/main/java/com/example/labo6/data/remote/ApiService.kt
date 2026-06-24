package com.example.labo6.data.remote

import com.example.labo6.data.model.Meal
import retrofit2.http.GET

interface ApiService {

    @GET("/api/json/v1/1/search.php?s=Arrabiata")
    suspend fun getMeal(): List<Meal>
}