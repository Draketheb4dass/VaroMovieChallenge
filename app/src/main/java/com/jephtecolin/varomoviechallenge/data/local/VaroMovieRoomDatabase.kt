package com.jephtecolin.varomoviechallenge.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jephtecolin.varomoviechallenge.data.model.Movie


@Database(entities = [Movie::class], version = 1, exportSchema = false)
public abstract class VaroMovieRoomDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile
        private var INSTANCE: VaroMovieRoomDatabase? = null

        fun getDatabase(context: Context): VaroMovieRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VaroMovieRoomDatabase::class.java,
                    "varo_movie_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}