package com.miprimerapp.clima.Utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.miprimerapp.clima.R

fun ImageView.cargarImagen (imagen:Int){
    Glide
        .with(this.context)
        .load(imagen)
        .centerCrop()
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher_round)
        .into(this)
}