package com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.R
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.utils.PreferenceClass
import kotlinx.android.synthetic.main.activity_question_no_three.*

class QuestionNoThreeAct : AppCompatActivity() {
    private var preferenceClass: PreferenceClass? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_no_three)
        preferenceClass = PreferenceClass(this)
        preferenceClass?.putBoolean("look", true)
        values.text="Name ${preferenceClass?.getString("name")} \n " +
                "Designation ${preferenceClass?.getString("designation")}"
       // Toast.makeText(this, "${preferenceClass?.getString("name")}", Toast.LENGTH_SHORT).show()

        button.setOnClickListener {
            if (!name_et.text.isEmpty() && !desgination_et.text.isEmpty()) {
                preferenceClass?.putString("name", name_et.text.toString())
                preferenceClass?.putString("designation", desgination_et.text.toString())
                Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show()
                values.text="Name ${preferenceClass?.getString("name")} \n " +
                        "Designation ${preferenceClass?.getString("designation")}"
            } else {
                Toast.makeText(this, "fill both fields", Toast.LENGTH_SHORT).show()
            }


        }
        Handler().postDelayed({
            Toast.makeText(
                this,
                "${preferenceClass?.getBoolean("look")}",
                Toast.LENGTH_SHORT
            )
                .show()

        }, 1000)
    }
}