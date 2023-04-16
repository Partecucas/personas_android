package com.example.recyclerviewexamplo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexamplo.adapter.PersonaAdapter
import com.example.recyclerviewexamplo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var personaMutableList: MutableList<Persona> =
        PersonaProvider.PersonLists.toMutableList()
    private lateinit var adapter: PersonaAdapter
    private val llmanager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.etFilter.addTextChangedListener{userFilter->
            val personafiltro=
            personaMutableList.filter { Persona ->
                Persona.rol.lowercase().contains(userFilter.toString().lowercase())
            }
            adapter.uptdatePersona(personafiltro)
        }
        initRecyclerView()
    }

    private fun createSuperHero() {
        val persona = Persona(
            "Incognito",
            "AristiDevsCorporation",
            "???????",
            "https://pbs.twimg.com/profile_images/1037281659727634432/5x2XVPwB_400x400.jpg",
            "sapo",
            "a",
        )

        personaMutableList.add(index = 3, persona)
        adapter.notifyItemInserted(3)
        llmanager.scrollToPositionWithOffset(3, 10)
    }

    private fun initRecyclerView() {
        adapter = PersonaAdapter(
            personList = personaMutableList,
            onClickListener = { superhero -> onItemSelected(superhero) },
            onClickDelete = { position -> onDeletedItem(position) }
        )
        binding.recyclerSuperHero.layoutManager = llmanager
        binding.recyclerSuperHero.adapter = adapter

    }

    private fun onDeletedItem(position: Int) {
        personaMutableList.removeAt(position)
        adapter.notifyItemRemoved(position)
    }

    private fun onItemSelected(persona: Persona) {
        Toast.makeText(this, persona.correo, Toast.LENGTH_SHORT).show()
    }
}

















