package com.github.apmasquio.appdemo.data.repositoryimport

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.github.apmasquio.appdemo.data.api.datasource.NewsDataSource
import com.github.apmasquio.appdemo.data.api.NewsApi
import com.github.apmasquio.appdemo.data.models.NewsResponse
import com.github.apmasquio.appdemo.data.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MatchesRepositoryImpl @Inject constructor(
    private val api: NewsApi
) : NewsRepository {

    override suspend fun getMatches(): Flow<PagingData<NewsResponse>> = Pager(
        config = PagingConfig(
            pageSize = 10,
            prefetchDistance = 2
        ),
        pagingSourceFactory = {
            NewsDataSource(api)
        }
    ).flow
}