package com.zuhaibahmad.composenews.ui.router

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@ExperimentalCoroutinesApi
class AppRouter : Router {

    private val current = MutableStateFlow<RouterDestination>(RouterDestination.News)

    override val currentDestination: RouterDestination
        get() = current.value

    override val observeCurrentDestination: StateFlow<RouterDestination>
        get() = current

    override fun navigateTo(destination: RouterDestination) {
        current.value = destination
    }
}