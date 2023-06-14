package com.example.semestralka2.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "moje_rezervacie")
data class MojaRezervacia (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val nazov_podniku : String,
    val nazov_mesta : String,
    val den : String
        )