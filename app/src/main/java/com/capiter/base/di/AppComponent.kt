package com.capiter.base.di

import com.capiter.base.ui.main.MainActivity
import dagger.Component

@Component(
    modules = [
        NetworkModule::class,
        StorageModule::class,
        ViewModelFactoryModule::class]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)

}