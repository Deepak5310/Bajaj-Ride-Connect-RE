package com.bajaj.rideconnect.re

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.bajaj.rideconnect.re.ui.theme.MyPulsarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyPulsarTheme {
                // UI & Permissions flow will be wired here
            }
        }
    }
}