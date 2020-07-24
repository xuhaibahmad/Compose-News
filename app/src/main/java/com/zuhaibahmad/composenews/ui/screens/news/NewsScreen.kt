package com.zuhaibahmad.composenews.ui.screens.news

import androidx.compose.Composable
import androidx.compose.frames.ModelList
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Text
import androidx.ui.foundation.clickable
import androidx.ui.foundation.lazy.LazyColumnItems
import androidx.ui.layout.Column
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.material.TopAppBar
import androidx.ui.tooling.preview.Preview
import com.zuhaibahmad.composenews.data.AppNewsRepository
import com.zuhaibahmad.composenews.data.NewsItem
import com.zuhaibahmad.composenews.data.NewsRepository
import com.zuhaibahmad.composenews.ui.ComposeNewsTheme
import com.zuhaibahmad.composenews.ui.router.AppRouter
import com.zuhaibahmad.composenews.ui.router.Router
import com.zuhaibahmad.composenews.ui.router.RouterDestination

private val newsItems = ModelList<NewsItem>()

@Preview
@Composable
fun previewNewsScreen() {
    ComposeNewsTheme {
        NewsScreen(
            router = AppRouter(),
            repository = AppNewsRepository()
        )
    }
}

@Composable
fun NewsScreen(
    router: Router,
    repository: NewsRepository
) {
    newsItems.clear()
    newsItems.addAll(
        repository.getTopNews()
    )

    NewsScreenUI(
        router = router,
        newsItems = newsItems
    )
}

@Composable
fun NewsScreenUI(
    router: Router,
    newsItems: ModelList<NewsItem>
) {
    Surface {
        Column {
            NewsAppBar()
            NewsList(
                newsItems = newsItems,
                onNewsClicked = { onNewsClicked(router, it) }
            )
        }
    }
}

@Composable
fun NewsAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "Compose News",
                style = MaterialTheme.typography.h6.copy(
                    color = MaterialTheme.colors.onPrimary
                )
            )
        },
        backgroundColor = MaterialTheme.colors.primary,
        actions = {
        }
    )
}

@Composable
fun NewsList(
    newsItems: ModelList<NewsItem>,
    onNewsClicked: (NewsItem) -> Unit
) {
    LazyColumnItems(
        items = newsItems
    ) { newsItem ->
        Box(
            modifier = Modifier.clickable(
                onClick = {
                    onNewsClicked(newsItem)
                }
            )
        ) {
            NewsListItemWithDivider(
                newsItem = newsItem
            )
        }
    }
}

private fun onNewsClicked(router: Router, newsItem: NewsItem) {
    router.navigateTo(RouterDestination.NewsDetails(newsItem.id))
}