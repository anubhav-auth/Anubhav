package com.example.anubhav.MainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anubhav.R
import com.example.anubhav.ui.theme.main_black
import com.example.anubhav.ui.theme.main_orange
import com.example.anubhav.ui.theme.main_purpleDark
import com.example.anubhav.ui.theme.main_white

@Composable
fun MainScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(main_black)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Greeting()
            DynamicChip(
                chipText = listOf(
                    "Kotlin",
                    "Android",
                    "java",
                    "Jetpack Compose",
                    "Android",
                    "java",
                    "Jetpack Compose",
                )
            )
            Text(
                text = "Projects",
                color = main_white,
                fontSize = 24.sp,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(15.dp)
            )
            ProjectMenu(items = listOf(
                ProjectMenuContent("Calculator", R.drawable.skill),
                ProjectMenuContent("Calculator", R.drawable.skill),
                ProjectMenuContent("Calculator", R.drawable.skill),
                ProjectMenuContent("Calculator", R.drawable.skill),
            ))
        }

        BottomMenu(
            items = listOf(
                BottomMenuContent("Home", R.drawable.home),
                BottomMenuContent("Projects", R.drawable.projects),
                BottomMenuContent("Skills", R.drawable.skill),
                BottomMenuContent("Profile", R.drawable.profile),

                ), modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun Greeting() {
    Text(
        text = "Hey! I'm Anubhav",
        color = main_purpleDark,
        fontSize = 24.sp,
        fontFamily = FontFamily.Serif,
        modifier = Modifier.padding(15.dp)
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DynamicChip(chipText: List<String>) {
    FlowRow(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentSize()
    ) {
        chipText.forEach { text ->
            Chip(text)
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun Chip(text: String = "default") {
    Box(
        modifier = Modifier
            .padding(6.dp)
            .clip(RoundedCornerShape(18.dp))
            .border(1.dp, main_orange, RoundedCornerShape(18.dp))
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(
            text = text,
            color = main_white,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview
@Composable
fun tr(modifier: Modifier = Modifier) {
    MainScreen()

}
