package com.example.horoscopoapp.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopoapp.models.SignoZodiaco

class AdapterSignoZodiaco(private val contecto: Context, private val items: List<SignoZodiaco>)
    : BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(i: Int): Any {
        return items[i]
    }

    override fun getItemId(i: Int): Long {
        return items[i].signoZodiacoId.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        TODO("Not yet implemented")
    }

    class SignoZodiacoItemViewHolder(item : View) : RecyclerView.ViewHolder(item) {
        var imagen: String? = null;
        var nombre: String? = null;
        var fecha: String? = null;
    }


}