package com.example.uitest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

data class TabItem(
    var title : String,
    val screen: @Composable () -> Unit
)



@Composable
fun Tabs(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Button(
        modifier = Modifier
            .heightIn(50.dp)
            .widthIn(185.dp),
        colors = ButtonDefaults.buttonColors(
            if (isSelected) Color.White else Gray1
        ),
        elevation = if (isSelected) ButtonDefaults.buttonElevation(4.dp) else ButtonDefaults.buttonElevation(2.dp),
        shape = RoundedCornerShape(4.dp),
        onClick = onClick
    ) {
        Text(
            modifier = Modifier,
            text = title,
            fontSize = 14.sp,
            color = if (isSelected) Color.Black else Color.Gray,
            fontWeight = FontWeight.Bold
        )
    }
}