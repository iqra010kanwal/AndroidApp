package com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.repository

import android.R
import android.content.Context
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.model.Comments
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.model.Image
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.model.Posts
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainRepository(var context: Context) {
    private var imageList: ArrayList<Image> = arrayListOf()
    fun getPostsList(callbacks: (Array<Posts?>) -> Unit): Array<Posts?> {
        var oneHeroes: Array<Posts?> = arrayOf()
        val call: Call<List<Posts?>?>? = RetrofitClient.instance?.getMyApi()?.getsuperHeroes()
        call?.enqueue(object : Callback<List<Posts?>?> {
            override fun onResponse(call: Call<List<Posts?>?>?, response: Response<List<Posts?>?>) {
                val myheroList: List<Posts> = response.body() as List<Posts>
                oneHeroes = arrayOfNulls<Posts>(myheroList.size)
                for (i in myheroList.indices) {
                    oneHeroes[i] = myheroList[i]
                    Log.e("dfff", "dgdgg")
                }
                callbacks(oneHeroes)
            }

            override fun onFailure(call: Call<List<Posts?>?>?, t: Throwable?) {
                Toast.makeText(
                    context,
                    "An error has occured",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
        return oneHeroes
    }

    fun getCommentsList(callbacks: (Array<Comments?>) -> Unit, postid:Int): Array<Comments?> {
        var oneHeroes: Array<Comments?> = arrayOf()
        val call: Call<List<Comments?>?>? = RetrofitClient.instance?.getMyApi()?.getComment(postid)
        call?.enqueue(object : Callback<List<Comments?>?> {
            override fun onResponse(call: Call<List<Comments?>?>?, response: Response<List<Comments?>?>) {
                val myheroList: List<Comments> = response.body() as List<Comments>
                oneHeroes = arrayOfNulls<Comments>(myheroList.size)
                for (i in myheroList.indices) {
                    oneHeroes[i] = myheroList[i]
                    Log.e("dfff", "dgdgg")
                }
                callbacks(oneHeroes)
            }

            override fun onFailure(call: Call<List<Comments?>?>?, t: Throwable?) {
                Toast.makeText(
                    context,
                    "An error has occured",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
        return oneHeroes
    }


    fun getImages(): ArrayList<Image> {
        var image = Image(context.resources.getDrawable(R.drawable.ic_media_ff))
        imageList.add(image)
        var image1 = Image(context.resources.getDrawable(R.drawable.ic_media_ff))
        imageList.add(image1)
        var image2 = Image(context.resources.getDrawable(R.drawable.ic_media_ff))
        imageList.add(image2)
        var image3 = Image(context.resources.getDrawable(R.drawable.ic_media_ff))
        imageList.add(image3)
        var image4 = Image(context.resources.getDrawable(R.drawable.ic_media_ff))
        imageList.add(image4)
        var image5 = Image(context.resources.getDrawable(R.drawable.ic_media_ff))
        imageList.add(image5)
        var image6 = Image(context.resources.getDrawable(R.drawable.ic_media_ff))
        imageList.add(image6)
        var image7 = Image(context.resources.getDrawable(R.drawable.ic_media_ff))
        imageList.add(image7)
        var image8 = Image(context.resources.getDrawable(R.drawable.ic_media_ff))
        imageList.add(image8)
        var image9 = Image(context.resources.getDrawable(R.drawable.ic_media_ff))
        imageList.add(image9)
        var image10 = Image(context.resources.getDrawable(R.drawable.ic_media_ff))
        imageList.add(image10)
        return imageList
    }


}