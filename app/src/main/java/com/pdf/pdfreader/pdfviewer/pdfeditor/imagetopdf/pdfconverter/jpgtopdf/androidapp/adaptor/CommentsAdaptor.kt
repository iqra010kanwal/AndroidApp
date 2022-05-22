package com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.adaptor
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.R
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.model.Comments
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.model.Posts
import java.util.ArrayList

class CommentsAdaptor(var commentarray: ArrayList<Comments?>) :
    RecyclerView.Adapter<CommentsAdaptor.Commentsitem>() {
    inner class Commentsitem(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.name)
        var body: TextView = view.findViewById(R.id.body)
        var email: TextView = view.findViewById(R.id.email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Commentsitem {
        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.comment_layout, parent, false)

        return Commentsitem(view)
    }

    override fun onBindViewHolder(holder: Commentsitem, position: Int) {
        holder.title.text = commentarray.get(position)?.name
        holder.body.text = commentarray.get(position)?.body
        holder.email.text = commentarray.get(position)?.email
      /*  holder.body.setOnClickListener {
            callbackListener.onClick(position)
        }*/
    }

    override fun getItemCount(): Int {
        return commentarray.size
    }

    fun filterList(filteredlist: ArrayList<Comments?>) {
        commentarray = filteredlist
        notifyDataSetChanged()
    }


    /*   fun filterList(filterllist: ArrayList<Commentsitem?>) {
           commentarray = filterllist
           notifyDataSetChanged()
       }
   */
  /*  public fun deleteDone(position: Int) {
        array.removeAt(position)
    }*/
}