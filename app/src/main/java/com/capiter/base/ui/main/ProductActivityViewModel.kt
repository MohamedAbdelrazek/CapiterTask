package com.capiter.base.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.capiter.base.data.model.ProductItem
import com.capiter.base.data.repo.UserRepo
import io.reactivex.rxjava3.schedulers.Schedulers

class ProductActivityViewModel(private var userRepo: UserRepo) : ViewModel() {

    fun getProducts() = userRepo.getProducts()
    fun updateCart(item: ProductItem) =
        userRepo.insertNewProduct(item).subscribeOn(Schedulers.io()).subscribe({
            Log.i("cap", "insert: ")
        }, {
            Log.i("cap", "Error: " + it.message)
        })

    fun getCartItems() = userRepo.getCartProduct()


    fun removeItemFromCart(itemID: String) {
        userRepo.removeItemFromCart(itemID).subscribeOn(Schedulers.io()).subscribe({
            Log.i("cap", "removed: ")
        }, {
            Log.i("cap", "Error: " + it.message)
        })
    }


    fun getCartItem(itemID: String) = userRepo.getCartItem(itemID)
}