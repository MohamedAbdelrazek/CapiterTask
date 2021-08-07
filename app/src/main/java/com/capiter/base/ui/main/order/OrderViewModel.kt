package com.capiter.base.ui.main

import androidx.lifecycle.ViewModel
import com.capiter.base.data.repo.UserRepo

class OrderViewModel(private var userRepo: UserRepo) : ViewModel() {

    fun getOrders() = userRepo.getOrders()

}