package com.georgimirchev.network.di

import com.georgimirchev.network.BuildConfig
import com.georgimirchev.network.adapters.AlwaysSerializeNullsFactory
import com.georgimirchev.network.adapters.DateTimeMoshiAdapter
import com.georgimirchev.network.api.UiApi
import com.georgimirchev.network.api.VideoApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
        val httpLoggingInterceptor = get<HttpLoggingInterceptor>()
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    factory {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
    }

    single {
        val okHttpClient = get<OkHttpClient>()
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://middleware-preprod.p7s1.io/p7s1/v1/")
            .addConverterFactory(MoshiConverterFactory.create(get<Moshi>()))
            .build()
    }

    single {
        get<Retrofit>().newBuilder()
        .build()
        .create(UiApi::class.java)
    }

    single {
        get<Retrofit>().newBuilder()
            .build()
            .create(VideoApi::class.java)
    }
}
