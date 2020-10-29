package com.example.test.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.model.Book
import com.example.test.network.BooksRepository
import com.example.test.utils.Coroutines
import kotlinx.coroutines.Job

class BooksViewModel(private val repository: BooksRepository) : ViewModel() {

    private lateinit var job: Job //Courotines job to call scope

    private val booksMutable =
        MutableLiveData<List<Book>>() //subclass of LiveData that can notify easily the ui

    val books: LiveData<List<Book>> // LiveData is a holder of the data class and help us to use the data and is bound to a lyfecycle
        get() = booksMutable

    fun getBooks() {
        job = Coroutines.ioThenMain(
            {
                repository.getBooks()
            }, {

                booksMutable.value = it?.items
            })
    }

    override fun onCleared() {
        super.onCleared()

        if(::job.isInitialized) job.cancel()
    }

}