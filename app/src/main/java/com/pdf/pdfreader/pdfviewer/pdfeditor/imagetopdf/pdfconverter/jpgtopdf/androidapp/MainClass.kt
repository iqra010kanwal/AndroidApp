package com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp
import android.app.Application
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.repository.MainRepository
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.retrofit.RetrofitClient
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainClass():Application() {
    private val viewModelModule = module {
        viewModel {
            MainViewModel(get())
        }
        single { MainRepository(get()) }
        single { RetrofitClient }
    }
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainClass)
            modules(listOf(viewModelModule))
        }
    }
}