package com.example.spendingcalculator

import android.R
import android.widget.Spinner
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spendingcalculator.db.TransactionRepositary
import com.example.spendingcalculator.db.transaction
import kotlinx.coroutines.launch


class TransactionViewModel(private val repositary: TransactionRepositary) : ViewModel(), Observable {
    val transaction = repositary.transactions

    @Bindable
    val inputDescription = MutableLiveData<String>()
    @Bindable
    val inputAmount = MutableLiveData<String>()

    fun test () {

    }


    fun save (){
        val description = inputDescription.value!!
        val amount = inputAmount.value!!
        insert(transaction(0,description,amount))
        inputDescription.value=null
        inputAmount.value=null

    }

    fun insert (transaction:transaction){
        viewModelScope.launch {
            repositary.insert(transaction)
        }
    }


    fun clear (){
        viewModelScope.launch {
            repositary.deleteAll()
        }
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

}