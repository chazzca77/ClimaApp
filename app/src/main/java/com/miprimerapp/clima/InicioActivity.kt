package com.miprimerapp.clima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.miprimerapp.clima.Adapters.CustomAdapter
import kotlinx.android.synthetic.main.activity_inicio.*

class InicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        var ciudades:ArrayList<Ciudades> = ArrayList()

        ciudades.add(Ciudades("CDMX",20,"nublado"))


        val adaptador = CustomAdapter(this,ciudades)
        lstCiudades.adapter = adaptador

        lstCiudades.onItemClickListener = AdapterView.OnItemClickListener{parent,view,position,id ->
            Toast.makeText(this,ciudades.get(position).nombre,Toast.LENGTH_LONG).show()
        }




    }
}
