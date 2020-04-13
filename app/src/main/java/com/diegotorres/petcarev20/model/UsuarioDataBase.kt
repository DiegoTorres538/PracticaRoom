package com.diegotorres.petcarev20.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Usuario::class], version = 1)
abstract class UsuarioDataBase : RoomDatabase() {
    abstract fun UsuarioDAO(): UsuarioDAO
}