package com.example.textinputedittextstylespinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val yourEt = findViewById<TextInputEditText>(R.id.TextInputSpinner)

        yourEt.setOnClickListener { view -> showCustomSpinnerDialog(view) }
    }

    companion object {
        lateinit var control_carga : String
    }

    private fun showCustomSpinnerDialog(v: View) {
        val titleId: Int = R.string.carga_select
        val listId: Int = R.array.select_carga
        val editTextId: Int = R.id.TextInputSpinner
        val customSppiner = "CustomSpinner"
        val spinnerFragment = SpinnerFragment.newInstance(titleId, listId, editTextId)
        spinnerFragment!!.show(supportFragmentManager, customSppiner)

    };
}
