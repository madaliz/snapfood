package com.example.snapfoodtask.di

import com.example.snapfoodtask.network.RetrofiClient
import com.example.snapfoodtask.network.SWAPIService
import com.example.snapfoodtask.repository.SWAPIRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return RetrofiClient.retrofit
    }
    @Provides
    fun provideSWAPIService(retrofit: Retrofit):SWAPIService{
        return  retrofit.create(SWAPIService::class.java)
    }

    @Provides
    fun provideSWAPIRepository(swapiService: SWAPIService):SWAPIRepository {
        return SWAPIRepository(swapiService)
    }

}