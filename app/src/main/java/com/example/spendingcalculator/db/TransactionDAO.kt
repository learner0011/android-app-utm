package com.example.spendingcalculator.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao //data access object optimization
interface TransactionDAO {

    //create a transaction in DB
    @Insert
    suspend fun insertTransaction(transaction: transaction) : Long

    //update a transaction in DB
    @Update
    suspend fun updateTransaction(transaction: transaction)

    //delete from db
    @Delete
    suspend fun deleteTransaction(transaction: transaction)

    @Query(value = "DELETE FROM transaction_data_table")
    suspend fun deleteAll()

    @Query(value = "SELECT * FROM transaction_data_table")
    fun getAllTransactions () : LiveData<List<transaction>>

}