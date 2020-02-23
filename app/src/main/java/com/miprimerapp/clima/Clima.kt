package com.miprimerapp.clima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.layout_elbueno.*

class Clima : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_elbueno)

        val nombreCiudad = intent.getStringExtra("nombre")
        val tempCiudad = intent.getStringExtra("temperatura")
        val estatusCiudad = intent.getStringExtra("estatus")

        txtCiudad.text = nombreCiudad
        txtClima.text = estatusCiudad
        txtTemperatura.text = tempCiudad


    }
}
