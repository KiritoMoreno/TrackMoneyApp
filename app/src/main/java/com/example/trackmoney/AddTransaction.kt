package com.example.trackmoney

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.core.widget.addTextChangedListener
import androidx.room.Room
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddTransaction : AppCompatActivity() {
    //When the add transaction button is clicked it will check if the fields are empty or not ( show error message or add new transaction)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_transaction)

        val labelInput: TextInputEditText = findViewById(R.id.labelInput)
        val amountInput: TextInputEditText = findViewById(R.id.amountInput)
        val labelLayout: TextInputLayout = findViewById(R.id.labelLayout)
        val amountLayout: TextInputLayout = findViewById(R.id.amountLayout)

        labelInput.addTextChangedListener{
            if (it?.length ?: 0 > 0){
                labelLayout.error= null
            }
        }

        amountInput.addTextChangedListener{
            if (it?.length ?: 0 > 0){
                amountLayout.error= null
            }
        }

        val addTransactionBtn: Button = findViewById(R.id.addTransactionBtn)
        addTransactionBtn.setOnClickListener{
            val labelInput: TextInputEditText = findViewById(R.id.labelInput)
            val amountInput: TextInputEditText = findViewById(R.id.amountInput)
            val labelLayout: TextInputLayout = findViewById(R.id.labelLayout)
            val amountLayout: TextInputLayout = findViewById(R.id.amountLayout)
            val descriptionInput: TextInputEditText = findViewById(R.id.descriptionInput)

            val label: String = labelInput.text.toString()
            val amount: Double? = amountInput.text.toString().toDoubleOrNull()
            val description: String = descriptionInput.text.toString()

            if (label.isEmpty())
                labelLayout.error = "Please enter a valid label"

            if (amount == null)
                amountLayout.error = "Please enter a valid amount"
            else{
                val transaction = Transaction(0,label,amount,description)
                insert(transaction)
            }
        }
        val closeBtn: ImageButton = findViewById(R.id.closeBtn)
        closeBtn.setOnClickListener {
            finish()
        }
    }
    private fun insert(transaction: Transaction){
        val db: AppDatabase = Room.inMemoryDatabaseBuilder(this,
            AppDatabase::class.java).build()

        GlobalScope.launch {
            db.transactionDao().insertAll(transaction)
            finish()
        }
    }
}