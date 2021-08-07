package com.capiter.base.di

import com.capiter.base.ui.main.product.CartActivity
import com.capiter.base.ui.main.OrdersActivity
import com.capiter.base.ui.main.product.ProductActivity
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
    fun inject(ordersActivity: OrdersActivity)

}