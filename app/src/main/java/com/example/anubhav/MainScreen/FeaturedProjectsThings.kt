package com.example.anubhav.MainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.anubhav.ui.theme.MyFonts
import com.example.anubhav.ui.theme.main_grey
import com.example.anubhav.ui.theme.main_orange
import com.example.anubhav.ui.theme.main_white

@Composable
fun FeaturedProjectsMenu(items: List<FeaturedProjectsContent>) {
    LazyRow {
        itemsIndexed(items) { _, item ->
            FeaturedProjectsItem(item = item)
        }
    }
}

@Composable
fun FeaturedProjectsItem(item: FeaturedProjectsContent) {
    Card(
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 21.dp)
            .size(height = 275.dp, width = 300.dp)
            .clickable {
                item.navController.navigate("introPage/${item.tag}")
            },

        shape = RoundedCornerShape(30.dp),
        elevation = CardDefaults.cardElevation(15.dp),
        colors = CardDefaults.cardColors(
            main_grey
        ),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterEnd
        ) {
            Row(
                modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = item.imgId),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(20.dp)
                        )
                        .padding(20.dp)
                        .size(275.dp),
                    alignment = Alignment.CenterStart
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(150.dp)
                    .padding(9.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = item.title,
                    color = main_white,
                    fontFamily = MyFonts.leagueSpartan,
                    fontSize = 20.sp
                )
                FeatureDynamicChip(chipText = item.techStack)
            }
        }

    }
}

data class FeaturedProjectsContent(
    val tag: String,
    val title: String,
    val imgId: Int,
    val techStack: List<String>,
    val navController: NavController
)


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FeatureDynamicChip(chipText: List<String>) {
    FlowRow(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentSize()
    ) {
        chipText.forEach { text ->
            FeatureChip(text)
        }
    }
}

@Composable
fun FeatureChip(text: String = "default") {
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
            fontSize = 9.sp,
            fontFamily = MyFonts.montserratMedium,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun FeaturedProjectsContentPrev(modifier: Modifier = Modifier) {

}