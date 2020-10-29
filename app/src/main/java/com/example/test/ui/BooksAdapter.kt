package com.example.test.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.databinding.ItemBookBinding
import com.example.test.model.Book

class BooksAdapter(private val books: List<Book>) :
    RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BooksViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_book, parent, false
            )
        )

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val context = holder.bookBindig.btnReadBook.context
        var showLines = false
        holder.bookBindig.book = books[position]
        holder.bookBindig.btnReadBook.setOnClickListener {
            if(showLines){
                holder.bookBindig.btnReadBook.text = context.getText(R.string.read_more)
                holder.bookBindig.tvDescriptionBook.maxLines = 3
                showLines = false
            }else{
                holder.bookBindig.btnReadBook.text = context.getText(R.string.read_less)
                holder.bookBindig.tvDescriptionBook.maxLines = 10
                showLines = true
            }
        }
    }

    override fun getItemCount() = books.size

    inner class BooksViewHolder(
       val bookBindig: ItemBookBinding // a class of Kotlin is created to use data binding in our item and adapter
    ) : RecyclerView.ViewHolder(bookBindig.root)

}