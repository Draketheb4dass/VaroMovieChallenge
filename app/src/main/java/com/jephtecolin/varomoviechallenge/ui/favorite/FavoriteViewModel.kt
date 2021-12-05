package com.jephtecolin.varomoviechallenge.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.jephtecolin.varomoviechallenge.data.local.MovieDao
import com.jephtecolin.varomoviechallenge.data.model.Movie
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val movieDao: MovieDao
) : ViewModel() {
    var favoriteMovies: LiveData<List<Movie>> = movieDao.getFavoriteMovies().asLiveData()
}