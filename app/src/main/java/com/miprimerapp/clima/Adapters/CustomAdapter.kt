package com.miprimerapp.clima.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.miprimerapp.clima.Models.Ciudades
import com.miprimerapp.clima.R
import com.miprimerapp.clima.Utils.cargarImagen
import kotlinx.android.synthetic.main.template.view.*

class CustomAdapter(var context:Context,items:ArrayList<Ciudades>):BaseAdapter(){

    var items:ArrayList<Ciudades>? = null
    //lateinit var items: ArrayList<Ciudades>
    init {
        this.items = items
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder:ViewHolder? = null
        var vista:View? = null

        if(vista==null){
            vista = LayoutInflater.from(context).inflate(R.layout.template_grid,null)
            holder = ViewHolder(vista)
            vista.tag = holder
        }else{
            holder = vista.tag as? ViewHolder
        }

        val item = getItem(position) as Ciudades
        holder?.nombre?.text = item.nombre
        //holder?.imagen?.setImageResource(item.imagen)
        holder?.imagen?.cargarImagen(item.imagen)

        return vista!!
    }

    override fun getItem(position: Int): Any {
        return items?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items?.count()!!
    }

    private class ViewHolder(vista:View){

        var nombre:TextView? = null
        var imagen:ImageView? = null
        init {
            this.nombre = vista.txtCiudad
            this.imagen = vista.imgCiudad
        }

    }

}