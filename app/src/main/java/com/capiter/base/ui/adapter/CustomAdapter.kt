package com.capiter.base.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capiter.base.R

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.single_item, parent, false)
        )
    }

    override fun getItemCount() = 120000
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {}
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}