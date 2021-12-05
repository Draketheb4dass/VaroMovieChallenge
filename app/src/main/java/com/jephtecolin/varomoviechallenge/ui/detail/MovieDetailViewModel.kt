package com.jephtecolin.varomoviechallenge.ui.detail

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
}