package com.jephtecolin.varomoviechallenge.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyItemSpacingDecorator
import com.airbnb.epoxy.EpoxyRecyclerView
import com.jephtecolin.varomoviechallenge.R
import com.jephtecolin.varomoviechallenge.data.model.Movie
import com.jephtecolin.varomoviechallenge.itemMovie
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 *
 *
 */

@AndroidEntryPoint
class FavoriteFragment : Fragment() {
    private lateinit var controller: EpoxyController
    private val viewModel: FavoriteViewModel by viewModels()
    private val _favoriteMovies = mutableListOf<Movie>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvFavorite: EpoxyRecyclerView = view.findViewById(R.id.rvFavorite)
        rvFavorite.addItemDecoration(EpoxyItemSpacingDecorator(20))

        viewModel.favoriteMovies.observe(viewLifecycleOwner) { favoriteMovies ->
            _favoriteMovies.addAll(favoriteMovies)
            controller.requestModelBuild()
        }

        rvFavorite.withModels {
            controller = this
            if (_favoriteMovies.isNotEmpty()) {
                _favoriteMovies.forEachIndexed { index, movie ->
                    itemMovie {
                        id(index)
                        movie(movie)
                    }
                }

            }
        }
    }
}