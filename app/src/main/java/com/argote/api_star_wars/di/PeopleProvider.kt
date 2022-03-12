package com.argote.api_star_wars.di

import com.argote.api_star_wars.data.PeopleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PeopleProvider {

    @Singleton
    @Provides
    fun providePeopleRepository() = PeopleRepository(ClientModule.provideClient())

}