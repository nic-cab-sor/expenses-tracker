package com.nicole.expensestracker.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit

@Composable
fun Header(title: String, fontSize: TextUnit, modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontSize = fontSize,
        modifier = modifier
    )
}