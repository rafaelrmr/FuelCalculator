package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class ActivityTrip : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val preco = intent.getFloatExtra("KEY_PRECO", 0f)
        val consumo = intent.getFloatExtra("KEY_CONSUMO", 0f)

        val edtTrip = findViewById<TextInputEditText>(R.id.edt_trip)


        val btnProximo = findViewById<Button>(R.id.btn_proximo)

        btnProximo.setOnClickListener{

            val tripStr : String = edtTrip.text.toString()

            val trip = tripStr.toFloat()

            val intent = Intent(this,ActivityResult :: class.java)

            intent.putExtra("KEY_PRECO", preco)
            intent.putExtra("KEY_CONSUMO", consumo)
            intent.putExtra("KEY_TRIP", trip)
            startActivity(intent)
        }
    }
}