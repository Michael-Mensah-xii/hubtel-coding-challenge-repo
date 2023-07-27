package com.example.uitest.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.uitest.R
import com.example.uitest.ui.theme.ButtonGreen

data class HistoryItemData(
    val text: Int,
    val color: Color,
    val icon: ImageVector,
    val iconTint: Color,
    val statusText: Int,
    val drawable: Int,
    val showStarIcon: Boolean,
    val transactionDate: String // Adding a date field to the data class
)



val historyItems = listOf(

    HistoryItemData(
        text = R.string.default_name,
        color = ButtonGreen,
        icon = Icons.Default.Check,
        iconTint = Color.White,
        statusText = R.string.successful,
        drawable = R.drawable.mtn,
        showStarIcon = true,
        transactionDate = "May 21, 2022"
    ),

    HistoryItemData(
        text = R.string.absa_bank,
        color = ButtonGreen,
        icon = Icons.Default.Check,
        iconTint = Color.White,
        statusText = R.string.successful,
        drawable = R.drawable.absa,
        showStarIcon = true,
        transactionDate = "May 21, 2022"
    ),

    HistoryItemData(
        text = R.string.default_name,
        color = Color.Red,
        icon = Icons.Default.Clear,
        iconTint = Color.White,
        statusText = R.string.failed,
        drawable = R.drawable.mtn,
        showStarIcon = false,
        transactionDate = "May 21, 2022"
    ),

    HistoryItemData(
        text = R.string.default_name,
        color = ButtonGreen,
        icon = Icons.Default.Check,
        iconTint = Color.White,
        statusText = R.string.successful,
        drawable = R.drawable.mtn,
        showStarIcon = true,
        transactionDate = "June 20, 2022"
    ),

    HistoryItemData(
        text = R.string.absa_bank,
        color = Color.Red,
        icon = Icons.Default.Clear,
        iconTint = Color.White,
        statusText = R.string.failed,
        drawable = R.drawable.absa,
        showStarIcon = false,
        transactionDate = "June 20, 2022"
    ),

    HistoryItemData(
        text = R.string.absa_bank,
        color = ButtonGreen,
        icon = Icons.Default.Clear,
        iconTint = Color.White,
        statusText = R.string.successful,
        drawable = R.drawable.absa,
        showStarIcon = true,
        transactionDate = "September 8, 2022"
    ),

    HistoryItemData(
        text = R.string.default_name,
        color = Color.Red,
        icon = Icons.Default.Clear,
        iconTint = Color.White,
        statusText = R.string.failed,
        drawable = R.drawable.mtn,
        showStarIcon = false,
        transactionDate = "September 8, 2022"
    )

    )



