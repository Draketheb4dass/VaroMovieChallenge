package com.jephtecolin.varomoviechallenge.data.remote

import com.jephtecolin.varomoviechallenge.data.remote.response.MoviesResponseModel
import retrofit2.Response
import retrofit2.http.GET


interface TMDBService {
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies() : Response<MoviesResponseModel>
}