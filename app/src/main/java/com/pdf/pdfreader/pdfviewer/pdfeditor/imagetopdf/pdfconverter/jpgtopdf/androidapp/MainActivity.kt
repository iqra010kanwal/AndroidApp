package com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.adaptor.PostAdaptor
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.dialogs.CommentsDialog
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.interfaces.CallbackListener
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.model.Comments
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.model.Posts
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class MainActivity : AppCompatActivity(), CallbackListener {
    private var postAdaptor: PostAdaptor? = null
    private var linearLayoutManager: LinearLayoutManager? = null
    private val mainViewModel: MainViewModel by viewModel()
    private var toolbar: Toolbar? = null
    private var post = arrayListOf<Posts>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        toolbar?.title = "Posts"
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        mainViewModel.getPostList(::getList)
        searchView.setOnQueryTextListener(object : OnQueryTextListener,
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
        /*   searchView.setOnQueryTextListener(object : OnQueryTextListener() {
          override  fun onQueryTextSubmit(query: String?): Boolean {
                if (list.contains(query)) {
                    adapter.getFilter().filter(query)
                } else {
                    Toast.makeText(this@MainActivity, "No Match found", Toast.LENGTH_LONG).show()
                }
                return false
            }

          override  fun onQueryTextChange(newText: String?): Boolean {
                //    adapter.getFilter().filter(newText);
                return false
            }
        })*/
        /*  searchView.(object :
              TextWatcher {
              override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
              }

              override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {


              }

              override fun afterTextChanged(s: Editable) {

                  try {
                      filter(s.toString())

                  } catch (e: Exception) {

                  }

              }

              //hideKeyboard(this@MainActivity)
          })
  */
    }

    fun getList(list: Array<Posts?>) {

        for (i in list) {


            post.add(i!!)
        }

        postAdaptor = list?.toCollection(ArrayList())?.let { PostAdaptor(it, this) }
        recycalrview.layoutManager = LinearLayoutManager(this)
        recycalrview.adapter = postAdaptor
        recycalrview.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayout.VERTICAL
            )
        )
        progress.visibility = View.GONE
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClick(pos: Int) {
        mainViewModel.getComments(::listComment, pos)
    }

    fun listComment(list: Array<Comments?>) {
        Toast.makeText(this,"${list.size}",Toast.LENGTH_SHORT).show()
        val fm: FragmentManager = supportFragmentManager
        val editNameDialogFragment: CommentsDialog =
            list?.toCollection(ArrayList())?.let { CommentsDialog(this, it) }
        editNameDialogFragment.show(fm, "about")
       /* Toast.makeText(this, "${list.size}", Toast.LENGTH_SHORT).show()
        for (list in list) {
            Toast.makeText(this, "${list?.body}", Toast.LENGTH_SHORT).show()





        }*/





    }

    private fun filter(text: String) {
        // creating a new array list to filter our data.
        val filteredlist: ArrayList<Posts?> = ArrayList()

        // running a for loop to compare elements.
        for (item in post) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.title.toLowerCase().contains(text.toLowerCase())) {
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
            postAdaptor!!.filterList(filteredlist)
        }
    }


    private fun showBottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog)
        val comments = bottomSheetDialog.findViewById<LinearLayout>(R.id.comments)

        bottomSheetDialog.show()
    }
}