package com.miprimerapp.clima.Ejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miprimerapp.clima.R

class ActivityEjemploDeClases : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_elbueno)



        //Ejemplo para clases
        /*
        var manzana =  Frutas("rojo","dulce",4,100)
        var platano = Frutas("amarillo","dulce",10,100,"mediono")

        Toast.makeText(this,manzana.color,Toast.LENGTH_SHORT).show()
        println(manzana.tamanio)
        println(platano.tamanio)

        var aguacate = FrutasConGrasa(10)

        aguacate.color = "verde"
        println(aguacate.color)

        aguacate.pudrirse()
        aguacate.muestraFrescura()
        /*
        manzana.muestraFrescura()

        manzana.pudrirse()
        manzana.pudrirse()

        manzana.muestraFrescura()*/
        */

    }
}
