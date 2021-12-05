package com.jephtecolin.varomoviechallenge.data.remote

import com.jephtecolin.varomoviechallenge.data.model.MoviesResponseModel
import com.jephtecolin.varomoviechallenge.data.remote.TMDBService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class MovieDataSource @Inject constructor(private val tmdbService: TMDBService) {
    fun getNowPlayingMovies(): Flow<MoviesResponseModel?> = flow {
        val result = tmdbService.getNowPlayingMovies()
        if(result.isSuccessful) {
            emit(result.body())
        } else {
            Timber.d("Error fetching now playing movies: %s", result.errorBody())
        }
    }
}