package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class activity_preco : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preco)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtPreco = findViewById<TextInputEditText>(R.id.edt_preco)

        val btnProximo = findViewById<Button>(R.id.btn_proximo)

        btnProximo.setOnClickListener {

            val precoStr: String = edtPreco.text.toString()
            val preco = precoStr.toFloat()

            val intent = Intent (this, ActivityConsumo :: class.java)
            intent.putExtra("KEY_PRECO", preco)


            startActivity(intent)
        }
    }
}