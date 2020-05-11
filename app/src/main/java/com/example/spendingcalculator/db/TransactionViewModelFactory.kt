package com.example.spendingcalculator.db

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.spendingcalculator.TransactionViewModel
import java.lang.IllegalArgumentException

class TransactionViewModelFactory(private val repositary: TransactionRepositary):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TransactionViewModel::class.java)){
            return TransactionViewModel(repositary) as T
        }
        throw IllegalArgumentException("Unknown View Model CLass")
    }
}