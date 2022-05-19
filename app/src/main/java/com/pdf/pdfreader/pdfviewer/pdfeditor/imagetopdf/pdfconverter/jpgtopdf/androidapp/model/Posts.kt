package com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.model

import com.google.gson.annotations.SerializedName

class Posts {
    @SerializedName("userId")
     var userId: Int = 0
    @SerializedName("id")
     var id: Int = 0
    @SerializedName("title")
     var title: String = ""
    @SerializedName("body")
     var body: String = ""

}