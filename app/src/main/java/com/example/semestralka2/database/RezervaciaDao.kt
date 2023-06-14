package com.example.semestralka2.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface RezervaciaDao {
    @Query("SELECT * FROM moje_rezervacie")
    fun getAllMojeRezervacie(): List<MojaRezervacia>
    @Query("SELECT * FROM dostupne_podniky")
    fun getAllDostupnePodniky(): List<DostupnyPodnik>

    @Query("SELECT * FROM dostupne_podniky WHERE nazov_podniku = :name")
    fun getDostupnyPodnikByNazovPodniku(name: String): DostupnyPodnik

    @Query("DELETE FROM moje_rezervacie")
    fun deleteAllMojeRezervacie()

    @Query("DELETE FROM dostupne_podniky")
    fun deleteAllDostupnePodniky()

    @Insert
    fun insert(vararg mojaRezervacia: MojaRezervacia)
    @Insert
    fun insert(vararg dostupnyPodnik: DostupnyPodnik)

    @Update
    fun update(mojaRezervacia: MojaRezervacia)
    @Update
    fun update(dostupnyPodnik: DostupnyPodnik)

    @Delete
    fun delete(mojaRezervacia: MojaRezervacia)
    @Delete
    fun delete(dostupnyPodnik: DostupnyPodnik)
}