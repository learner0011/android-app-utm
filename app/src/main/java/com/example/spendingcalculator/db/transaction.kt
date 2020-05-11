package com.example.spendingcalculator.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transaction_data_table")
data class transaction(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "transaction_id")
    val id: Int,
    @ColumnInfo(name = "transaction_name")
    val description: String,
    @ColumnInfo(name = "transaction_amount")
    val amount: String
)