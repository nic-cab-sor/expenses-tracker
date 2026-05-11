package com.nicole.expensestracker.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nicole.expensestracker.ui.components.Header

/**
 * The Main Screen of the app which displays all expenses, works out the total cost of all expenses, and calculates the remaining balance given a totalIncome value.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Header("This is the title", 26.sp) }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            BudgetSummaryRow(16.dp)
        }
    }
}

/**
 * Calculates the remaining balance for the month by first adding up all expenses then subtracting this value from the totalIncome.
 * @param rowPadding Padding for the row in dp.
 */
@Composable
private fun BudgetSummaryRow(rowPadding: Dp) {
    val minusSign: String = "-"
    val equalsSign: String = "="

    // TODO: hardcoded for now, will refactor once the db is fully set up
    var totalIncome: Double = 2425.0
    var totalExpenses: Double = 1790.0
    var remainingBalance: Double = 635.0

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .border(
                width = 2.dp,
                color = Color.Red
            )
            .fillMaxWidth()
            .padding(rowPadding)
    ) {
        OutlinedTextField(
            value = totalIncome.toString(),
            onValueChange = {},
            modifier = Modifier.width(150.dp)
        )
        Text(minusSign)
        Text(totalExpenses.toString())
        Text(equalsSign)
        Text(remainingBalance.toString())
    }
}