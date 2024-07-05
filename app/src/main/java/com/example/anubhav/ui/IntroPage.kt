package com.example.anubhav.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.anubhav.ui.theme.MyFonts
import com.example.anubhav.ui.theme.main_black
import com.example.anubhav.ui.theme.main_orange
import com.example.anubhav.ui.theme.main_white


@Composable
fun IntroPage(
    mainList:List<Project>, tag: String, navController: NavController
) {
    val project = mainList.find { it.tag == tag }

    if (project != null) {
        IntroScreen(project = project, navController)
    }

}

@Composable
fun IntroScreen(project: Project, navController: NavController) {
    val scrollState = rememberScrollState()


    Column(
        modifier = Modifier

            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(main_black),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Log.d("myTag", "got inside introScreen")
        Box(
            modifier = Modifier
                .padding(top = 34.dp)
                .fillMaxWidth()
                .height(400.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = project.imgId1),
                    contentDescription = null,
                    modifier = Modifier
                        .size(400.dp)
                        .padding(end = 100.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(50.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = project.imgId2),
                    contentDescription = null,
                    modifier = Modifier.size(200.dp)
                )
            }
        }
        Spacer(modifier = Modifier.size(50.dp))
        Text(
            text = project.title,
            fontSize = 36.sp,
            fontFamily = MyFonts.leagueSpartan,
            color = main_white,
            textAlign = TextAlign.Center
        )
        IntroDynamicChip(chipText = project.stack)
        Text(
            text = project.description,
            fontSize = 15.sp,
            fontFamily = MyFonts.montserratRegular,
            color = main_white,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 21.dp),
            lineHeight = 30.sp,
            textAlign = TextAlign.Start
        )
        Button(onClick = { navController.navigate(project.tag) }, modifier = Modifier.padding(vertical = 21.dp)) {
            Text(text = "try the app?")
        }

    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun IntroDynamicChip(chipText: List<String>) {
    FlowRow(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentSize()
    ) {
        chipText.forEach { text ->
            IntroChip(text)
        }
    }
}

@Composable
fun IntroChip(text: String) {
    Box(
        modifier = Modifier
            .padding(start = 6.dp, top = 9.dp)
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
private fun Introprev() {

}