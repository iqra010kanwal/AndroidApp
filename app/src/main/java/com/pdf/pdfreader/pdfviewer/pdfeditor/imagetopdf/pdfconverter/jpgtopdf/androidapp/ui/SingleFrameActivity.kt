package com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.LinearLayoutManager
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.R
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.adaptor.ImageAdaptor
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_single_frame.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SingleFrameActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModel()
    private var imageAdaptor: ImageAdaptor? = null
    private var linearLayoutManager: GridLayoutManager? = null
    private var toolbar: Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_frame)
        toolbar = findViewById(R.id.toolbar_single_frame)
        toolbar?.title = "SingleFrame"
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        imageAdaptor = ImageAdaptor(this, mainViewModel.getImage()!!)
        linearLayoutManager = GridLayoutManager(this, 2)
        linearLayoutManager?.setSpanSizeLookup(object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (imageAdaptor!!.is_add(position))
                    2
                else 1
            }
        })
        recyclarview.layoutManager = linearLayoutManager
        recyclarview.adapter = imageAdaptor

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}