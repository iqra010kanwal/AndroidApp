package com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.model

import com.google.gson.annotations.SerializedName

class Comments {

    @SerializedName("postId")
    var postId: Int = 0
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("name")
    var name: String = ""
    @SerializedName("email")
    var email: String = ""
    @SerializedName("body")
    var body: String = ""

}