package com.zuhaibahmad.composenews.data

interface NewsRepository {
    fun getTopNews(): List<NewsItem>
}