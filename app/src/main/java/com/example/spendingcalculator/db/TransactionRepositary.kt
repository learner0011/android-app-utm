package com.example.spendingcalculator.db

class TransactionRepositary(private val dao: TransactionDAO) {

    val transactions = dao.getAllTransactions()

    suspend fun insert(transaction:transaction){
        dao.insertTransaction(transaction)
    }

    suspend fun update(transaction: transaction){
        dao.updateTransaction(transaction)
    }

    suspend fun delete(transaction: transaction){
        dao.deleteTransaction(transaction)
    }

    suspend fun deleteAll(){
        dao.deleteAll()
    }
}