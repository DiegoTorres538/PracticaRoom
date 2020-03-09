package com.diegotorres.petcarev20

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login_pet_care.*

class LoginPetCare : AppCompatActivity() {
    lateinit var user:String
    lateinit var correo:String
    lateinit var pass:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_pet_care)

        val datosMain = intent?.extras
        user = datosMain?.getString("Usuario").toString()
        correo = datosMain?.getString("Correo").toString()
        pass = datosMain?.getString("Contraseña").toString()

        register_boton.setOnClickListener {
            goToRegistro()
        }

        login.setOnClickListener{
            goToMain()
        }
    }
    private fun goToRegistro(){
        val intent = Intent(this, RegistroPetCare::class.java)
        startActivityForResult(intent,1234)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1234 && resultCode == Activity.RESULT_OK){
            val datas =data?.extras
            user = datas?.getString("Usuario").toString()
            correo = datas?.getString("Correo").toString()
            pass = datas?.getString("Contraseña").toString()
        }
    }

    private fun goToMain(){
        val userAux = user_login.text.toString()
        val passAux = pass_login.text.toString()
        when {
            user != userAux || pass != passAux -> {
                Toast.makeText(this,"Usuario o Contraseña invalido", Toast.LENGTH_SHORT).show()
            }
            else -> {
                val datoMain = Intent(this,MainActivity::class.java)
                datoMain.putExtra("Usuario",user)
                datoMain.putExtra("Correo",correo)
                datoMain.putExtra("Contraseña",pass)
                startActivity(datoMain)
                finish()
            }
        }
    }
}
