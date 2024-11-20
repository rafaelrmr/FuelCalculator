package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class ActivityConsumo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consumo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val preco = intent.getFloatExtra("KEY_PRECO", 0f)

        val edtConsumo = findViewById<TextInputEditText>(R.id.edt_consumo)

        val btnProximo = findViewById<Button>(R.id.btn_proximo)

        btnProximo.setOnClickListener{

            val consumoStr: String = edtConsumo.text.toString()
            val consumo = consumoStr.toFloat()

            val  intent = Intent(this,ActivityTrip::class.java)
            intent.putExtra("KEY_PRECO", preco )
            intent.putExtra("KEY_CONSUMO", consumo)
            startActivity(intent)
        }


    }
}