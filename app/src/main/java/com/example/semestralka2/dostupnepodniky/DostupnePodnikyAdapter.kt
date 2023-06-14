package com.example.semestralka2.dostupnepodniky

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.semestralka2.R
import com.example.semestralka2.database.DostupnyPodnik
import com.example.semestralka2.databinding.RiadokPodnikuBinding

class DostupnePodnikyAdapter (
    private var polozky : List<DostupnyPodnik>,
    private val onItemClickListener: ((DostupnyPodnik) -> Unit)) : RecyclerView.Adapter<DostupnePodnikyAdapter.DostupnyPodnikViewHolder>() {

    class DostupnyPodnikViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val binding: RiadokPodnikuBinding

        init {
            binding = RiadokPodnikuBinding.bind(view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DostupnePodnikyAdapter.DostupnyPodnikViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.riadok_podniku, parent, false)

        return DostupnePodnikyAdapter.DostupnyPodnikViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: DostupnePodnikyAdapter.DostupnyPodnikViewHolder, position: Int) {
        val polozka = polozky[position]

        viewHolder.binding.obalkaRiadkuPodniku.setOnClickListener {
            onItemClickListener(polozka)
        }

        viewHolder.binding.nazovPodnikuDostupnePodniky.text  = polozka.nazov_podniku
        viewHolder.binding.nazovMestaDostupnePodniky.text  = polozka.nazov_mesta
    }

    override fun getItemCount() : Int {
        return polozky.size
    }
}