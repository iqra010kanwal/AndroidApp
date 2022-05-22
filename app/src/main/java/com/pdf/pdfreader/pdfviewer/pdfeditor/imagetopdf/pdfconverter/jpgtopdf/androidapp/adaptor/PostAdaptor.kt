package com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.R
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.interfaces.CallbackListener
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.model.Posts

class PostAdaptor(var array: ArrayList<Posts?>, var callbackListener: CallbackListener):RecyclerView.Adapter<PostAdaptor.PostItem>() {
    inner class PostItem(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.title)
        var body: TextView = view.findViewById(R.id.body)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItem {
        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)

        return PostItem(view)
    }

    override fun onBindViewHolder(holder: PostItem, position: Int) {
        holder.title.text = array.get(position)?.title
        holder.body.text = array.get(position)?.body
        holder.body.setOnClickListener {
            callbackListener.onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }


    fun filterList(filterllist: ArrayList<Posts?>) {
        array = filterllist
        notifyDataSetChanged()
    }

    public fun deleteDone(position: Int) {
        array.removeAt(position)
    }
}