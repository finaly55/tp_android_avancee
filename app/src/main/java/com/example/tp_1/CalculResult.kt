package com.example.tp_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calcul_result.*
import kotlinx.android.synthetic.main.activity_main.*

class CalculResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcul_result)


        intent?.let {
            val compagny =  intent.getParcelableExtra<Compagny>(MainActivity.COMPAGNY) as Compagny
            tv_activity_type.text = compagny.activty_type
            tv_sale_revenu.text = compagny.sale_revenu.toString()

            var compagnyContribution = 0
            when (compagny.activty_type) {
                "Vente de marchandise" -> {
                    compagnyContribution = ((compagny.sale_revenu *0.128).toInt())
                    tv_contribution.text = compagnyContribution.toString()
                }
                "Location d'habitiation meublée" -> {
                    compagnyContribution = ((compagny.sale_revenu *0.22).toInt())
                    tv_contribution.text = compagnyContribution.toString()
                }
                "Profession libérale" -> {
                    compagnyContribution = ((compagny.sale_revenu *0.06).toInt())
                    tv_contribution.text = compagnyContribution.toString()
                }
                "Location d'habitation meublée de tourisme" -> {
                    compagnyContribution = ((compagny.sale_revenu *0.22).toInt())
                    tv_contribution.text = compagnyContribution.toString()
                }
                "Prestation de service" -> {
                    compagnyContribution = ((compagny.sale_revenu *0.22).toInt())
                    tv_contribution.text = compagnyContribution.toString()
                }
            }
            tv_benefice.text = (compagny.sale_revenu - compagnyContribution).toString()
        }
    }
}