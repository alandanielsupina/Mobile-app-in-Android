package com.example.semestralka2.mojerezervacie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.semestralka2.database.RezervaciaDatabase
import com.example.semestralka2.databinding.ActivityMojeRezervacieBinding

class MojeRezervacieActivity : AppCompatActivity() {
    /**
     * Metóda nastaví data binding a adaptér pre Recycle View.
     *
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMojeRezervacieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rezervaciaDao = RezervaciaDatabase.getInstance(application).rezervaciaDao()
        val zoznamRezervacii = rezervaciaDao.getAllMojeRezervacie()

        binding.mojeRezervacieZoznam.adapter = MojeRezervacieAdapter(zoznamRezervacii)
    }
}