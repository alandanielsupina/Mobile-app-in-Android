package com.example.semestralka2.vybranypodnik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.text.Editable
import android.widget.Toast
import com.example.semestralka2.database.DostupnyPodnik
import com.example.semestralka2.database.MojaRezervacia
import com.example.semestralka2.database.RezervaciaDao
import com.example.semestralka2.database.RezervaciaDatabase
import com.example.semestralka2.databinding.ActivityVybranyPodnikBinding
import com.example.semestralka2.mojerezervacie.MojeRezervacieActivity

class VybranyPodnikActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityVybranyPodnikBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val nazovVybranehoPodniku = prefs.getString("nazovVybranehoPodniku","")

        val rezervaciaDao = RezervaciaDatabase.getInstance(application).rezervaciaDao()
        val vybranyPodnik = rezervaciaDao.getDostupnyPodnikByNazovPodniku(nazovVybranehoPodniku!!);

        binding.nazovPodniku.text = nazovVybranehoPodniku
        binding.nazovMesta.text = vybranyPodnik.nazov_mesta

        if (savedInstanceState != null) {
            val nazovDna = savedInstanceState.getString("nazovDna", "den")
            binding.inputDen.text = Editable.Factory.getInstance().newEditable(nazovDna)
        }

        binding.potvrditBtn.setOnClickListener {
            if (binding.inputDen.text.toString().trim().isNotEmpty()) {
                when (binding.inputDen.text.toString()) {
                    "Pondelok" -> pridajRezervaciu("Pondelok", vybranyPodnik, rezervaciaDao)
                    "Utorok" -> pridajRezervaciu("Utorok", vybranyPodnik, rezervaciaDao)
                    "Streda" -> pridajRezervaciu("Streda", vybranyPodnik, rezervaciaDao)
                    "Stvrtok" -> pridajRezervaciu("Štvrtok", vybranyPodnik, rezervaciaDao)
                    "Piatok" -> pridajRezervaciu("Piatok", vybranyPodnik, rezervaciaDao)
                    "Sobota" -> pridajRezervaciu("Sobota", vybranyPodnik, rezervaciaDao)
                    "Nedela" -> pridajRezervaciu("Nedeľa", vybranyPodnik, rezervaciaDao)
                    else -> Toast.makeText(this, "Nesprávny formát dňa", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Zadajte deň", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val binding = ActivityVybranyPodnikBinding.inflate(layoutInflater)
        outState.putString("nazovDna", binding.inputDen.text.toString())
    }

    private fun pridajRezervaciu(den : String, vybranyPodnik : DostupnyPodnik, rezervaciaDao : RezervaciaDao) {
        val novaRezervacia = MojaRezervacia(0, vybranyPodnik.nazov_podniku, vybranyPodnik.nazov_mesta, den)
        rezervaciaDao.insert(novaRezervacia);

        startActivity(Intent(this, MojeRezervacieActivity::class.java))
    }
}