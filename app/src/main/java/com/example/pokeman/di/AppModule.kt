package com.example.pokeman.di

import com.example.pokeman.data.remote.PokeApi
import com.example.pokeman.repository.pokemonRepository
import com.example.pokeman.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
     @Singleton
     @Provides
    fun providePokemonRepository(
     api: PokeApi
    ) = pokemonRepository(api)
    @Singleton
    @Provides
    fun providePokeApi() : PokeApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApi ::class.java)
    }

}