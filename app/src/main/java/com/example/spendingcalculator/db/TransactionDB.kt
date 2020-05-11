package com.example.spendingcalculator.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [transaction::class],version = 1)
abstract class TransactionDB : RoomDatabase(){

    abstract val transactionDAO : TransactionDAO

    companion object{
        @Volatile
        private var INSTANCE: TransactionDB? = null
            fun getInstance(context: Context): TransactionDB{
                synchronized(this){
                    var instance = INSTANCE
                        if(instance==null){
                            instance = Room.databaseBuilder(
                                context.applicationContext,
                                TransactionDB::class.java,
                                "transaction_data_table"
                            ).build()
                        }
                    return instance
                }
            }
    }
}