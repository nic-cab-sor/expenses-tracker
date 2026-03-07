package com.nicole.expensestracker.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "categories",
    foreignKeys = [
        ForeignKey(
            entity = Statement::class,
            parentColumns = ["uid"],
            childColumns = ["statement_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("statement_id")]
)
data class Category(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "statement_id") val statementId: Int
)