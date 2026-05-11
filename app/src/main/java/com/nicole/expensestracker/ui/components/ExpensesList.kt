package com.nicole.expensestracker.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// TODO: I'm using data classes for now, use db dao's that update the db once this is setup
sealed interface ExpensesListItem

data class ExpensesListEntry(
    val title: String, val amount: Double, val isPaid: Boolean
) : ExpensesListItem

data class ExpensesListHeader(
    val title: String
) : ExpensesListItem

@Composable
fun ExpensesList() {

    // TODO: hardcoded for now, will refactor once the db is fully setup
    var expenseListItems: ArrayList<ExpensesListItem> = ArrayList()
    expenseListItems.add(ExpensesListHeader("header1"))
    expenseListItems.add(ExpensesListEntry("expense1", 23.50, false))
    expenseListItems.add(ExpensesListEntry("expense2", 23.50, false))
    expenseListItems.add(ExpensesListHeader("header2"))
    expenseListItems.add(ExpensesListEntry("expense3", 23.50, false))

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .border(
                width = 2.dp, color = Color.Blue
            )
            .padding(4.dp)
    ) {
        items(expenseListItems) { expenseListItem ->
            when (expenseListItem) {
                is ExpensesListEntry -> ExpenseEntryRow(expenseListItem)
                is ExpensesListHeader -> ExpenseHeaderRow(expenseListItem)
            }
        }
    }
}

@Composable
private fun ExpenseEntryRow(expensesListEntry: ExpensesListEntry) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 2.dp, color = Color.Green
            )
    ) {
        OutlinedTextField(
            value = expensesListEntry.title,
            onValueChange = {},
            modifier = Modifier.width(120.dp)
        )
        OutlinedTextField(
            value = expensesListEntry.amount.toString(),
            onValueChange = {},
            modifier = Modifier.width(100.dp)
        )
        Checkbox(checked = expensesListEntry.isPaid, onCheckedChange = {})
    }
}

@Composable
private fun ExpenseHeaderRow(expensesListHeader: ExpensesListHeader) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 2.dp, color = Color.Magenta
            )
    ) {
        Text("--- " + expensesListHeader.title + " ---")
    }
}