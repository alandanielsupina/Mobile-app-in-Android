package com.example.semestralka2.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dostupne_podniky")
data class DostupnyPodnik(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val nazov_podniku : String,
    val nazov_mesta : String
)
