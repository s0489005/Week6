package edu.student.week6

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spin = findViewById<Spinner>(R.id.spinner)
        val txtFN = findViewById<EditText>(R.id.txtFullName)
        val txtEM = findViewById<EditText>(R.id.txtEmail)
        val txtOTHR = findViewById<EditText>(R.id.txtOther)
        val txtShow = findViewById<TextView>(R.id.txtShow)
        val btnSub = findViewById<Button>(R.id.btnSubmit)
        val list = arrayOf ("Online", "TV", "Radio", "Other")
        val adapter1 = ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, list)
        android.R.layout.simple_spinner_item
        android.R.layout.simple_spinner_dropdown_item
        spin.adapter = adapter1

        txtFN.requestFocus()

        btnSub.setOnClickListener {
            when (spin.selectedItem.toString()) {
                "Online" -> txtShow.text =
                    "Name: ${txtFN.text.toString()}\n Email ${txtEM.text.toString()}\n How did you find us? Online"
                "TV" -> txtShow.text =
                    "Name: ${txtFN.text.toString()}\n Email ${txtEM.text.toString()}\n How did you find us? TV"
                "Radio" -> txtShow.text =
                    "Name: ${txtFN.text.toString()}\n Email ${txtEM.text.toString()}\n How did you find us? Radio"
                "Other" -> txtShow.text =
                    "Name: ${txtFN.text.toString()}\n Email ${txtEM.text.toString()}\n How did you find us?\n ${txtOTHR.text.toString()}"

            }
            hideKeyboard()
            txtFN.setText("")
            txtEM.setText("")
            txtOTHR.setText("Other: ")
            txtFN.requestFocus()
        }

        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }

    }

fun hideKeyboard() {
    try {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
    } catch (e: Exception) {
        // TODO: handle exception
    }
    }
}