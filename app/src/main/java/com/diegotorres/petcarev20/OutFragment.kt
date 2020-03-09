package com.diegotorres.petcarev20

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_out.view.*

/**
 * A simple [Fragment] subclass.
 */
class OutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_out, container, false)
        root.logout.setOnClickListener {
            goToInicio()
        }
        return root
    }

    private fun goToInicio(){
        val intent = Intent(context,LoginPetCare::class.java)
        startActivity(intent)
    }
    
}
