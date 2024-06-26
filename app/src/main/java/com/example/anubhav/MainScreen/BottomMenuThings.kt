package com.example.anubhav.MainScreen


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.anubhav.SharedStateViewModel
import com.example.anubhav.ui.theme.main_grey
import com.example.anubhav.ui.theme.main_text_grey
import com.example.anubhav.ui.theme.main_white

@Composable
fun BottomMenu(modifier: Modifier = Modifier, items: List<BottomMenuContent>) {
    val viewmodel: SharedStateViewModel = viewModel()
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(18.dp)
            .clip(RoundedCornerShape(36.dp))
            .background(main_grey)
            .padding(9.dp)
            .fillMaxWidth()

    ) {
        items.forEachIndexed { index, item2 ->
            BottomMenuItem(
                item = item2,
                isSelected = index == viewmodel.selectedItemIndex
            ) {
                viewmodel.selectedItemIndex = index
            }
        }
    }
}


@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeTextColour: Color = main_white,
    inactiveTextColor: Color = main_text_grey,
    onItemClick: () -> Unit
) {
    Box(modifier = Modifier.clickable { onItemClick() }, contentAlignment = Alignment.Center) {
        Column {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = null,
                tint = if (isSelected) activeTextColour else inactiveTextColor,
                modifier = Modifier.size(item.iconSize).align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = item.title,
                color = if (isSelected) activeTextColour else inactiveTextColor,
                fontSize = 10.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

    }
}

data class BottomMenuContent(
    val title: String, val iconId: Int, val iconSize:Dp = 24.dp
)

@Preview
@Composable
fun Pre(modifier: Modifier = Modifier) {

}