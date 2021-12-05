package com.jephtecolin.varomoviechallenge.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jephtecolin.varomoviechallenge.data.model.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM favorite_table")
    fun getFavoriteMovies(): Flow<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(movie: Movie): Long

    @Query("DELETE FROM favorite_table WHERE :movieId = id")
    suspend fun removeFavorite(movieId: String)

}