package com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.MainActivity
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.R
import kotlinx.android.synthetic.main.activity_main_screen.*

class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        questions.setOnClickListener {

            startActivity(Intent(this,MainActivity::class.java ))


        }
        questions1.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java ))




        }
        questions2.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java ))


        }
        questions3.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java ))




        }

    }
}