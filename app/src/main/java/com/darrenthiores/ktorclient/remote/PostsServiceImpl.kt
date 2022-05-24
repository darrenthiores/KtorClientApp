package com.darrenthiores.ktorclient.remote

import com.darrenthiores.ktorclient.remote.model.PostRequest
import com.darrenthiores.ktorclient.remote.model.PostResponse
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

// unlike retrofit ktor need implementation
class PostsServiceImpl(
    private val client: HttpClient // to make a network call
): PostsService {
    override suspend fun getPosts(): List<PostResponse> =
        try {
            client.get {
                url(HttpRoutes.POSTS)
                // if there is parameter use
                // parameter("key", value)
            }
        } catch (e: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ClientRequestException) {
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ServerResponseException) {
            // 5xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: Exception) {
            // 6xx - responses
            println("Error: ${e.message}")
            emptyList()
        }

    override suspend fun createPost(postRequest: PostRequest): PostResponse? =
        try {
            client.post<PostResponse> {
                url(HttpRoutes.POSTS)
                contentType(ContentType.Application.Json) // to tell the server if it passing json data
                body = postRequest
            }
        } catch (e: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${e.response.status.description}")
            null
        } catch (e: ClientRequestException) {
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            null
        } catch (e: ServerResponseException) {
            // 5xx - responses
            println("Error: ${e.response.status.description}")
            null
        } catch (e: Exception) {
            // 6xx - responses
            println("Error: ${e.message}")
            null
        }
}