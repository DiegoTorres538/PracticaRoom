package com.diegotorres.petcarev20.model

import androidx.room.*
import java.sql.RowId

@Dao
interface UsuarioDAO {
    @Insert
    fun insertUsuario(usuario: Usuario)

    @Update
    fun updateUsuario(usuario: Usuario)

}