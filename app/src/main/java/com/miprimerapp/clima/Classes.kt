package com.miprimerapp.clima

class Ciudades(nombre:String,grados:Int,estatus:String){

    var nombre:String = ""
    var grados:Int = 0
    var estatus:String = ""

    init{
        this.nombre = nombre
        this.grados = grados
        this.estatus = estatus
    }
}


/**
 *
open class Frutas(){

    //Variables o elementos
    var color:String = ""
    var sabor:String = ""
    var precio:Int = 0
    var frescura:Int = 100
    var tamanio:String = ""


    //Construn¿ctor
    constructor (color:String,sabor:String,precion:Int,frescura:Int):this(){
        this.color = color
        this.sabor = sabor
        this.precio = precio
        this.frescura = frescura
    }
    constructor (color:String,sabor:String,precion:Int,frescura:Int,tamanio:String):this(){
        this.color = color
        this.sabor = sabor
        this.precio = precio
        this.frescura = frescura
        this.tamanio = tamanio
    }

    //Escribir métodos
    fun pudrirse(){
        println("La fruta se está pudriendo")
        this.frescura -= 20
    }

    fun muestraFrescura(){
        println("La fruta tiene una frescura de ${this.frescura}")
    }
}

class FrutasConGrasa():Frutas(){

    var cantidadGrasa:Int = 0

    constructor(cantidadGrasa:Int):this(){
        this.cantidadGrasa = cantidadGrasa
    }
}


class Frutas(color:String, sabor:String,precio:Int){

//Variables o elementos
var color:String = ""
var sabor:String = ""
var precio:Int = 0
var frescura:Int = 100

init{
this.color = color
this.sabor = sabor
this.precio = precio
this.frescura = 100
}

//Escribir métodos
fun pudrirse(){
println("La fruta se está pudriendo")
this.frescura -= 20
}

fun muestraFrescura(){
println("La fruta tiene una frescura de ${this.frescura}")
}
}


 */
