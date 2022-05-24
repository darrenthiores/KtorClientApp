package com.darrenthiores.ktorclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.darrenthiores.ktorclient.component.PostList
import com.darrenthiores.ktorclient.remote.PostsService
import com.darrenthiores.ktorclient.remote.model.PostResponse
import com.darrenthiores.ktorclient.ui.theme.KtorClientTheme

class MainActivity : ComponentActivity() {

    private val service = PostsService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KtorClientTheme {
                val posts = produceState<List<PostResponse>>(
                    initialValue = emptyList(),
                    producer = {
                        value = service.getPosts()
                    }
                )

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PostList(posts = posts.value)
                }
            }
        }
    }
}