package com.diegotorres.petcarev20

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registro_pet_care.*

class RegistroPetCare : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_pet_care)

        botonregistrar.setOnClickListener{
            datosRegistro()
        }
    }

    private fun datosRegistro() {

        val user = usuario_registro.text.toString()
        val correo = correo_registro.text.toString()
        val pass = pass_registro.text.toString()
        val reppass = rep_pass.text.toString()

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
