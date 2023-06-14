package com.example.semestralka2.mojerezervacie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.semestralka2.R
import com.example.semestralka2.database.MojaRezervacia
import com.example.semestralka2.databinding.RiadokRezervacieBinding

class MojeRezervacieAdapter (private var polozky : List<MojaRezervacia>) : RecyclerView.Adapter<MojeRezervacieAdapter.MojaRezervaciaViewHolder>() {

        class MojaRezervaciaViewHolder(view : View) : RecyclerView.ViewHolder(view) {
            val binding: RiadokRezervacieBinding

            init {
                binding = RiadokRezervacieBinding.bind(view)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MojeRezervacieAdapter.MojaRezervaciaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.riadok_rezervacie, parent, false)

        return MojaRezervaciaViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MojeRezervacieAdapter.MojaRezervaciaViewHolder, position: Int) {
        val polozka = polozky[position]

        viewHolder.binding.nazovPodnikuMojeRezervacie.text  = polozka.nazov_podniku
        viewHolder.binding.nazovMestaMojeRezervacie.text  = polozka.nazov_mesta
        viewHolder.binding.nazovDnaMojeRezervacie.text  = polozka.den
    }

    override fun getItemCount() : Int {
        return polozky.size
    }
}