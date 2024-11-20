package com.example.fuelcalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val preco = intent.getFloatExtra("KEY_PRECO", 0f)
        println("TESTE " + preco)

        val consumo = intent.getFloatExtra("KEY_CONSUMO", 0f)
        println("TESTE " + consumo)

        val trip = intent.getFloatExtra("KEY_TRIP", 0f)
        println("TESTE " + trip)

        val valor = preco * trip / consumo
        println ("O valor que será gasto é de: $" + valor)
    }
}