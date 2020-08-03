package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.activities

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.R
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.adapters.PersonListAdapter
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.adapters.PopularMovieListAdapter
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.adapters.ShowCaseAdapter
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.adapters.SliderAdapter
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.*
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.presenters.MainPresenter
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.presenters.MainPresenterImpl
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MainView,BaseActivity() {
    private lateinit var mPopularMovieListAdapter : PopularMovieListAdapter
    private lateinit var mPersonListAdapter : PersonListAdapter
    private lateinit var mMoviesAdapter : PopularMovieListAdapter
    private lateinit var mShowCasesAdapter : ShowCaseAdapter
    private lateinit var mPresenter : MainPresenter
    private lateinit var mUpcomingMoviesAdapter : SliderAdapter
    private var genresName = arrayListOf<String>()
    private var genresId = arrayListOf<Int>()
    private var genre = 12

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()
        setUpRecyclerView()
        setUpSliderView()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
//                mNowPlayingMovieListAdapter.setNewData(filterGenre(allMovies).toMutableList())
                genre = genresId[tabLayout.selectedTabPosition]
                mPresenter.onTapGenreItems(genre)
            }
        })

        mPresenter.onUiReady(this,genre)
    }
    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }
    private fun setUpSliderView() {
        mUpcomingMoviesAdapter = SliderAdapter(mPresenter)
        sliderUpcoming.setSliderAdapter(mUpcomingMoviesAdapter)
    }
    private fun setUpRecyclerView() {
        // popular movie list
        mPopularMovieListAdapter = PopularMovieListAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvPopularMovies.adapter = mPopularMovieListAdapter
        rvPopularMovies.layoutManager = linearLayoutManager

        // best actor list
        mPersonListAdapter = PersonListAdapter(mPresenter)
        val linearLayoutManager2 = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvPersonList.adapter = mPersonListAdapter
        rvPersonList.layoutManager = linearLayoutManager2

        // movie list by genre
        mMoviesAdapter = PopularMovieListAdapter(mPresenter)
        val linearLayoutManager3 = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvMovies.adapter = mMoviesAdapter
        rvMovies.layoutManager = linearLayoutManager3

        // show case list
        mShowCasesAdapter = ShowCaseAdapter(mPresenter)
        val linearLayoutManager4 = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvShowCases.adapter = mShowCasesAdapter
        rvShowCases.layoutManager = linearLayoutManager4
    }
    private fun setUpTabLayout(){
        for(i in 0 until genresName.size) {
            tabLayout.addTab(tabLayout.newTab().setText(genresName[i]))
        }
    }

    override fun displayPopularMovieList(movieList: List<MovieVO>) {
        mPopularMovieListAdapter.setNewData(movieList.toMutableList())
    }

    override fun displayNowPlayingMovieList(movieList: List<MovieVO>) {
        mShowCasesAdapter.setNewData(movieList.toMutableList())
    }

    override fun setGenresList(genresList: List<GenresVO>) {
        for(i in 0 until genresList.count()) {
            genresName.add(genresList[i].name)
            genresId.add(genresList[i].id)
        }
        setUpTabLayout()
    }

    override fun displayPersonList(personList: List<PersonVO>) {
        mPersonListAdapter.setNewData(personList.toMutableList())
    }

    override fun navigateToDetails(movieId: Int) {
        startActivity(DetailActivity.newIntent(this,movieId))
        finish()
    }

    override fun displayMoviesByGenre(movieList: List<MovieVO>) {
        mMoviesAdapter.setNewData(movieList.toMutableList())
    }

    override fun displayUpcomingMovieList(movieList: List<MovieVO>) {
        mUpcomingMoviesAdapter.setNewData(movieList.toMutableList())
    }

    override fun navigateToPlay(movie:VideoDetailVO) {
        var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v="+movie.results[0].key))
        startActivity(intent)
    }

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context,MainActivity::class.java)
        }
    }

}
