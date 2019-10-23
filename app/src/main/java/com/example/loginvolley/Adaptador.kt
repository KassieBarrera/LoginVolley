package com.example.loginvolley

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.card.view.*

class Adaptador(context: Context, var listaPersona: ArrayList<Persona>) : BaseAdapter() {

    var contexto: Context? = context
    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val persona = listaPersona[position]
    val inflater = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val vista = inflater.inflate(R.layout.card, null)
        vista.nombr.text =  persona.nombre
        vista.direccion.text = persona.direccion
        vista.telefono.text = persona.telefono

        return vista
    }

    override fun getItem(position: Int): Any {
        return listaPersona[0]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listaPersona.size
    }

}