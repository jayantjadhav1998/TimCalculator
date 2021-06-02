package com.example.timcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SearchRecentSuggestions
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
//    private lateinit var result: EditText
//    private lateinit var newNumber: EditText
//    private val displayOperation by lazy(LazyThreadSafetyMode.NONE) { findViewById<TextView>(R.id.operation) }

    //variable to hold operand and type od calculation
    private var operand1:Double?=null
    private var pendingOperation="="


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        result=findViewById(R.id.editTextResult)
//        newNumber=findViewById(R.id.editTextNumber)
//
//        //Data Input buttons
//        val button0:Button=findViewById(R.id.button0)
//        val button1:Button=findViewById(R.id.button1)
//        val button2:Button=findViewById(R.id.button2)
//        val button3:Button=findViewById(R.id.button3)
//        val button4:Button=findViewById(R.id.button4)
//        val button5:Button=findViewById(R.id.button5)
//        val button6:Button=findViewById(R.id.button6)
//        val button7:Button=findViewById(R.id.button7)
//        val button8:Button=findViewById(R.id.button8)
//        val button9:Button=findViewById(R.id.button9)
//        val buttonDot:Button=findViewById(R.id.buttonDot)
//
//        //Operation button
//        val buttonEquals=findViewById<Button>(R.id.buttonEqual)
//        val buttonDivide=findViewById<Button>(R.id.buttonDivide)
//        val buttonMultiply=findViewById<Button>(R.id.buttonMultiply)
//        val buttonPlus=findViewById<Button>(R.id.buttonPlus)
//        val buttonMinus=findViewById<Button>(R.id.buttonMinus)

        val listener=View.OnClickListener { v->
            val b=v as Button
            editTextNumber.append(b.text)
        }
        button0.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)
        buttonDot.setOnClickListener(listener)


        val opListener=View.OnClickListener { v->
            val op= (v as Button).text.toString()
            try {
                val value=editTextNumber.text.toString().toDouble()
                performOperation(value,op)
            }catch (e:NumberFormatException){
                editTextNumber.setText("")
            }

            pendingOperation=op
            operation.text=pendingOperation
        }
        buttonEqual.setOnClickListener(opListener)
        buttonMultiply.setOnClickListener(opListener)
        buttonDivide.setOnClickListener(opListener)
        buttonMinus.setOnClickListener(opListener)
        buttonPlus.setOnClickListener(opListener)
        }


    private fun performOperation(value: Double,operation:String){
        if(operand1==null){
            operand1=value
        }else {
            if (pendingOperation == "=") {
                pendingOperation = operation
            }
            when (pendingOperation) {
                "=" -> operand1 = value
                "/" -> if (value == 0.0) {
                    operand1 = Double.NaN
                } else {
                    operand1 = operand1!! / value
                }
                "*" -> operand1 = operand1!! * value
                "-" -> operand1 = operand1!! - value
                "+" -> operand1 = operand1!! + value
            }
        }
        editTextResult.setText((operand1.toString()))
        editTextNumber.setText("")

    }
}