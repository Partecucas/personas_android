package com.example.recyclerviewexamplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class aa : AppCompatActivity() {
    private lateinit var contenedor: LinearLayout
    private lateinit var btnOpcion1: Button
    private lateinit var btnOpcion2: Button
    private lateinit var btnOpcion3: Button
    private lateinit var txtResultado: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prueba)

        contenedor = findViewById(R.id.contenedor)
        btnOpcion1 = findViewById(R.id.btn_opcion1)
        btnOpcion2 = findViewById(R.id.btn_opcion2)
        btnOpcion3 = findViewById(R.id.btn_opcion3)
        txtResultado = findViewById(R.id.txt_resultado)

        btnOpcion1.setOnClickListener { txtResultado.text = "Opción 1 seleccionada" }
        btnOpcion2.setOnClickListener { txtResultado.text = "Opción 2 seleccionada" }
        btnOpcion3.setOnClickListener { txtResultado.text = "Opción 3 seleccionada" }

    }

}