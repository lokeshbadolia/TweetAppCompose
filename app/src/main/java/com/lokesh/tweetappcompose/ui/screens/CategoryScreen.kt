package com.lokesh.tweetappcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lokesh.tweetappcompose.R
import com.lokesh.tweetappcompose.response.GetCategoriesResponse
import com.lokesh.tweetappcompose.viewmodel.CategoriesViewModel


@Preview(name = "preview_category", showSystemUi = true, showBackground = true)
@Composable
private fun PreviewCategory() {
    //CategoryItem("hfj")
}

@Composable
fun CategoryScreen(onClick: (category: String) -> Unit) {

    val categoriesViewModel : CategoriesViewModel = hiltViewModel()
    val categories : State<GetCategoriesResponse?> = categoriesViewModel.categories.collectAsState()

    if (categories.value != null){
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            val cat = categories.value?.categories
            if (!cat.isNullOrEmpty()){
                items(cat){
                    CategoryItem(category = it, onClick = onClick)
                }
            }
        }
    }else{
        Box(modifier = Modifier.fillMaxSize(1f), contentAlignment = Alignment.Center) {
            Text(text = "Loading...", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
private fun CategoryItem(category: String, onClick: (category: String) -> Unit) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .clickable { onClick(category) }
            .size(160.dp)
            .clip(RoundedCornerShape(8.dp))
            .paint(
                painter = painterResource(id = R.drawable.ic_bg),
                contentScale = ContentScale.Crop
            )
            .border(1.dp, Color(0xFFEEEEEE)),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(text = category,
            fontSize = 14.sp,
            color = Color.Black,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(0.dp, 20.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}