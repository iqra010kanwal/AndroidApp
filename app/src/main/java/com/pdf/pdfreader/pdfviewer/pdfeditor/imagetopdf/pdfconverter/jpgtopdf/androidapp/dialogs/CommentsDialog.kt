package com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.dialogs

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.R
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.adaptor.CommentsAdaptor
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.model.Comments
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.model.Posts
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet_dialog.*
import kotlinx.android.synthetic.main.bottom_sheet_dialog.searchView
import java.util.ArrayList

class CommentsDialog(context: Context, var commentsArray: ArrayList<Comments?>) : DialogFragment() {

var commentsAdaptor:CommentsAdaptor?= null
    var linearLayoutManager:LinearLayoutManager?=null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.round_corners)
        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        var viewRateUsDialog = inflater.inflate(R.layout.bottom_sheet_dialog, container, false)
        return viewRateUsDialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("sldjs", "${commentsArray.size}")
        commentsAdaptor= CommentsAdaptor(commentsArray)
        linearLayoutManager= LinearLayoutManager(context)
        comments.layoutManager=linearLayoutManager
        comments.adapter= commentsAdaptor
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                try {
                    filter(query.toString())

                } catch (e: Exception) {

                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                try {
                    filter(newText.toString())

                } catch (e: Exception) {

                }
                return true
            }


        })

    }
    override fun onResume() {
        super.onResume()
        val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.setLayout(width, height)
    }
    private fun filter(text: String) {
        // creating a new array list to filter our data.
        val filteredlist: ArrayList<Comments?> = ArrayList()

        // running a for loop to compare elements.
        for (item in commentsArray) {
            // checking if the entered string matched with any item of our recycler view.
            if (item?.name?.toLowerCase()?.contains(text.toLowerCase()) == true) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            //Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            commentsAdaptor!!.filterList(filteredlist)
        }
    }
}