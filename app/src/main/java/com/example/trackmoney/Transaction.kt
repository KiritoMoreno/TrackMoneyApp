package com.example.trackmoney

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

// specify the value -->
@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val label:String,  // if you want to specify for the name or field, add at the start this code (@ColumInfo(name="labelInfo"))
    val amount:Double,
    val description: String):Serializable{



}