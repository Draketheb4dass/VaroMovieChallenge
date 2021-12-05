package com.jephtecolin.varomoviechallenge.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyItemSpacingDecorator
import com.airbnb.epoxy.EpoxyRecyclerView
import com.jephtecolin.varomoviechallenge.R
import com.jephtecolin.varomoviechallenge.data.model.Movie
import com.jephtecolin.varomoviechallenge.databinding.FragmentHomeBinding
import com.jephtecolin.varomoviechallenge.itemMovie
import dagger.hilt.android.AndroidEntryPoint


/**
 *  [HomeFragment] to display Now Playing movies from the TMDB API.
 *
 */
@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var controller: EpoxyController
    private val _nowPlayingMovies = mutableListOf<Movie>()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvMovie: EpoxyRecyclerView = view.findViewById(R.id.rvMovie)

        viewModel.nowPlayingMovies.observe(viewLifecycleOwner) { nowPlayingMovies ->
            _nowPlayingMovies.clear()
            if (nowPlayingMovies != null) {
                _nowPlayingMovies.addAll(nowPlayingMovies.results)
            }
            controller.requestModelBuild()
        }

        rvMovie.addItemDecoration(EpoxyItemSpacingDecorator(20))


        rvMovie.withModels {
            controller = this
            if (_nowPlayingMovies.isNotEmpty()) {
                _nowPlayingMovies.forEachIndexed { index, movie ->
                    itemMovie {
                        id(index)
                        movie(movie)
                        onMovieClick { _ ->
                            view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(movie))
                        }
                    }

                }
            }

        }

    }
}