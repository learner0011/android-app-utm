package com.example.spendingcalculator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.spendingcalculator.databinding.TransactionListBinding
import com.example.spendingcalculator.db.transaction

class MyRecyclerViewAdapter(private val transactionsList: List<transaction>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: TransactionListBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.transaction_list,parent, false)
    return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return transactionsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(transactionsList[position])
    }
}

class MyViewHolder(val binding: TransactionListBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(transaction : transaction){
        binding.descriptionTextView.text=transaction.description
        binding.amountTextView.text = transaction.amount
    }
}