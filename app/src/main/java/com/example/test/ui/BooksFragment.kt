package com.example.test.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.network.BooksRepository
import com.example.test.viewModel.BooksViewModel
import com.example.test.viewModel.BooksViewModelFactory
import com.example.test.R
import com.example.test.network.BooksApi
import kotlinx.android.synthetic.main.books_fragment.*

class BooksFragment : Fragment() {


    private lateinit var factory: BooksViewModelFactory
    private lateinit var viewModel: BooksViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.books_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = BooksApi()
        val repository = BooksRepository(api)
        factory = BooksViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(BooksViewModel::class.java)


        viewModel.getBooks()
        viewModel.books.observe(viewLifecycleOwner, Observer { books ->
            println("/() Books  $books")
            rv_books.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = BooksAdapter(books)
            }
        })

    }

}