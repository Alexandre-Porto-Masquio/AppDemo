package com.github.apmasquio.appdemo.data.repository

import androidx.paging.PagingData
import com.github.apmasquio.appdemo.data.models.NewsResponse
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getMatches(): Flow<PagingData<NewsResponse>>
}