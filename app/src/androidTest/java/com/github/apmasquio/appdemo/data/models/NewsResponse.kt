package com.github.apmasquio.appdemo.data.models

import com.github.apmasquio.appdemo.data.api.NewsApi
import com.google.gson.annotations.SerializedName

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.io.Serializable

data class NewsResponse(
    @SerializedName("title") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("url") val url: String?,
    @SerializedName("urlToImage") val urlToImage: String?,
    @SerializedName("publishedAt") val publishedAt: String?
) : Serializable


//
//
//// Define the data class to parse the API response
//data class NewsResponse(
//    val articles: List<Article>,
//    val status: String,
//    val totalResults: Int
//)
//
//data class Article(
//    val title: String,
//    val description: String,
//    val url: String,
//    val urlToImage: String,
//    val publishedAt: String
//) {
//
//    // Define the Retrofit client
//    val retrofit = Retrofit.Builder()
//        .baseUrl("https://newsapi.org/v2/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    // Create an instance of the API endpoint interface
//    val newsApi = retrofit.create(NewsApi::class.java)
//
//    // Define the date range for the news search
//    val from = "2022-12-01"
//    val to = "2022-12-31"
//
//    // Parse the response
//    call.enqueue(
//    object : Callback<NewsResponse> {
//        override fun onResponse(
//            call: Call<NewsResponse>,
//            response: Response<NewsResponse>
//        ) {
//            val news = response.body()?.articles ?: emptyList()
//            // Do something with the news list
//        }
//
//        override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
//            // Handle the failure
//        }
//    })
//}