package com.jephtecolin.varomoviechallenge.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.jephtecolin.varomoviechallenge.data.remote.MovieDataSource
import com.jephtecolin.varomoviechallenge.data.model.MoviesResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieDataSource: MovieDataSource
) : ViewModel(){
    var nowPlayingMovies: LiveData<MoviesResponseModel?> =  movieDataSource.getNowPlayingMovies().asLiveData()
}