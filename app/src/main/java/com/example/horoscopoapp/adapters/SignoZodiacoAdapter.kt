package com.example.horoscopoapp.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopoapp.R
import com.example.horoscopoapp.databinding.ItemSignoZodiacoBinding
import com.example.horoscopoapp.models.SignoZodiaco

class SignoZodiacoAdapter(private val items: List<SignoZodiaco>)
    : RecyclerView.Adapter<SignoZodiacoAdapter.SignoZodiacoItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SignoZodiacoItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //TODO: esto está mal, el binding es del padre, no el del ViewHolder
        val binding = ItemSignoZodiacoBinding.inflate(inflater, parent, false)
        return SignoZodiacoItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        Log.d("Elementos del adapter", "items = ${items.size}")
        return items.size
    }

    override fun onBindViewHolder(holder: SignoZodiacoItemViewHolder, position: Int) {
        //TODO: cambiar la imagen
        //holder.imagen?.textAlignment = items[position].nombre
        holder.nombre?.text = items[position].nombre
    }

    class SignoZodiacoItemViewHolder(binding: ItemSignoZodiacoBinding) : RecyclerView.ViewHolder(binding.root) {
        var imagen: ImageView? = binding.itemSignoZodiacoImg
        var nombre: TextView? = binding.itemSignoZodiacoTv

        init{
            binding.root.setOnClickListener {
                Log.d("Item signo zodiaco img onClickListener pulsado", "pulsado")
            }
        }
    }
}