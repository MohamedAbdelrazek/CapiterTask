package com.capiter.base.di

import com.capiter.base.ui.main.CartActivity
import com.capiter.base.ui.main.ProductActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        NetworkModule::class,
        StorageModule::class,
        ViewModelFactoryModule::class]
)
interface AppComponent {
    fun inject(productActivity: ProductActivity)
    fun inject(productActivity: CartActivity)

}