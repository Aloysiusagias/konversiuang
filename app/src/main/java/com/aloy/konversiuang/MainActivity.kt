package com.aloy.konversiuang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

lateinit var input_uang : EditText
lateinit var hasill : TextView
lateinit var symbol : TextView
var pengali = 0.000072

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var rp1000: LinearLayout? = null
        var rp2000: LinearLayout? = null
        var rp5000: LinearLayout? = null
        var rp10000: LinearLayout? = null
        var rp20000: LinearLayout? = null
        var rp50000: LinearLayout? = null
        var rp100000: LinearLayout? = null
        var rp500000: LinearLayout? = null
        var rp1000000: LinearLayout? = null

        input_uang = findViewById(R.id.uang_input)
        hasill = findViewById(R.id.hasil_konversi)
        symbol = findViewById(R.id.Symbol)
        input_uang.addTextChangedListener(textWatcher)
        rp1000 = findViewById(R.id.rp1000)
        rp2000 = findViewById(R.id.rp2000)
        rp5000 = findViewById(R.id.rp5000)
        rp10000 = findViewById(R.id.rp10000)
        rp20000 = findViewById(R.id.rp20000)
        rp50000 = findViewById(R.id.rp50000)
        rp100000 = findViewById(R.id.rp100000)
        rp500000 = findViewById(R.id.rp500000)
        rp1000000 = findViewById(R.id.rp100000)
        rp1000.setOnClickListener(this)
        rp2000.setOnClickListener(this)
        rp5000.setOnClickListener(this)
        rp10000.setOnClickListener(this)
        rp20000.setOnClickListener(this)
        rp50000.setOnClickListener(this)
        rp100000.setOnClickListener(this)
        rp500000.setOnClickListener(this)
        rp1000000.setOnClickListener(this)

    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            var hasil = s.toString().toDouble() * pengali;
            hasill.setText(hasil.toString())
        }
    }

    override fun onClick(p0: View) {
        when (p0.id){
            R.id.rp1000 -> input_uang.setText("1000")
            R.id.rp2000 -> input_uang.setText("2000")
            R.id.rp5000 -> input_uang.setText("5000")
            R.id.rp10000 -> input_uang.setText("10000")
            R.id.rp20000 -> input_uang.setText("20000")
            R.id.rp50000 -> input_uang.setText("50000")
            R.id.rp100000 -> input_uang.setText("100000")
            R.id.rp500000 -> input_uang.setText("500000")
            R.id.rp1000000 -> input_uang.setText("1000000")
        }
    }

    fun toUSD(view: View) {
        pengali = 0.000072
        input_uang.setText(input_uang.text)
        symbol.setText("$")
    }

    fun toYEN(view: View) {
        pengali = 0.0074
        input_uang.setText(input_uang.text)
        symbol.setText("¥")
    }
    fun toMalay(view: View) {
        pengali = 0.00029
        input_uang.setText(input_uang.text)
        symbol.setText("RM")
    }
}