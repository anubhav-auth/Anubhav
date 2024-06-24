package com.example.anubhav.MainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
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
import com.example.anubhav.ui.theme.main_orange
import com.example.anubhav.ui.theme.main_purple
import com.example.anubhav.ui.theme.main_yellow



@Composable
fun ProjectMenu(items: List<ProjectMenuContent>) {
    LazyRow {
        itemsIndexed(items){index, item2 ->
            val colInd = (index - 3) % 3
            val color: Color = when (colInd) {
                0 -> main_yellow
                1 -> main_purple
                else -> main_orange
            }
            ProjectMenuItem(item = item2, color = color)

        }
    }
}

@Composable
fun ProjectMenuItem(item: ProjectMenuContent, color: Color) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(16.dp))
//            .padding(5.dp)
            .size(height = 150.dp, width = 175.dp)
            .background(color)

    ) {
        Icon(
            painter = painterResource(id = item.iconId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp)
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
fun pre1(modifier: Modifier = Modifier) {
    ProjectMenu(items = listOf(
        ProjectMenuContent("Calculator", R.drawable.skill),
        ProjectMenuContent("Calculator", R.drawable.skill),
        ProjectMenuContent("Calculator", R.drawable.skill),
        ProjectMenuContent("Calculator", R.drawable.skill),
        ProjectMenuContent("Calculator", R.drawable.skill),
    ))
}