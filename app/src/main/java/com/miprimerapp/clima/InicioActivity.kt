package com.miprimerapp.clima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.miprimerapp.clima.Adapters.CustomAdapter
import com.miprimerapp.clima.Models.Ciudades
import com.miprimerapp.clima.Models.ClimaCiudades
import com.miprimerapp.clima.Models.Personas
import com.miprimerapp.clima.Models.Usuarios
import kotlinx.android.synthetic.main.activity_inicio.*
import org.json.JSONObject

class InicioActivity : AppCompatActivity() {

    //var listaUsuarios:ArrayList<Usuarios>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        var respuesta =  "{\n" +
                "    \"usuarios\" : [\n" +
                "        {\n" +
                "            \"nombre\" : \"Marco\",\n" +
                "            \"pais\" : \"México\",\n" +
                "            \"estado\" : \"soltero\",\n" +
                "            \"experiencia\" : 5\n" +
                "        },\n" +
                "        {\n" +
                "            \"nombre\" : \"Agustín\",\n" +
                "            \"pais\" : \"México\",\n" +
                "            \"estado\" : \"casado\",\n" +
                "            \"experiencia\" : 16\n" +
                "        }\n" +
                "    ]\n" +
                "}"

       /* val json = JSONObject(respuesta)
        val usuarios = json.getJSONArray("usuarios")

        for(i in 0 until usuarios.length()){
            val nombre = usuarios.getJSONObject(i).getString("nombre")
            val pais = usuarios.getJSONObject(i).getString("pais")
            val estado = usuarios.getJSONObject(i).getString("estado")
            val experiencia = usuarios.getJSONObject(i).getInt("experiencia")

            val usuario = Usuarios(nombre,pais,estado,experiencia)
            listaUsuarios?.add(usuario)
            //Log.e("JSON usuarios", listaUsuarios?.count().toString())
        }
*/
        val gson = Gson()
        val res = gson.fromJson(respuesta,Personas::class.java)
        Log.e("GSON",res.usuarios?.count().toString())


        var ciudades:ArrayList<Ciudades> = ArrayList()

        ciudades.add(
            Ciudades(
                "Pachuca",
                20,
                "nublado",
                R.drawable.pachuca
            )
        )
        ciudades.add(
            Ciudades(
                "México",
                20,
                "nublado",
                R.drawable.cdmx
            )
        )
        ciudades.add(
            Ciudades(
                "Berlin",
                20,
                "nublado",
                R.drawable.berlin
            )
        )
        ciudades.add(
            Ciudades(
                "Pachuca",
                20,
                "nublado",
                R.drawable.pachuca
            )
        )


        val adaptador = CustomAdapter(this,ciudades)
        gridCiudades.adapter = adaptador
        gridCiudades.onItemClickListener = AdapterView.OnItemClickListener{parent,view,position,id ->
           // Toast.makeText(this,ciudades.get(position).nombre,Toast.LENGTH_LONG).show()
            solicitudHTTPVolley(ciudades.get(position).nombre)
        }
    }

    private fun solicitudHTTPVolley(nombre:String){
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "http://api.openweathermap.org/data/2.5/weather?q=${nombre}&appid=a51a8dd8a5b0d699317d996748404916&units=metric&lang=es"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->

                val gson = Gson()
                val ciudad = gson.fromJson(response,ClimaCiudades::class.java)

                val intent = Intent(this,Clima::class.java)
                intent.putExtra("nombre",ciudad.name)
                intent.putExtra("temperatura",ciudad.main?.temp.toString() + "°")
                intent.putExtra("estatus",ciudad.weather?.get(0)?.description)

                startActivity(intent)
            },
            Response.ErrorListener { error ->
                Log.e("Volley",error.toString())  })
        // Add the request to the RequestQueue.
        queue.add(stringRequest)

    }


}
