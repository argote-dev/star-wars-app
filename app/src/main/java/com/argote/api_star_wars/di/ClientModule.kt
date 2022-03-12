package com.argote.api_star_wars.di

import com.argote.api_star_wars.core.Constants
import com.argote.api_star_wars.data.remote.PeopleService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ClientModule {

    @Singleton
    @Provides
    fun provideClient() : PeopleService = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().create()
            )
        )
        .build().create(PeopleService::class.java)

}