package com.example.trackmoney

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    //The rexycler view need a few things: 1. Adapter to know how it should look, behave and what kind of data it displays
    //2. The layout manager to tell it how it should position items and when to recycle one of them that are off of the screen

    private lateinit var transaction : ArrayList<Transaction>
    private lateinit var transactionAdapter : TransactionAdapter
    private lateinit var linearLayoutManager : LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        transaction = arrayListOf(
            Transaction("Weekend Budget", 400.00),
            Transaction("Bananas", -4.00),
            Transaction("Gasoline", -40.00),
            Transaction("Breakfast", -9.90),
            Transaction("Water Bottles", -4.00),
            Transaction("Design", -80.00),
            Transaction("Car Park", -15.00)
        )

        // transactionAdapter needs parameters
        transactionAdapter = TransactionAdapter(transaction)
        // LayoutManager needs to know the context ( this class MainActivity.kl)
        linearLayoutManager= LinearLayoutManager(this)

        // Set the layout manager and adapter for the recyclerview
        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = transactionAdapter

    }
}