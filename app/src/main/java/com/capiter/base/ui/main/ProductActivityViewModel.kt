package com.capiter.base.ui.main

import androidx.lifecycle.ViewModel
import com.capiter.base.data.model.ProductItem
import com.capiter.base.data.repo.UserRepo

class ProductActivityViewModel(private var userRepo: UserRepo) : ViewModel() {

    fun getProducts() = userRepo.getProducts()
    fun updateCart(item: ProductItem) = userRepo.insertNewProduct(item)
}