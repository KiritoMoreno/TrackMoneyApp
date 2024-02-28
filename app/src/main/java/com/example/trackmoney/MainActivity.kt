package com.example.trackmoney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    //The rexycler view need a few things: 1. Adapter to know how it should look, behave and what kind of data it displays
    //2. The layout manager to tell it how it should position items and when to recycle one of them that are off of the screen

    private lateinit var transaction : List<Transaction>
    private lateinit var transactionAdapter : TransactionAdapter
    private lateinit var linearLayoutManager : LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        transaction = arrayListOf()  // We creating an empty list

        // transactionAdapter needs parameters
        transactionAdapter = TransactionAdapter(transaction)
        // LayoutManager needs to know the context ( this class MainActivity.kl)
        linearLayoutManager= LinearLayoutManager(this)

        // Set the layout manager and adapter for the recyclerview
        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = transactionAdapter

        updateDashboard()

        val addBtn: FloatingActionButton = findViewById(R.id.addBtn)
        addBtn.setOnClickListener {
            //Inten is a description of an action that want the system to perform
            //It will need two parameters ( Start activity and End activity)
            val intent = Intent(this, AddTransaction::class.java)
            startActivity(intent)
        }
    }
    //
    private fun updateDashboard(){
        val totalAmount= transaction.map{it.amount}.sum() //New list with only the amounts of transaction
        val budgetAmount= transaction.filter { it.amount>0 }.map { it.amount }.sum()  //This is the list of all the amounts of the transactions than are greater than zero
        val expenseAmount= totalAmount - budgetAmount

        val balance: TextView = findViewById(R.id.balance)
        val budget: TextView = findViewById(R.id.budget)
        val expense: TextView = findViewById(R.id.expense)

        balance.text = "$ %.2f".format(totalAmount)
        budget.text= "$ %.2f".format(budgetAmount)
        expense.text="$ %.2f".format(expenseAmount)

    }

}