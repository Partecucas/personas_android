package com.example.recyclerviewexamplo.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewexamplo.Persona
import com.example.recyclerviewexamplo.databinding.ItemSuperheroBinding

class PersonaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemSuperheroBinding.bind(view)

    fun render(
        personaModel: Persona,
        onClickListener: (Persona) -> Unit,
        onClickDelete: (Int) -> Unit
    ) {
        binding.nombre.text = personaModel.nombre
        binding.correo.text = personaModel.correo
        binding.cargo.text = personaModel.cargo
        Glide.with(binding.imgpersona.context).load(personaModel.photo).into(binding.imgpersona)
        binding.imgpersona.setOnClickListener { onClickListener(personaModel) }
        itemView.setOnClickListener { Toast.makeText(itemView.context, "KotlinMan", Toast.LENGTH_SHORT).show()}
        binding.btnDelete.setOnClickListener {  onClickDelete(adapterPosition) }
        binding.descripcion.text=personaModel.descripcion
        binding.rol.text=personaModel.rol
    }
}