package com.example.tp_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var radioButton: RadioButton

    companion object {
        const val COMPAGNY = "compagny"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_validate.isEnabled = false
        et_sale_revenu.addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int) {
                btn_validate.isEnabled = s.toString().trim{ it <= ' ' }.isNotEmpty()
            }
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int,
                                           after:Int) {
            }
            override fun afterTextChanged(s: Editable) {
            }
        })

        btn_validate.setOnClickListener{
            val selectedOption: Int = rg_activty_type!!.checkedRadioButtonId
            // Assigning id of the checked radio button
            radioButton = findViewById(selectedOption)

            val compagny = Compagny(radioButton.text as String, et_sale_revenu.text.toString().toInt())
            val intent = Intent(this, CalculResult::class.java)
            intent.putExtra(COMPAGNY, compagny)
            startActivity(intent)
        }
    }
}