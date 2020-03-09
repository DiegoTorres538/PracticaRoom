package com.diegotorres.petcarev20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_pet.*

class AddPet : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_pet)

        save.setOnClickListener{
            saveInfo()
        }

    }
    private fun saveInfo(){
        val intent = Intent(this,PetFragment::class.java)
        startActivity(intent)
    }
}
