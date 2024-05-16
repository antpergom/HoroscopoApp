package com.example.horoscopoapp.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopoapp.R
import com.example.horoscopoapp.dao.ELEMENTO
import com.example.horoscopoapp.databinding.ItemSignoZodiacoBinding
import com.example.horoscopoapp.models.SignoZodiaco
import com.example.horoscopoapp.models.SignoZodiacoDescripcion


class SignoZodiacoMenuAdapter(val context: Context,
                              private val items: List<SignoZodiaco>,
                              private val desc: List<SignoZodiacoDescripcion>,
                              private val navController: NavController)
    : RecyclerView.Adapter<SignoZodiacoMenuAdapter.SignoZodiacoItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SignoZodiacoItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
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
        holder.card?.background = getSignColor(items[position].signoZodiacoId)
        holder.card?.setOnClickListener{
            navController.navigate(R.id.action_fragmentMenu_to_fragmentDetalle)
        }
    }

    class SignoZodiacoItemViewHolder(binding: ItemSignoZodiacoBinding) : RecyclerView.ViewHolder(binding.root) {
        var imagen: ImageView? = binding.itemSignoZodiacoImg
        var nombre: TextView? = binding.itemSignoZodiacoTv
        var card: CardView? = binding.itemSignoZodiacoCv

        init{
            binding.root.setOnClickListener {
                Log.d("Item signo zodiaco img onClickListener pulsado", "pulsado")
            }
        }
    }

    private fun getSignColor(signoZodiacoId: Int): Drawable?{
        val bgGrad: Drawable
        val descFromSigno = desc.find { desc -> desc.descripcionId == signoZodiacoId }

        when(descFromSigno?.elemento?.first()){
            ELEMENTO.TIERRA -> {
                bgGrad = ContextCompat.getDrawable(context, R.drawable.gradient_tierra)!!
            }
            ELEMENTO.FUEGO -> {
                bgGrad = ContextCompat.getDrawable(context, R.drawable.gradient_fuego)!!
            }
            ELEMENTO.AGUA -> {
                bgGrad = ContextCompat.getDrawable(context, R.drawable.gradient_agua)!!
            }
            ELEMENTO.AIRE -> {
                bgGrad = ContextCompat.getDrawable(context, R.drawable.gradient_aire)!!
            }
            else -> {
                bgGrad = ContextCompat.getDrawable(context, R.drawable.gradient_tierra)!!
            }
        }
        return bgGrad
    }
}