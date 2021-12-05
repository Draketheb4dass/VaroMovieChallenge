package com.jephtecolin.varomoviechallenge.ui.detail

import androidx.lifecycle.*
import com.jephtecolin.varomoviechallenge.data.local.MovieDao
import com.jephtecolin.varomoviechallenge.data.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDao: MovieDao
): ViewModel(){
    fun addToFavorite(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            movieDao.insertFavorite(movie)
        }
    }

    lateinit var isMovieFavorite: LiveData<Boolean>

    fun isFavorite(movieId: String) {
        isMovieFavorite = movieDao.isFavorite(movieId).asLiveData()
    }
}