package com.capiter.base.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capiter.base.data.model.OrderItem
import com.capiter.base.databinding.ItemMainOrdersBinding
import javax.inject.Inject


class MainOrdersAdapter @Inject constructor() :
    RecyclerView.Adapter<MainOrdersAdapter.ViewHolder>() {
    private var orderMap: Map<String?, List<OrderItem>>? = null
    private var mKeys: Array<String?>? = null

//    @Inject
//    lateinit var mAdapter : OrdersAdapter
    var listener: CartAdapter.CartListener? = null

    fun addData(orderMap: Map<String?, List<OrderItem>>?, keys: Array<String?>?) {
        this.orderMap = orderMap
        this.mKeys = keys
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemMainOrdersBinding =
            ItemMainOrdersBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }



    override fun getItemCount() = orderMap?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(orderMap?.get(mKeys?.get(position)), mKeys?.get(position))

    inner class ViewHolder(var binding: ItemMainOrdersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(orderList: List<OrderItem>?, orderName: String?) {
            binding.orderNameTV.text = orderName
            var mAdapter = OrdersAdapter()
            binding.mOrdersRV.adapter = mAdapter
            mAdapter.addData(orderList)

        }
    }

}