package com.nicole.expensestracker.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "statements")
data class Statement(
    // auto gens ids
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "start_date") val startDate: String,
    @ColumnInfo(name = "end_date") val endDate: String,
    @ColumnInfo(name = "income") val income: Double
)