package com.lokesh.tweetappcompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lokesh.tweetappcompose.models.Tweet
import com.lokesh.tweetappcompose.response.GetTweetsResponse
import com.lokesh.tweetappcompose.viewmodel.TweetsViewModel

@Preview(name = "preview_list", showBackground = true, showSystemUi = true)
@Composable
private fun PreviewList() {
    //ListScreen()
}

@Composable
fun ListScreen() {

    val tweetsViewModel : TweetsViewModel = hiltViewModel()
    val tweets : State<ArrayList<Tweet>?> = tweetsViewModel.tweets.collectAsState()

    if (!tweets.value.isNullOrEmpty()){
        LazyColumn(content = {
            val twt = tweets.value
            if (!twt.isNullOrEmpty()){
                items(twt){
                    ListItem(tweet = it)
                }
            }
        })
    }else{
        Box(modifier = Modifier.fillMaxSize(1f), contentAlignment = Alignment.Center) {
            Text(text = "Loading...", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
private fun ListItem(tweet: Tweet) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(1f),
        shape = RoundedCornerShape(7.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Text(text = tweet.tweet ?: "", fontWeight = FontWeight.Normal, fontSize = 16.sp, modifier = Modifier.padding(10.dp))
    }
}