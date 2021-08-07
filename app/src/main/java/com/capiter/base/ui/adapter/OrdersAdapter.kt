package com.capiter.base.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capiter.base.data.model.OrderItem
import com.capiter.base.databinding.ItemOrderBinding
import javax.inject.Inject


class OrdersAdapter @Inject constructor() : RecyclerView.Adapter<OrdersAdapter.ViewHolder>() {
    var list: List<OrderItem?>? = null
    var listener: CartAdapter.CartListener? = null

    fun addData(list: List<OrderItem?>?) {
        this.list = list
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemOrderBinding =
            ItemOrderBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = list?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list?.get(position))

    inner class ViewHolder(var binding: ItemOrderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: OrderItem?) {
            binding.mProductItem = item
            //binding.executePendingBindings()
        }
    }


}