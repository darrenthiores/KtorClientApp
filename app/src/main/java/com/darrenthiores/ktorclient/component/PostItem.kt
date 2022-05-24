package com.darrenthiores.ktorclient.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.darrenthiores.ktorclient.remote.model.PostResponse

@Composable
fun PostItem(
    modifier: Modifier = Modifier,
    post: PostResponse
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(
                1.5.dp,
                MaterialTheme.colors.primary
            )
    ){
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = post.title)
            Text(text = post.body)
        }
    }
}