package com.diegotorres.petcarev20

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.diegotorres.petcarev20.model.Usuario
import com.diegotorres.petcarev20.model.UsuarioDAO
import kotlinx.android.synthetic.main.activity_registro_pet_care.*
import java.sql.Types.NULL

class RegistroPetCare : AppCompatActivity() {
    lateinit var nombre:String
    lateinit var user:String
    lateinit var correo:String
    lateinit var pass:String
    lateinit var reppass:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_pet_care)

        botonregistrar.setOnClickListener{
            datosRegistro()
        }
    }

    private fun datosRegistro() {
        nombre = nombre_registro.text.toString()
        user = usuario_registro.text.toString()
        correo = correo_registro.text.toString()
        pass = pass_registro.text.toString()
        reppass = rep_pass.text.toString()
        when {
            pass != reppass -> {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            }
            pass.length < 6 -> {
                Toast.makeText(this, "La contraseña debe tener minimo 6 caracteres", Toast.LENGTH_SHORT)
                    .show()
            }
            else -> {
                val intentRegistro = Intent()
                intentRegistro.putExtra("Usuario", user)
                intentRegistro.putExtra("Correo", correo)
                intentRegistro.putExtra("Contraseña", pass)
                val usario = Usuario(NULL, nombre, user, correo, pass)
                val usarioDAO: UsuarioDAO = UsuarioRoom.database.UsuarioDAO()
                usarioDAO.insertUsuario(usario)

                setResult(Activity.RESULT_OK, intentRegistro)
                finish()
            }
        }
    }


    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
        super.onBackPressed()
    }
}
