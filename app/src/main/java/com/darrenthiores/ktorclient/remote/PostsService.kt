package com.darrenthiores.ktorclient.remote

import com.darrenthiores.ktorclient.remote.model.PostRequest
import com.darrenthiores.ktorclient.remote.model.PostResponse
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface PostsService {

    suspend fun getPosts(): List<PostResponse>

    suspend fun createPost(postRequest: PostRequest): PostResponse?

    // for learn purpose only! better use dependency injection
    companion object { // to get postService / postServiceImpl
        fun create(): PostsService =
            PostsServiceImpl(client = HttpClient(Android) {
                // we install features in this lambda block

                // this feature is optional
                install(Logging) { // if you want to configure the feature use lambda block
                    level = LogLevel.ALL
                }

                // necessary feature
                install(JsonFeature) {
                    serializer = KotlinxSerializer()
                }
            })
    }

}