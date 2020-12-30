package id.ac.amikom.apppanas.data.repository

import id.ac.amikom.apppanas.data.model.ActionState
import id.ac.amikom.apppanas.data.model.News
import id.ac.amikom.apppanas.data.remote.NewsService
import id.ac.amikom.apppanas.data.remote.RetrofitApi
import retrofit2.await
import java.lang.Exception

class NewsRepository {
    private val newsService: NewsService by lazy { RetrofitApi.newsService() }

    suspend fun listNews() : ActionState<List<News>> {
        return try {
            val list = newsService.listNews().await()
            ActionState(list.categories)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailNews(url: String) : ActionState<News> {
        return try {
            val list = newsService.detailNews(url).await()
            ActionState(list.categories.first())
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchNews(query: String) : ActionState<List<News>> {
        return try {
            val list = newsService.searchNews(query).await()
            ActionState(list.categories)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }
}