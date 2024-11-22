package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

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
        val consumo = intent.getFloatExtra("KEY_CONSUMO", 0f)
        val trip = intent.getFloatExtra("KEY_TRIP", 0f)

        val result = preco * trip / consumo


        val tvResult = findViewById<TextView>(R.id.tv_result)
        tvResult.text = result.toString()

        val tvPreco = findViewById<TextView>(R.id.tv_preco)
        tvPreco.text = preco.toString()

        val tvConsumo = findViewById<TextView>(R.id.tv_consumo)
        tvConsumo.text = consumo.toString()

        val tvTrip = findViewById<TextView>(R.id.tv_trip)
        tvTrip.text = trip.toString()

        val btnNovo = findViewById<Button>(R.id.btn_novo)

        btnNovo.setOnClickListener{
            val intent = Intent(this, activity_preco::class.java)
            startActivity(intent)

        }

    }
}