package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.persistence.typeconverters.CountryVOListTypeConverter
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.persistence.typeconverters.GenreListTypeConverter
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.persistence.typeconverters.GenresVOListTypeConverter

@Entity(tableName = "movies")
@TypeConverters(GenreListTypeConverter::class,GenresVOListTypeConverter::class,CountryVOListTypeConverter::class)
data class MovieVO(
    @PrimaryKey
    @SerializedName("id") var id: Int = 0,
    @SerializedName("popularity") var popularity: Float = 0f,
    @SerializedName("vote_count") var voteCount : Int = 0,
    @SerializedName("video") var video : Boolean = false,
    @SerializedName("poster_path") var posterPath : String = "",
    @SerializedName("adult") var adult : Boolean = false,
    @SerializedName("backdrop_path") var backdropPath : String? = "",
    @SerializedName("original_language") var originalLanguage : String = "",
    @SerializedName("original_title") var originalTitle : String = "",
    @SerializedName("genre_ids") var genreIds : ArrayList<Int> = arrayListOf(),
    @SerializedName("title") var title : String = "",
    @SerializedName("vote_average") var voteAverage : Float = 0f,
    @SerializedName("overview") var overview : String = "",
    @SerializedName("release_date") var releaseDate : String = "",
    @SerializedName("runtime") var runtime : Int? = 0,
    @SerializedName("genres") var genres : ArrayList<GenresVO>? = arrayListOf(),
    @SerializedName("production_countries") var productionCountries : ArrayList<CountryVO>? = arrayListOf(),
    @SerializedName("is_popular") var isPopular : Int = 0,
    @SerializedName("is_upcoming") var isUpcoming : Int = 0,
    @SerializedName("is_now_playing") var isNowPlaying : Int = 0,
    @SerializedName("is_genres") var isGenres : Int = 0
)