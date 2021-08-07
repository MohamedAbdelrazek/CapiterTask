package com.capiter.base.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capiter.base.data.model.ProductItem
import com.capiter.base.databinding.ItemCartBinding
import com.capiter.base.utils.click
import javax.inject.Inject


class CartAdapter @Inject constructor() : RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    var list: List<ProductItem?>? = null
    var listener: CartListener? = null
    fun addData(list: List<ProductItem?>?) {
        this.list = list
        notifyDataSetChanged()
    }

    fun attachListener(listener: CartListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemCartBinding =
            ItemCartBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = list?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list?.get(position))

    inner class ViewHolder(var binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductItem?) {
            binding.deleteIV.click  {
                item?.let {
                    listener?.removeItemFromCart(it.id)
                }
                notifyItemChanged(adapterPosition,item)
            }
            binding.mProductItem = item
            binding.executePendingBindings()
        }
    }

    interface CartListener {
        fun removeItemFromCart(itemID: String)
    }
}