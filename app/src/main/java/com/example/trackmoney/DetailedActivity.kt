package com.example.trackmoney

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageButton
import androidx.core.widget.addTextChangedListener
import androidx.room.Room
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailedActivity : AppCompatActivity() {
    // Se crea la base de datos una vez y se reutiliza en toda la aplicación
    private lateinit var  transaction: Transaction

    private val db: AppDatabase by lazy {
        Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "transactions"
        ).build()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val labelInput: TextInputEditText = findViewById(R.id.labelInput)
        val amountInput: TextInputEditText = findViewById(R.id.amountInput)
        val labelLayout: TextInputLayout = findViewById(R.id.labelLayout)
        val amountLayout: TextInputLayout = findViewById(R.id.amountLayout)
        val descriptionInput: TextInputEditText = findViewById(R.id.descriptionInput)

        transaction= intent.getSerializableExtra("transaction") as Transaction

        labelInput.setText(transaction.label)
        amountInput.setText(transaction.amount.toString())
        descriptionInput.setText(transaction.description)


        val updateBtn: Button = findViewById(R.id.updateBtn)

        val rootView: View = findViewById(android.R.id.content)
        rootView.setOnClickListener{
            this.window.decorView.clearFocus()
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken,0)
        }

        labelInput.addTextChangedListener{
            updateBtn.visibility = View.VISIBLE
            if (it?.length ?: 0 > 0){
                labelLayout.error= null
            }
        }

        amountInput.addTextChangedListener{
            updateBtn.visibility = View.VISIBLE
            if (it?.length ?: 0 > 0){
                amountLayout.error= null
            }
        }
        descriptionInput.addTextChangedListener{
            updateBtn.visibility = View.VISIBLE
        }


        updateBtn.setOnClickListener{
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
                val transaction = Transaction(transaction.id,label,amount,description)
                update(transaction)
            }
        }
        val closeBtn: ImageButton = findViewById(R.id.closeBtn)
        closeBtn.setOnClickListener {
            finish()
        }
    }
    private fun update(transaction: Transaction) {
        GlobalScope.launch{
            try {
                db.transactionDao().update(transaction)
                finish()
            } catch (e: Exception) {
                // Manejar el error, por ejemplo, imprimirlo o mostrar un mensaje al usuario
                e.printStackTrace()
            } finally {
                // Cerrar la base de datos al finalizar la operación
                db.close()
            }
        }
    }
}