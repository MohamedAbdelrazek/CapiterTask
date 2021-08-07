package com.capiter.base.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.capiter.base.data.repo.UserRepo
import com.capiter.base.ui.main.OrderViewModel
import com.capiter.base.ui.main.product.ProductActivityViewModel
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

    @Named(Constants.ViewModelNamedOrderActivity)
    @Provides
    fun provideOrderActivityViewModelFactory(userRepo: UserRepo): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return OrderViewModel(userRepo) as T
            }
        }
    }




}
