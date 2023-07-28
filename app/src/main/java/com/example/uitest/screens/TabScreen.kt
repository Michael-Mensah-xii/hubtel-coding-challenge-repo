package com.example.uitest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.uitest.ui.theme.Gray1

@Composable
fun TabScreen(
    content: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        content()
    }
}


@Composable
fun CustomTabs(
    tabs: List<String>,
    selectedIndex: Int,
    onTabSelected: (Int) -> Unit,
    selectedTabColor: Color,
    unselectedTabColor: Color,
) {
    val tabModifier = Modifier
        .height(45.dp)
        .background(Gray1)
        .clip(RoundedCornerShape(8.dp))

    TabRow(
        selectedTabIndex = selectedIndex,
        containerColor = Gray1,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 16.dp)
            .clip(RoundedCornerShape(8.dp))
            .padding(1.dp),
        indicator = {
            Box(
                modifier = Modifier,
            ) {}
        }
    ) {
        tabs.forEachIndexed { index, text ->
            val selected = selectedIndex == index

            Tab(
                modifier = tabModifier
                    .height(35.dp)
                    .background(if (selected) selectedTabColor else unselectedTabColor),
                selected = selected,
                onClick = { onTabSelected(index) },
                text = {
                    Text(
                        text = text,
                        color = if (selected) Color.Black else Color.Gray,
                    )
                }
            )
        }
    }
}

