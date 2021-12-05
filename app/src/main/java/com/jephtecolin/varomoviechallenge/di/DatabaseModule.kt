package com.jephtecolin.varomoviechallenge.di

import android.content.Context
import com.jephtecolin.varomoviechallenge.data.local.MovieDao
import com.jephtecolin.varomoviechallenge.data.local.VaroMovieRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): VaroMovieRoomDatabase {
        return VaroMovieRoomDatabase.getDatabase(context)
    }

    @Provides
    fun provideMovieDao(varoMovieRoomDatabase: VaroMovieRoomDatabase): MovieDao {
        return varoMovieRoomDatabase. movieDao()
    }
}