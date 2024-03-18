package br.edu.ifsp.conversormonetario

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), OnClickListener {

    private val DOLLAR_VALUE = 4.99

    private lateinit var inputEditText: EditText
    private lateinit var convertToDollarButton: Button
    private lateinit var outputTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findByID()
        configClickListener()

    }

    override fun onClick(v: View?) {

        when(v){
            convertToDollarButton -> convertToDollar()
        }

    }

    private fun findByID (){

        inputEditText = findViewById(R.id.editText_valor)
        convertToDollarButton = findViewById(R.id.button_convertToDollar)
        outputTextView = findViewById(R.id.textView_result)

    }

    private fun configClickListener(){
        convertToDollarButton.setOnClickListener(this)
    }

    private fun convertToDollar(){

        var value = try{
            inputEditText.text.toString().toDouble()
        }catch (e: NumberFormatException){
            0.0
        }

        value = value * DOLLAR_VALUE

        outputTextView.text= "US $value"

    }

}