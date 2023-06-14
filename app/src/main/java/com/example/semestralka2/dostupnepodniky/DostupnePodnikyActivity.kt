package com.example.semestralka2.dostupnepodniky

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.example.semestralka2.database.RezervaciaDatabase
import com.example.semestralka2.databinding.ActivityDostupnePodnikyBinding
import com.example.semestralka2.vybranypodnik.VybranyPodnikActivity

class DostupnePodnikyActivity : AppCompatActivity() {
    /**
     * Metóda nastaví data binding a adaptér pre Recycle View.
     *
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDostupnePodnikyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rezervaciaDao = RezervaciaDatabase.getInstance(application).rezervaciaDao()
        val zoznamPodnikov = rezervaciaDao.getAllDostupnePodniky()

        binding.dostupnePodnikyZoznam.adapter = DostupnePodnikyAdapter(zoznamPodnikov) { dostupnyPodnik ->
            val prefs = PreferenceManager.getDefaultSharedPreferences(this)
            prefs.edit().putString("nazovVybranehoPodniku", dostupnyPodnik.nazov_podniku).apply()
            startActivity(Intent(this, VybranyPodnikActivity::class.java))
        }
    }
}