package com.example.semestralka2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.semestralka2.database.DostupnyPodnik
import com.example.semestralka2.database.RezervaciaDatabase
import com.example.semestralka2.databinding.ActivityMainBinding
import com.example.semestralka2.dostupnepodniky.DostupnePodnikyActivity
import com.example.semestralka2.mojerezervacie.MojeRezervacieActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rezervaciaDao = RezervaciaDatabase.getInstance(application).rezervaciaDao()

        if (rezervaciaDao.getAllDostupnePodniky().isEmpty()) {
            val dostupnyPodnik1 = DostupnyPodnik(0, "Podnik 1","Handlová")
            val dostupnyPodnik2 = DostupnyPodnik(0, "Papučka","Handlová")
            val dostupnyPodnik3 = DostupnyPodnik(0, "Niečo","Prievidza")
            val dostupnyPodnik4 = DostupnyPodnik(0, "Spub","Handlová")
            rezervaciaDao.insert(dostupnyPodnik1, dostupnyPodnik2, dostupnyPodnik3, dostupnyPodnik4)
        }

        binding.novaRezervaciaBtn.setOnClickListener {
            startActivity(Intent(this, DostupnePodnikyActivity::class.java))
        }

        binding.mojeRezervacieBtn.setOnClickListener {
            startActivity(Intent(this, MojeRezervacieActivity::class.java))
        }
    }
}