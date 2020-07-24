package com.zuhaibahmad.composenews.ui.router

sealed class RouterDestination {
    object News : RouterDestination()
    data class NewsDetails(val newsId: String) : RouterDestination()
}