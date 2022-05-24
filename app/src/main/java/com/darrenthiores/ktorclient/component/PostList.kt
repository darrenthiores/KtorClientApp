package com.darrenthiores.ktorclient.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.darrenthiores.ktorclient.remote.model.PostResponse

@Composable
fun PostList(
    modifier: Modifier = Modifier,
    posts: List<PostResponse>
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(posts) { post ->
            PostItem(post = post)
        }
    }
}