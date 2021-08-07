package com.capiter.base.ui.main.product

import android.util.Log
import androidx.lifecycle.ViewModel
import com.capiter.base.data.model.OrderItem
import com.capiter.base.data.model.ProductItem
import com.capiter.base.data.repo.UserRepo
import io.reactivex.rxjava3.schedulers.Schedulers

class ProductActivityViewModel(private var userRepo: UserRepo) : ViewModel() {

    fun getProducts() = userRepo.getProducts()

    fun sendOrders(orderList: List<OrderItem>) = userRepo.sendOrders(orderList = orderList)

    fun getCartItems() = userRepo.getCartProduct()

    fun getCartItem(itemID: String) = userRepo.getCartItem(itemID)


    fun updateCart(item: ProductItem) =
        userRepo.insertNewProduct(item).subscribeOn(Schedulers.io()).subscribe({
            Log.i("cap", "insert: ")
        }, {
            Log.i("cap", "Error: " + it.message)
        })


    fun removeItemFromCart(itemID: String) {
        userRepo.removeItemFromCart(itemID).subscribeOn(Schedulers.io()).subscribe({
            Log.i("cap", "removed: ")
        }, {
            Log.i("cap", "Error: " + it.message)
        })
    }

    fun deleteOrders() = userRepo.deleteOrders()

}