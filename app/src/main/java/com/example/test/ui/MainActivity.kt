package com.example.test.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.network.BooksRepository
import com.example.test.R
import com.example.test.network.BooksApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val data = listOf("Honda", "BMW", "Chrevrolet", "Ferrari")

    private lateinit var carAdapter: CarAdapter
    private lateinit var layoutCar: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*carAdapter = CarAdapter(data)

        layoutCar = LinearLayoutManager(this)
        rv_car.layoutManager = layoutCar
        rv_car.adapter = carAdapter*/


        val repository = BooksRepository(BooksApi())

    }
}