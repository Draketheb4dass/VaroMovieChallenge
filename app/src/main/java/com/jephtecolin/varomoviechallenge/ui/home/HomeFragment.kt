package com.jephtecolin.varomoviechallenge.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyItemSpacingDecorator
import com.airbnb.epoxy.EpoxyRecyclerView
import com.jephtecolin.varomoviechallenge.ItemMovieBindingModel_
import com.jephtecolin.varomoviechallenge.R
import com.jephtecolin.varomoviechallenge.data.MovieDataSource
import com.jephtecolin.varomoviechallenge.data.model.Movie
import com.jephtecolin.varomoviechallenge.itemMovie
import com.jephtecolin.varomoviechallenge.ui.detail.MovieDetailFragment
import dagger.hilt.android.AndroidEntryPoint


/**
 * A simple [Fragment] subclass.
 *
 */
@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var controller: EpoxyController
    private val nowPlayingMovies = mutableListOf<Movie>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvMovie : EpoxyRecyclerView = view.findViewById(R.id.rvMovie)

        viewModel.nowPlayingMovies.observe(viewLifecycleOwner) {
            nowPlayingMovies.clear()
            if (it != null) {
                nowPlayingMovies.addAll(it.results)
            }
            controller.requestModelBuild()
        }

        rvMovie.addItemDecoration(EpoxyItemSpacingDecorator(20))


        rvMovie.withModels {
            controller = this
            if (nowPlayingMovies.isNotEmpty()) {
                nowPlayingMovies.forEachIndexed { index, movie ->
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