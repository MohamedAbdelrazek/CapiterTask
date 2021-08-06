package com.capiter.base.di

import android.app.Application
import com.capiter.base.data.network.ApiClient
import com.capiter.base.utils.Constants
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule(var application: Application) {
    @Provides
    fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor(application))
            .build()


    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.STORE_BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    fun providesApiClient(retrofit: Retrofit): ApiClient {
        return retrofit.create(ApiClient::class.java)
    }
}