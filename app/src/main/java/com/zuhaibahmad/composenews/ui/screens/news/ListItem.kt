package com.zuhaibahmad.composenews.ui.screens.news

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.drawOpacity
import androidx.ui.foundation.Box
import androidx.ui.foundation.Text
import androidx.ui.foundation.isSystemInDarkTheme
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Row
import androidx.ui.layout.padding
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.zuhaibahmad.composenews.data.AppNewsRepository
import com.zuhaibahmad.composenews.data.NewsItem
import com.zuhaibahmad.composenews.ui.ComposeNewsTheme

@Preview(showBackground = true)
@Composable
fun previewListItem() {
    val repository = AppNewsRepository()
    val newsItem = repository.getTopNews().first()

    ComposeNewsTheme {
        NewsListItem(
            newsItem = newsItem
        )
    }
}

@Composable
fun NewsListItemWithDivider(
    newsItem: NewsItem
) {
    Column {
        NewsListItem(
            newsItem = newsItem
        )
        NewsItemDivider()
    }
}

@Composable
fun NewsListItem(
    newsItem: NewsItem
) {
    Row {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            Column {
                NewsHeadline(title = newsItem.headline)
                NewsDescription(description = newsItem.description)
            }
        }
    }
}

@Composable
private fun NewsHeadline(title: String) {
    Text(
        text = title,
        modifier = Modifier.padding(top = 8.dp, end = 8.dp),
        style = TextStyle(fontSize = 24.sp),
        color = MaterialTheme.colors.onSurface,
        maxLines = 1
    )
}

@Composable
private fun NewsDescription(description: String) {
    Text(
        text = description,
        modifier = Modifier.padding(end = 8.dp) + Modifier.drawOpacity(0.54f),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.body1,
        color = MaterialTheme.colors.onSurface
    )
}

@Composable
private fun NewsItemDivider() {
    Divider(
        modifier = Modifier.drawOpacity(0.12f),
        color = if (isSystemInDarkTheme()) {
            Color.White
        } else {
            Color.Black
        }
    )
}
