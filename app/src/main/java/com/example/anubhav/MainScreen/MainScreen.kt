package com.example.anubhav.MainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.anubhav.R
import com.example.anubhav.ui.theme.MyFonts
import com.example.anubhav.ui.theme.main_black
import com.example.anubhav.ui.theme.main_grey
import com.example.anubhav.ui.theme.main_orange
import com.example.anubhav.ui.theme.main_purpleDark
import com.example.anubhav.ui.theme.main_white

@Composable
fun MainScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(main_black)
            .padding(top = 60.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Greeting()

            Text(
                text = stringResource(id = R.string.description),
                color = main_white,
                fontSize = 20.sp,
                fontFamily = MyFonts.montserratMediumItalic,
                modifier = Modifier.padding(vertical = 21.dp, horizontal = 15.dp)
            )
            Spacer(
                modifier = Modifier
                    .padding(15.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .height(3.dp)
                    .background(main_grey)
            )
            BlockHeading(title = "Skills")
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
            BlockHeading(title = "Featured Projects")

            FeaturedProjectsMenu(
                items = listOf(
                    FeaturedProjectsContent(
                        tag = "calc",
                        title = "Calculator",
                        imgId = R.drawable.calc,
                        techStack = listOf("kotlin", "jetpackCompose", "MXParser"),
                        navController = navController
                    ), FeaturedProjectsContent(
                        tag = "notes",
                        title = "Notes app",
                        imgId = R.drawable.notes,
                        techStack = listOf("kotlin", "jetpackCompose", "Room"),
                        navController = navController
                    )

                )
            )



            Spacer(modifier = Modifier.size(75.dp))

        }

        BottomMenu(
            items = listOf(
                BottomMenuContent("Home", R.drawable.bottom_home),
                BottomMenuContent("Stats", R.drawable.bottom_stats),
                BottomMenuContent("Projects", R.drawable.bottom_projects),
                BottomMenuContent("Profile", R.drawable.bottom_profile),

                ), modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun BlockHeading(title: String) {
    Text(
        text = title,
        color = main_white,
        fontSize = 24.sp,
        fontFamily = MyFonts.leagueSpartan,
        modifier = Modifier.padding(vertical = 21.dp, horizontal = 15.dp)
    )
}

@Composable
fun Greeting() {
    Text(
        text = "Hey! I'm Anubhav",
        color = main_purpleDark,
        fontSize = 24.sp,
        fontFamily = MyFonts.leagueSpartan,
        modifier = Modifier.padding(start = 15.dp, bottom = 21.dp)
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
        }
    }
}

@Composable
fun Chip(text: String = "default") {
    Box(
        modifier = Modifier
            .padding(start = 6.dp, top = 9.dp)
            .clip(RoundedCornerShape(18.dp))
            .border(1.dp, main_orange, RoundedCornerShape(18.dp))
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(
            text = text, color = main_white, fontSize = 14.sp, fontWeight = FontWeight.Bold
        )
    }
}


@Preview
@Composable
fun Tr(modifier: Modifier = Modifier) {

}
