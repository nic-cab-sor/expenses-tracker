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
sealed interface ExpensesListRow

data class Expense(
    val title: String, val amount: Double, val isPaid: Boolean
) : ExpensesListRow

data class Header(
    val title: String
) : ExpensesListRow

/**
 * The expenses list contains a list of rows, where each row is either an expense entry or a divider with a header used to separate lists of expenses.
 */
@Composable
fun ExpensesList() {

    // TODO: hardcoded for now, will refactor once the db is fully setup
    val expensesListRows: ArrayList<ExpensesListRow> = ArrayList()
    expensesListRows.add(Header("header1"))
    expensesListRows.add(Expense("expense1", 23.50, false))
    expensesListRows.add(Expense("expense2", 23.50, false))
    expensesListRows.add(Header("header2"))
    expensesListRows.add(Expense("expense3", 23.50, false))

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .border(
                width = 2.dp, color = Color.Blue
            )
            .padding(4.dp)
    ) {
        // For each item create a row in the lazy column
        items(expensesListRows) { expenseListRow -> ExpensesListRow(expenseListRow) }
    }
}

@Composable
fun ExpensesListRow(expensesListRow: ExpensesListRow) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 2.dp, color = Color.Green
            )
    ) {
        when (expensesListRow) {
            // If it's an expense entry create a row which contains the expense name, cost, and if it's already been paid
            is Expense -> {
                OutlinedTextField(
                    value = expensesListRow.title,
                    onValueChange = {},
                    modifier = Modifier.width(120.dp)
                )
                OutlinedTextField(
                    value = expensesListRow.amount.toString(),
                    onValueChange = {},
                    modifier = Modifier.width(100.dp)
                )
                Checkbox(checked = expensesListRow.isPaid, onCheckedChange = {})
            }

            // If it's just a header create a row with a title
            is Header -> {
                Text("--- " + expensesListRow.title + " ---")
            }
        }
    }
}