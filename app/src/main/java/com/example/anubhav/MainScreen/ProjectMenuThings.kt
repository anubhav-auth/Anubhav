package com.example.anubhav.MainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anubhav.R
import com.example.anubhav.ui.theme.main_grey


@Composable
fun ProjectMenu(items: List<ProjectMenuContent>) {

    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        itemsIndexed(items) { index, item ->

            ProjectMenuItem(item = item)
        }
    }

}

@Composable
fun ProjectMenuItem(item: ProjectMenuContent, color: Color = main_grey) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .size(height = 180.dp, width = 180.dp)
            .background(color)
    ) {
        Icon(
            painter = painterResource(id = item.iconId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = item.title, fontSize = 6.sp)
        }
    }
}


data class ProjectMenuContent(
    val title: String, val iconId: Int
)

@Preview
@Composable
fun Pre1(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Row {
            ProjectMenuItem(item = ProjectMenuContent(title = "contact", iconId = R.drawable.calc))
            ProjectMenuItem(item = ProjectMenuContent(title = "contact", iconId = R.drawable.calc))

        }
    }
}