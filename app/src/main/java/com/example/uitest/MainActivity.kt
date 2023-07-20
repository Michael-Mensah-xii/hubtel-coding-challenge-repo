package com.example.uitest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.uitest.screens.HistoryTabs
import com.example.uitest.ui.theme.UITestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UITestTheme {
                HistoryTabs(onItemClicked = {})
            }
        }
    }
}

