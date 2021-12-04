package com.jephtecolin.varomoviechallenge.data.model

import com.google.gson.annotations.SerializedName

data class MoviesResponseModel(
    val page: Int,
    val results: List<Movie>,
    @SerializedName("total_results")
    val totalResult: Int,
    @SerializedName("total_pages")
    val totalPage: Int
)
