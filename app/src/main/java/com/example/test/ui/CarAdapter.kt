package com.example.test.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R

class CarAdapter(val items: List<String>) : RecyclerView.Adapter<CarAdapter.ViewHolderCar>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCar {
        var car = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_car, parent, false) as TextView

        return ViewHolderCar(car)
    }

    override fun onBindViewHolder(holder: ViewHolderCar, position: Int) {
        holder.car.text = items[position]
    }

    override fun getItemCount(): Int = items.size

    class ViewHolderCar(val car: TextView) : RecyclerView.ViewHolder(car)

}