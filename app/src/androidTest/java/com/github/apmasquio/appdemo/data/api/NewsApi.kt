package com.github.apmasquio.appdemo.data.api

import com.github.apmasquio.appdemo.data.models.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// Define the API endpoint interface
interface NewsApi {
    @GET("news?filter[category]=technology&sort=-publishedAt&per_page=10")
    suspend fun fetchTechNews(@Query("page") page: Int): List<NewsResponse>
}