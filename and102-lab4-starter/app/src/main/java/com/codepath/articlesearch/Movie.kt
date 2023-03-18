package com.codepath.articlesearch
import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Keep
@Serializable
data class BaseResponse(
    @SerialName("results")
    val movies: List<Movie>?
):java.io.Serializable
@Keep
@Serializable
data class Movie(
    @SerialName("overview")
    val overview: String?,
    @SerialName("original_title")
    val original_title: String?,
    @SerialName("poster_path")
    val poster_path: String?,
    @SerialName("release_date")
    val date:String?,
    @SerialName("original_language")
    val lang:String?,
    @SerialName("popularity")
    val pop :String?
):java.io.Serializable