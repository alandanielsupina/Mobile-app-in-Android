package com.example.semestralka2.mojerezervacie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.semestralka2.R
import com.example.semestralka2.database.MojaRezervacia
import com.example.semestralka2.databinding.RiadokRezervacieBinding

/**
 * Trieda je adaptér pre Recycle View, ktorý je využívaný v MojeRezervacieActivity
 *
 * @param polozky
 */
class MojeRezervacieAdapter (private var polozky : List<MojaRezervacia>) : RecyclerView.Adapter<MojeRezervacieAdapter.MojaRezervaciaViewHolder>() {

    /**
     * Trieda je View Holder pre rezervaciu
     *
     * @param view
     */
    class MojaRezervaciaViewHolder(view : View) : RecyclerView.ViewHolder(view) {
            val binding: RiadokRezervacieBinding

            init {
                binding = RiadokRezervacieBinding.bind(view)
            }
        }

    /**
     * Metóda vytvára nový View Holder pre každú položku
     *
     * @param parent
     * @param viewType
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MojeRezervacieAdapter.MojaRezervaciaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.riadok_rezervacie, parent, false)

        return MojaRezervaciaViewHolder(view)
    }

    /**
     * Metóda nastavuje obsah jednotlivých položiek
     *
     * @param viewHolder
     * @param position
     */
    override fun onBindViewHolder(viewHolder: MojeRezervacieAdapter.MojaRezervaciaViewHolder, position: Int) {
        val polozka = polozky[position]

        viewHolder.binding.nazovPodnikuMojeRezervacie.text  = polozka.nazov_podniku
        viewHolder.binding.nazovMestaMojeRezervacie.text  = polozka.nazov_mesta
        viewHolder.binding.nazovDnaMojeRezervacie.text  = polozka.den
    }

    /**
     * Metóda vracia počet položiek v zozname
     */
    override fun getItemCount() : Int {
        return polozky.size
    }
}