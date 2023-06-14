package com.example.semestralka2.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface RezervaciaDao {

    /**
     * Metóda vráti všetky rezervácie
     *
     * @return  rezervacie
     */
    @Query("SELECT * FROM moje_rezervacie")
    fun getAllMojeRezervacie(): List<MojaRezervacia>
    /**
     * Metóda vráti všetky podniky
     *
     * @return  podniky
     */
    @Query("SELECT * FROM dostupne_podniky")
    fun getAllDostupnePodniky(): List<DostupnyPodnik>

    /**
     * Metóda vráti podnik podľa názvu podniku
     *
     * @param názov_podniku
     * @return podnik
     */
    @Query("SELECT * FROM dostupne_podniky WHERE nazov_podniku = :name")
    fun getDostupnyPodnikByNazovPodniku(name: String): DostupnyPodnik


    /**
     * Metóda vymaže všetky rezervácie
     */
    @Query("DELETE FROM moje_rezervacie")
    fun deleteAllMojeRezervacie()

    /**
     * Metóda vymaže všetky dostupné podniky
     */
    @Query("DELETE FROM dostupne_podniky")
    fun deleteAllDostupnePodniky()

    /**
     * Metóda pridá rezervácie
     *
     * @param rezervácie
     */
    @Insert
    fun insert(vararg mojaRezervacia: MojaRezervacia)

    /**
     * Metóda pridá podniky
     *
     * @param podniky
     */
    @Insert
    fun insert(vararg dostupnyPodnik: DostupnyPodnik)

    /**
     * Metóda aktualizuje rezervacie
     *
     * @param rezervacie
     */
    @Update
    fun update(mojaRezervacia: MojaRezervacia)

    /**
     * Metóda aktualizuje podniky
     *
     * @param podniky
     */
    @Update
    fun update(dostupnyPodnik: DostupnyPodnik)

    /**
     * Metóda vymaže rezervácie
     *
     * @param rezervacie
     */
    @Delete
    fun delete(mojaRezervacia: MojaRezervacia)

    /**
     * Metóda vymaže podniky
     *
     * @param podniky
     */
    @Delete
    fun delete(dostupnyPodnik: DostupnyPodnik)
}