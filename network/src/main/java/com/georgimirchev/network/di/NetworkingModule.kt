package com.georgimirchev.network.di

import com.georgimirchev.network.adapters.AlwaysSerializeNullsFactory
import com.georgimirchev.network.adapters.DateTimeMoshiAdapter
import com.georgimirchev.network.api.UiApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


fun provideNetworkingModule() = module {
    single {
        Moshi.Builder()
            .add(DateTimeMoshiAdapter)
            .add(AlwaysSerializeNullsFactory)
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://middleware-preprod.p7s1.io/p7s1/v1/")
            .addConverterFactory(MoshiConverterFactory.create(get<Moshi>()))
            .build()
    }

    single {
        get<Retrofit>()
            .newBuilder()
        .build()
        .create(UiApi::class.java)
    }
}
