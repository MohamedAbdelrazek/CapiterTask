package com.capiter.base.ui.main.order

import androidx.lifecycle.ViewModel
import com.capiter.base.data.repo.UserRepo

class OrderViewModel(private var userRepo: UserRepo) : ViewModel() {

    fun getOrders() = userRepo.getOrders()

}