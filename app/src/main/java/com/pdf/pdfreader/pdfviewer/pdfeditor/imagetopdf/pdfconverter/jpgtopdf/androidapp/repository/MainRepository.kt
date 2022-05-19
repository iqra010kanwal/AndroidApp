package com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.repository

import android.R
import android.content.Context
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.model.Posts
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainRepository(var context: Context, ) {
    fun getPostsList( callbacks: (Array<Posts?>) -> Unit): Array<Posts?> {
        var oneHeroes:Array<Posts?> = arrayOf()
        val call: Call<List<Posts?>?>? = RetrofitClient.instance?.getMyApi()?.getsuperHeroes()
        call?.enqueue(object : Callback<List<Posts?>?> {
            override fun onResponse(call: Call<List<Posts?>?>?, response: Response<List<Posts?>?>) {
                 val myheroList:List<Posts> = response.body() as List<Posts>
                 oneHeroes = arrayOfNulls<Posts>(myheroList.size)
                for (i in myheroList.indices) {
                    oneHeroes[i] = myheroList[i]
                    Log.e("dfff","dgdgg")
                }
                callbacks(oneHeroes)
            }

          override  fun onFailure(call: Call<List<Posts?>?>?, t: Throwable?) {
                Toast.makeText(
                    context,
                    "An error has occured",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
        return oneHeroes
    }


}