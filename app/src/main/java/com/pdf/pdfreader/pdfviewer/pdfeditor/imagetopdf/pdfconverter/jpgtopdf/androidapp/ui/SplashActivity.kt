package com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//adding theme to splash activity , using svgs on splash layout, setting layout using drawables will make changes to load spalsh fastly
        Handler().postDelayed({
            startActivity(Intent(this,MainScreen::class.java))
        }, 4000)
    }
}