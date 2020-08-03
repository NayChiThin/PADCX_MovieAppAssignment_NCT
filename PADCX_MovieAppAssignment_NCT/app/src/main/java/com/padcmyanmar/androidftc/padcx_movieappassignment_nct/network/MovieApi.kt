package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.network

import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.MovieVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.VideoDetailVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.network.responses.*
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.utils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET(GET_POPULAR_MOVIES)
    fun getPopularMovieList(@Query(PARAM_API_KEY) apiKey:String) : Observable<GetAllMoviesResponses>

    @GET(GET_GENRES)
    fun getGenres(@Query(PARAM_API_KEY) apiKey: String) : Observable<GetGenresResponses>

    @GET(GET_PERSON)
    fun getPersonList(@Query(PARAM_API_KEY) apiKey: String) : Observable<GetAllPersonResponses>

    @GET("$GET_MOVIE_DETAILS/{MOVIE_ID}")
    fun getMovieDetail(@Path("MOVIE_ID") movieId:Int,@Query(PARAM_API_KEY) apiKey: String) : Observable<MovieVO>

    @GET(GET_NOW_PLAYING_MOVIES)
    fun getNowPlayingMovieList(@Query(PARAM_API_KEY) apiKey: String): Observable<GetAllMoviesResponses>

    @GET("$GET_MOVIES/{GENRE_ID}")
    fun getMoviesByGenre(@Path("GENRE_ID") genre : Int,@Query(PARAM_API_KEY) apiKey: String) : Observable<GetAllMoviesResponses>

    @GET(GET_UPCOMING_MOVIES)
    fun getUpcomingMovies(@Query(PARAM_API_KEY) apiKey: String) : Observable<GetAllMoviesResponses>

    @GET("$GET_MOVIE_DETAILS/{MOVIE_ID}/$GET_VIDEOS")
    fun getMovieVideoById(@Path("MOVIE_ID")movieId: Int,@Query(PARAM_API_KEY)apiKey: String) : Observable<VideoDetailVO>
}