package com.github.apmasquio.appdemo.data.api.datasource

import com.github.apmasquio.appdemo.data.api.NewsApi
import com.github.apmasquio.appdemo.data.models.NewsResponse
import androidx.paging.PagingSource
import androidx.paging.PagingState

class NewsDataSource (private val api: NewsApi) : PagingSource<Int, NewsResponse>() {
    override fun getRefreshKey(state: PagingState<Int, NewsResponse>) = state.anchorPosition?.let {
        state.closestPageToPosition(it)?.prevKey?.plus(1) ?:
        state.closestPageToPosition(it)?.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsResponse> {
        val currentPage = params.key ?: INITIAL_PAGE
        return try {
            val response = api.fetchTechNews(page = currentPage)

            val nextKey = if (response.isEmpty()) {
                null
            } else {
                currentPage + (params.loadSize / PAGES_PER_LOAD)
            }

            LoadResult.Page(
                data = response,
                prevKey = if (currentPage == INITIAL_PAGE) null else currentPage,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    private companion object {
        private const val INITIAL_PAGE = 1
        private const val PAGES_PER_LOAD = 10
    }
}