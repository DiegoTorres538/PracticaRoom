package com.diegotorres.petcarev20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import android.webkit.WebViewFragment
import com.diegotorres.petcarev20.model.Usuario
import com.diegotorres.petcarev20.model.UsuarioDAO
import kotlinx.android.synthetic.main.activity_update_user.*
import java.sql.Types.NULL

class UpdateUser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_user)

        bt_save.setOnClickListener {
            update()
        }
    }

    private fun update(){
        val nombre:String = ed_name.text.toString()
        val usuario:String = ed_user.text.toString()
        val correo:String = ed_email.text.toString()
        val pass:String = ed_pass.text.toString()

        val usarioDB = Usuario(1, nombre, usuario, correo, pass)
        val usuarioDBDao:UsuarioDAO = UsuarioRoom.database.UsuarioDAO()
        usuarioDBDao.updateUsuario(usarioDB)


    }
}
