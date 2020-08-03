package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.R
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.adapters.GenreListAdapter
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.adapters.PersonListAdapter
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.MovieVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.PersonVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.presenters.DetailPresenter
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.presenters.DetailPresenterImpl
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.views.DetailView
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.utils.MOVIE_ID_EXTRA
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : DetailView,BaseActivity() {
    private lateinit var mActorListAdapter : PersonListAdapter
    private lateinit var mCreatorListAdapter: PersonListAdapter
    private lateinit var mGenresListAdapter : GenreListAdapter
    private lateinit var mDetailPresenter : DetailPresenter
    private var movieId : Int = 0
    private var genres : String = ""
    private var countries : String = ""

    companion object {
        fun newIntent(context: Context,movieId:Int) : Intent{
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra(MOVIE_ID_EXTRA,movieId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        movieId = intent.getIntExtra(MOVIE_ID_EXTRA,0)

        setUpPresenter()
        setUpRecyclerView()

        mDetailPresenter.onUiReady(this,movieId)

        ivBack.setOnClickListener {
            mDetailPresenter.onTapBack()
        }
    }
    private fun setUpPresenter() {
        mDetailPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mDetailPresenter.initPresenter(this)
    }
    private fun setUpRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        val linearLayoutManager2 = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        val linearLayoutManager3 = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        mActorListAdapter = PersonListAdapter(mDetailPresenter)
        rvActors.adapter = mActorListAdapter
        rvActors.layoutManager = linearLayoutManager

        mCreatorListAdapter = PersonListAdapter(mDetailPresenter)
        rvCreators.adapter = mCreatorListAdapter
        rvCreators.layoutManager = linearLayoutManager2

        // type list
        mGenresListAdapter = GenreListAdapter()
        rvType.adapter = mGenresListAdapter
        rvType.layoutManager = linearLayoutManager3

    }
    private fun bindData(movie:MovieVO) {
        tvRatingAverage.text = movie.voteAverage.toString()
        ratingBar.rating = movie.voteAverage
        tvYear.text = movie.releaseDate.subSequence(0,4).toString()
        tvTitle.text = movie.title
        tvVotes.text = movie.voteCount.toString() + " VOTES"

        val movieTime = movie.runtime?.toFloat()
        val hour : Int? = movieTime?.div(60)?.toInt()
        val movieMinute : Int? = movieTime?.rem(60)?.toInt()
        tvTime.text = hour.toString() + "h " + movieMinute.toString()+"min"

        tvStoryLine.text = movie.overview
        tvOriginalTitles.text = movie.originalTitle

        for (i in 0 until (movie.genres?.size ?: 0))
            movie.genres?.get(i)?.name?.let {
                when(i) {
                    0 -> genres = genres.plus(it)
                    else -> genres = genres.plus(", ").plus(it)
                }
            }
        for(i in 0 until (movie.productionCountries?.size ?: 0))
            movie.productionCountries?.get(i)?.name.let {
                when(i) {
                    0 -> countries = countries.plus(it)
                    else -> countries = countries.plus(", ").plus(it)
                }
            }

        tvType.text = genres
        tvProduction.text = countries
        tvPremiere.text = movie.releaseDate
        tvDescription.text = movie.overview

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/original"+movie.posterPath)
            .into(ivMovieDetailPoster)

        movie.genres?.toMutableList()?.let { mGenresListAdapter.setNewData(it) }
    }

    override fun displayActorList(actorList: List<PersonVO>) {
        mActorListAdapter.setNewData(actorList.toMutableList())
    }

    override fun displalyCreatorList(creatorList: List<PersonVO>) {
        mCreatorListAdapter.setNewData(creatorList.toMutableList())
    }

    override fun displayMovieDetails(movie: MovieVO) {
        bindData(movie)
    }

    override fun navigateToMainScreen() {
        startActivity(MainActivity.newIntent(this))
        finish()
    }
}
