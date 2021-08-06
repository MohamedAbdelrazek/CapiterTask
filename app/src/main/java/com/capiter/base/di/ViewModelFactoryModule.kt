package com.capiter.base.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.capiter.base.data.repo.UserRepo
import com.capiter.base.ui.main.MainActivityViewModel
import com.capiter.base.utils.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module
class ViewModelFactoryModule {

    @Named(Constants.ViewModelNamedMainActivity)
    @Provides
    fun provideMainActivityViewModelFactory(userRepo: UserRepo): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainActivityViewModel(userRepo) as T
            }
        }
    }



}
