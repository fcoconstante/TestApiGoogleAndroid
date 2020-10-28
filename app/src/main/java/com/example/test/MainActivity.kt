package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data = listOf("Honda", "BMW", "Chrevrolet", "Ferrari")

    private lateinit var carAdapter: CarAdapter
    private lateinit var layoutCar: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carAdapter= CarAdapter(data)

        layoutCar = LinearLayoutManager(this)
        rv_car.layoutManager = layoutCar
        rv_car.adapter = carAdapter

    }
}