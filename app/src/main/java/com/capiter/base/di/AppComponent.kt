package com.capiter.base.di

import com.capiter.base.ui.main.ProductActivity
import dagger.Component

@Component(
    modules = [
        NetworkModule::class,
        StorageModule::class,
        ViewModelFactoryModule::class]
)
interface AppComponent {
    fun inject(productActivity: ProductActivity)

}