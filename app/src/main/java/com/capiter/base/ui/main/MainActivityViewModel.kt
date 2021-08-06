package com.capiter.base.ui.main

import androidx.lifecycle.ViewModel
import com.capiter.base.data.model.UserRecord
import com.capiter.base.data.repo.UserRepo
import io.reactivex.rxjava3.core.Flowable

class MainActivityViewModel(private var userRepo: UserRepo) : ViewModel() {

    fun getAllCities(): Flowable<UserRecord> = userRepo.getAllCities()
}