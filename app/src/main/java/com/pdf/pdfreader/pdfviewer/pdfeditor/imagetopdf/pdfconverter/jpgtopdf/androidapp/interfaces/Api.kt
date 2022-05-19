package com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.interfaces

import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.model.Posts
import retrofit2.Call
import retrofit2.http.GET


interface Api {
    @GET("posts")
    fun getsuperHeroes(): Call<List<Posts?>?>?

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }
}