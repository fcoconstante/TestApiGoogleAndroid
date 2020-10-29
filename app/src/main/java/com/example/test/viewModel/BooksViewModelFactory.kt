package com.example.test.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.test.network.BooksRepository

class BooksViewModelFactory (private  val repository: BooksRepository) :ViewModelProvider.NewInstanceFactory(){

    //View model Factory is responsable to create the instances of the repository in order to use it in fragment or activity

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BooksViewModel(repository) as T
    }

}