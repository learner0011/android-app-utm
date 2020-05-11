package com.example.spendingcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spendingcalculator.databinding.ActivityMainBinding
import com.example.spendingcalculator.db.TransactionDB
import com.example.spendingcalculator.db.TransactionRepositary
import com.example.spendingcalculator.db.TransactionViewModelFactory
import kotlinx.android.synthetic.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var transactionViewModel: TransactionViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = TransactionDB.getInstance(application).transactionDAO
        val repositary =  TransactionRepositary(dao)
        val factory = TransactionViewModelFactory(repositary)
        transactionViewModel= ViewModelProvider(this,factory).get(TransactionViewModel::class.java)
        binding.viewModel = transactionViewModel
        binding.lifecycleOwner = this
        initRecyclerView()

    }

    private fun initRecyclerView(){
        binding.transactionRecycleView.layoutManager = LinearLayoutManager(this)
        displayTransactionsList()
    }

    private fun displayTransactionsList(){
        transactionViewModel.transaction.observe(this, Observer {
            Log.i("tag",it.toString())
            binding.transactionRecycleView.adapter = MyRecyclerViewAdapter(it)
        })
    }
}
