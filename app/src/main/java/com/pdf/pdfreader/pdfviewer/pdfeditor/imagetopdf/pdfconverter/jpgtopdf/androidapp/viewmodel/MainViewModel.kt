package com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.model.Comments
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.model.Image
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.model.Posts
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.repository.MainRepository

class MainViewModel(var mainRepository: MainRepository) : ViewModel() {
    var array: ArrayList<Posts> = arrayListOf<Posts>()
    var mutableLiveDataimage: MutableLiveData<ArrayList<Image>>? = null
    fun getPostList(callbacks: (Array<Posts?>) -> Unit) {
        mainRepository.getPostsList(callbacks)
    }

    fun getList(list: Array<Posts?>) {
        array?.toCollection(ArrayList())
    }


    fun getImage(): ArrayList<Image>? {
        return mainRepository.getImages()
    }


    fun getComments(callback: (Array<Comments?>) -> Unit, pos:Int) {

         mainRepository.getCommentsList( callback, pos)

    }


}