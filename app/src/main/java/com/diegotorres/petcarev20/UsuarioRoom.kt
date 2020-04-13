package com.diegotorres.petcarev20

import android.app.Application
import androidx.room.Room
import com.diegotorres.petcarev20.model.UsuarioDataBase

class UsuarioRoom : Application() {

    companion object{
        lateinit var database: UsuarioDataBase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            UsuarioDataBase::class.java,
            "usuario_DB"
        )
            .allowMainThreadQueries()
            .build()
    }

}