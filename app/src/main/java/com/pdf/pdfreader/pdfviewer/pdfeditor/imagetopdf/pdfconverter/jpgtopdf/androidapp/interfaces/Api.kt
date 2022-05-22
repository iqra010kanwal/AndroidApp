package com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.interfaces

import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.model.Comments
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.model.Posts
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface Api {
    @GET("posts")
    fun getsuperHeroes(): Call<List<Posts?>?>?

    @GET("posts/{postId}/comments")
    fun getComment(@Path("postId") postId: Int?): Call<List<Comments?>?>?

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }
}