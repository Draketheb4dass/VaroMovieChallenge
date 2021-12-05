package com.jephtecolin.varomoviechallenge.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.jephtecolin.varomoviechallenge.data.model.Movie
import com.jephtecolin.varomoviechallenge.databinding.FragmentMovieDetailBinding
import dagger.hilt.android.AndroidEntryPoint


/**
 * [MovieDetailFragment] displays a movie detail.
 *
 */

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {
    private val args: MovieDetailFragmentArgs by navArgs()
    private lateinit var movieData: Movie
    private lateinit var binding: FragmentMovieDetailBinding
    private val viewModel: MovieDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieData = args.movie
        binding.movie = movieData

        viewModel.isFavorite(movieData.id)
    }
}