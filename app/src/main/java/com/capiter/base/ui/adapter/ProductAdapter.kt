package com.capiter.base.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capiter.base.data.model.ProductItem
import com.capiter.base.databinding.ItemProductBinding
import javax.inject.Inject


class ProductAdapter @Inject constructor() : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    var list: ArrayList<ProductItem>? = null

    fun addData(list: ArrayList<ProductItem>?) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemProductBinding =
            ItemProductBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = list?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list?.get(position))

    class ViewHolder(var binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductItem?) {
            binding.mProductItem = item
            binding.executePendingBindings()
        }
    }
}