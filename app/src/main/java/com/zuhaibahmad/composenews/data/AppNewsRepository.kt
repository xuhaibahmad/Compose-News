package com.zuhaibahmad.composenews.data

class AppNewsRepository : NewsRepository {
    override fun getTopNews(): List<NewsItem> {
        // TODO: Return actual data from remote
        return (1..5).map { i ->
            NewsItem(
                id = "n-$i",
                headline = "Headline - $i",
                description = "Description - $i"
            )
        }
    }
}