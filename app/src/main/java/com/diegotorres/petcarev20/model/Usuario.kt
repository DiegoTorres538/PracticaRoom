package com.diegotorres.petcarev20.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_info_usuario")
class Usuario(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name ="name") val name: String,
    @ColumnInfo(name ="user") val user: String,
    @ColumnInfo(name ="email") val email: String,
    @ColumnInfo(name ="pass") val pass: String
)