package com.example.recyclerviewexamplo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexamplo.R
import com.example.recyclerviewexamplo.Persona

class PersonaAdapter(
    private var personList: List<Persona>,
    private val onClickListener: (Persona) -> Unit,
    private val onClickDelete:(Int) -> Unit
) : RecyclerView.Adapter<PersonaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PersonaViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        val item = personList[position]
        holder.render(item, onClickListener, onClickDelete)
    }

    override fun getItemCount(): Int = personList.size

    fun updateSuperHeroes(superheroList: List<Persona>){
        this.personList = superheroList
        notifyDataSetChanged()
    }
}