package com.example.localapi.uicontroller

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.localapi.ui.view.siswa.EntrySiswaScreen

@Composable
fun DataSiswaApp(modifier: Modifier = Modifier) {
    EntrySiswaScreen(
        navigateBack = {},
        modifier = modifier
    )
}
