package com.capiter.base.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.capiter.base.data.repo.UserRepo
import com.capiter.base.ui.main.ProductActivityViewModel
import com.capiter.base.utils.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module
class ViewModelFactoryModule {

    @Named(Constants.ViewModelNamedProductActivity)
    @Provides
    fun provideProductActivityViewModelFactory(userRepo: UserRepo): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ProductActivityViewModel(userRepo) as T
            }
        }
    }
}
