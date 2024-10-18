package com.lokesh.tweetappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lokesh.tweetappcompose.remote.ApiService
import com.lokesh.tweetappcompose.ui.screens.CategoryScreen
import com.lokesh.tweetappcompose.ui.screens.ListScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var apiService: ApiService

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(title = {
                        Text(text = "Tweets")
                    })
                }
            ) {
                Box(modifier = Modifier.padding(it)) {
                    Navigate()
                }
            }
        }
    }
}

@Composable
private fun Navigate() {
    val naxController = rememberNavController()
    NavHost(navController = naxController, startDestination = "category") {
        composable(route = "category",
            ) {
            CategoryScreen {
                naxController.navigate("list/${it}")
            }
        }
        composable(
            route = "list/{category}",
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            }
            )
        ) {
            ListScreen()
        }
    }
}