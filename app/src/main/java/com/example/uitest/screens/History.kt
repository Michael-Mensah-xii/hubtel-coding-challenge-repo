package com.example.uitest.screens

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButtonDefaults.elevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults.contentWindowInsets
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uitest.Constants.HISTORY
import com.example.uitest.Constants.SEARCH
import com.example.uitest.Constants.TRANSACTION_SUM
import com.example.uitest.R
import com.example.uitest.model.HistoryItemData
import com.example.uitest.model.historyItems
import com.example.uitest.navigation.Screen
import com.example.uitest.ui.theme.Gray1
import com.example.uitest.ui.theme.Green1
import com.example.uitest.ui.theme.Star
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen() {
    Scaffold(
        contentWindowInsets = contentWindowInsets,
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = { SendNewButton() },
        topBar = {
            Search()
        },
        content = {
            Content(historyItems = historyItems)
        },
        bottomBar = { BottomBar() },
    )
}


@Composable
fun TransactionSummary() {
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Gray1,
            ),
            placeholder = { Text(text = SEARCH, color = Color.Black.copy(alpha = 0.5f)) },
            modifier = Modifier
                .heightIn(45.dp)
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(6.dp))
                .border(2.dp, color = Gray1, shape = RoundedCornerShape(6.dp))
        )
        Icon(painter = painterResource(id = R.drawable.filter),
            contentDescription = null,
            modifier = Modifier
                .size(44.dp)
                .fillMaxWidth(0.1f)
                .clickable { })
    }

}


@Composable
fun HistoryItem(
    @StringRes text: Int,
    color: Color,
    icon: ImageVector,
    iconTint: Color,
    @StringRes statusText: Int,
    showStarIcon: Boolean,
    drawable: Int,

    ) {
    Column {

        Card(
            shape = RoundedCornerShape(15.dp),
            colors = CardDefaults.cardColors(Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 162.dp),
            border = BorderStroke(width = 1.dp, color = Gray1)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    stringResource(R.string.fake_time),
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.Black.copy(
                            alpha = 0.5f
                        )
                    )
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp)
                ) {
                    Image(
                        painter = painterResource(drawable),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(40.dp),
                        contentScale = ContentScale.Crop

                    )
                    Spacer(modifier = Modifier.widthIn(max = 10.dp))

                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(start = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                stringResource(id = text),
                                style = MaterialTheme.typography.bodySmall.copy(Color.Black)
                            )

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(16.dp))
                                    .widthIn(max = 89.dp)
                                    .background(color.copy(alpha = 0.2f))
                                    .padding(horizontal = 12.dp, vertical = 6.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Icon(
                                        icon,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(8.dp)
                                            .clip(CircleShape)
                                            .background(color),
                                        tint = iconTint
                                    )

                                    Text(
                                        stringResource(id = statusText),
                                        color = color,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontSize = 10.sp,
                                    )
                                }
                            }
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth().padding(start = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                stringResource(R.string.fake_number),
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = Color.Black.copy(
                                        alpha = 0.5f
                                    )
                                )
                            )

                            Text(
                                stringResource(R.string.mock_number),
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = Color.Black
                                ),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

            }
            Divider(
                color = Gray1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .width(2.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                verticalAlignment = Alignment.CenterVertically,
            ) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier, verticalAlignment = Alignment.CenterVertically
                    ) {

                        Image(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.person_icon),
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.widthIn(10.dp))

                        Text(
                            stringResource(R.string.personal),
                            style = MaterialTheme.typography.bodySmall.copy(Color.Black)
                        )

                        Spacer(modifier = Modifier.widthIn(8.dp))

                        Text(
                            stringResource(R.string.bullet),
                            style = MaterialTheme.typography.bodySmall.copy(
                                Color.Black.copy(
                                    0.5f
                                )
                            ),
                            fontSize = 18.sp
                        )

                        Spacer(modifier = Modifier.widthIn(8.dp))

                        Text(
                            stringResource(R.string.receipt_reference),
                            style = MaterialTheme.typography.bodySmall.copy(Color.Black)
                        )
                    }


                    if (showStarIcon) {
                        Icon(
                            Icons.Default.Star,
                            contentDescription = null,
                            modifier = Modifier,
                            tint = Star
                        )
                    }
                }


            }
        }
    }
}


@Composable
private fun SendNewButton() {

    ExtendedFloatingActionButton(shape = RoundedCornerShape(4.dp),
        containerColor = Green1,
        elevation = elevation(defaultElevation = 4.dp),
        onClick = { /*TODO*/ }) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Rounded.AddCircle,
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = Color.White
            )
            Text(
                "Send New", style = MaterialTheme.typography.bodySmall.copy(Color.White)
            )
        }

    }

}

@Composable
fun Content(historyItems: List<HistoryItemData>) {
    val groupedItems = historyItems.groupBy { it.transactionDate }

    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp),
        contentPadding = PaddingValues(top = 80.dp, bottom = 158.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        groupedItems.forEach { (date, items) ->
            item {
                DateChip(date = date)
            }

            items.forEach { item ->
                item {
                    HistoryItem(
                        text = item.text,
                        color = item.color,
                        icon = item.icon,
                        iconTint = item.iconTint,
                        statusText = item.statusText,
                        drawable = item.drawable,
                        showStarIcon = item.showStarIcon
                    )
                }
            }
        }

    }

}


@Composable
fun DateChip(date: String) {
    Row(modifier = Modifier.padding(top = 16.dp)) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Black.copy(alpha = 0.1f))
                .padding(horizontal = 12.dp, vertical = 6.dp), contentAlignment = Alignment.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = date,
                    color = Color.Black.copy(alpha = 0.5f),
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 10.sp,
                )
            }
        }
    }
}


@Composable
private fun IconContainer(icon: Int) {
    Box(
        modifier = Modifier.background(
            color = Color(0xFFCCF3EF), shape = CircleShape
        )
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .padding(5.dp)
                .size(20.dp)
                .align(alignment = Alignment.Center)
        )
    }
}


@Composable
fun BottomBar() {
    val items = listOf(
        Screen.Home, Screen.Send, Screen.History, Screen.Scheduled
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.onPrimary,
        contentColor = Color.Black,
    ) {
        var selected by remember { mutableIntStateOf(-1) }

        items.forEachIndexed { index, item ->
            val isSelected = (selected == index)

            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(indicatorColor = Color.White),
                icon = {
                    if (index == 0) {
                        IconContainer(item.icon) // Use IconContainer for the first item
                    } else {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title,
                            modifier = Modifier.alpha(if (isSelected) 1f else 0.5f)
                        )
                    }
                },
                label = { Text(text = item.title) },
                alwaysShowLabel = true,
                selected = isSelected,
                onClick = {
                    selected = index
                },
            )
        }
    }
}


// Tabs
@OptIn(ExperimentalPagerApi::class)
@Composable
fun HistoryTabs(
    onItemClicked: (item: Int) -> Unit,
) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    val tabs = listOf(HISTORY, TRANSACTION_SUM)

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.heightIn(42.dp))

        CustomTabs(
            tabs = tabs,
            selectedIndex = pagerState.currentPage,
            onTabSelected = { index ->
                coroutineScope.launch {
                    pagerState.animateScrollToPage(index)
                }
                onItemClicked(index)
            },
            selectedTabColor = Color.White,
            unselectedTabColor = Gray1
        )

        Spacer(modifier = Modifier.heightIn(16.dp))

        Divider(modifier = Modifier.fillMaxWidth(), color = Gray1)

        // Content
        HorizontalPager(
            count = tabs.size, state = pagerState
        ) { page ->
            // assign screen for each tab index (page)
            when (page) {
                0 -> TabScreen { HistoryScreen() }
                1 -> TabScreen { TransactionSummary() }
            }
        }
    }
}


@Preview(device = Devices.PIXEL_4, showBackground = true)
@Composable
fun HistoryTabsPreview() {
    HistoryTabs(onItemClicked = {})
}