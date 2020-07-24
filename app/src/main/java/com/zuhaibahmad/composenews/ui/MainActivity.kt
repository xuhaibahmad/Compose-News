package com.zuhaibahmad.composenews.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.collectAsState
import androidx.ui.animation.Crossfade
import androidx.ui.core.setContent
import com.zuhaibahmad.composenews.data.AppNewsRepository
import com.zuhaibahmad.composenews.ui.router.AppRouter
import com.zuhaibahmad.composenews.ui.router.RouterDestination
import com.zuhaibahmad.composenews.ui.screens.news.NewsScreen
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {
    // TODO: Use DI
    private val router = AppRouter()
    private val repository = AppNewsRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContent()
        }
    }

    @Composable
    fun AppContent() {
        ComposeNewsTheme {
            val currentScreen = router
                .observeCurrentDestination
                .collectAsState(initial = router.currentDestination)
                .value

            Crossfade(current = currentScreen) { screen ->
                when (screen) {
                    is RouterDestination.News -> NewsScreen(
                        router = router,
                        repository = repository
                    )
                    is RouterDestination.NewsDetails -> TODO()
                }
            }
        }
    }
}
