package br.edu.ifsp.conversormonetario

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.NumberFormatException
import java.text.DecimalFormat

class MainActivity : AppCompatActivity(), OnClickListener {

    private val DOLLAR_VALUE = 4.99
    private val df = DecimalFormat("#.##")

    private lateinit var inputEditText: EditText
    private lateinit var convertToDollarButton: Button
    private lateinit var outputTextView : TextView
    private lateinit var convertToRealButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findByID()
        configClickListener()

    }

    override fun onClick(v: View) {

        when(v){
            convertToDollarButton -> convertToDollar()
            convertToRealButton -> convertToReal()
        }

    }

    private fun findByID (){

        inputEditText = findViewById(R.id.editText_valor)
        convertToDollarButton = findViewById(R.id.button_convertToDollar)
        outputTextView = findViewById(R.id.textview_output)
        convertToRealButton = findViewById(R.id.button_convertToReal)

    }

    private fun configClickListener(){
        convertToDollarButton.setOnClickListener(this)
        convertToRealButton.setOnClickListener(this)
    }

    private fun convertToDollar(){

        var value = try{
            inputEditText.text.toString().toDouble()
        }catch (e: NumberFormatException){
            0.0
        }

        value = value * DOLLAR_VALUE

        outputTextView.text = String.format("U$ %.2f", value)
        //outputTextView.text= "U$ $value"

    }

    private fun convertToReal(){

        var value = try{
            inputEditText.text.toString().toDouble()
        }catch (e: NumberFormatException){
            0.0
        }

        value = value / DOLLAR_VALUE

        outputTextView.text = "R$ " + df.format(value)
        //outputTextView.text= "R$ $value"

    }

}