package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.presenters.impls

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.models.MockMovieModelImpl
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.models.MovieModel
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.models.MovieModelImpl
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.MovieVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.VideoDetailVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.VideoVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.dummy.getDummyGenres
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.dummy.getDummyMovies
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.dummy.getDummyPerson
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.presenters.MainPresenterImpl
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.views.MainView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MainPresenterImplTest {
    private lateinit var mPresenter : MainPresenterImpl

    @RelaxedMockK
    private lateinit var mView : MainView

    private lateinit var mMovieModel : MovieModel

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)

        MovieModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mMovieModel = MockMovieModelImpl
        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mMovieModel = this.mMovieModel
    }

    @Test
    fun onTapPlay_callNavigateToPlay() {
        val tappedMovieVideo = VideoDetailVO()
        tappedMovieVideo.id = 550
        tappedMovieVideo.results.add(VideoVO("5c9294240e0a267cd516835f","BdJKm16Co6M"))
        tappedMovieVideo.results.add(VideoVO("5e382d1b4ca676001453826d","6JnN1DmbqoU"))
        mPresenter.onTapPlay(tappedMovieVideo.id)
        verify {
            mView?.navigateToPlay(tappedMovieVideo)
        }
    }

    @Test
    fun onTapMovieItem_callNavigateToDetails() {
        val tappedMovieId = 17
        mPresenter.onTapMovieItem(tappedMovieId)
        verify {
            mView?.navigateToDetails(tappedMovieId)
        }
    }

    @Test
    fun onTapGenreItem_callDisplayMovieByGenre() {
        val tappedGenreId = 1
        val lifecycleOwner = mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifecycleOwner.lifecycle).thenReturn(lifeCycleRegistry)

        mPresenter.onUiReady(lifecycleOwner,tappedGenreId)
        mPresenter.onTapGenreItems(tappedGenreId)

        verify {
            mView?.displayMoviesByGenre(getDummyMovies().filter {
                it.genreIds.contains(tappedGenreId)
            })
        }
    }

    @Test
    fun onUiReady_callDisplayMoviesList_callSetGenres(){
        val genreId = 17
        val lifecycleOwner = mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifecycleOwner.lifecycle).thenReturn(lifeCycleRegistry)
        mPresenter.onUiReady(lifecycleOwner,genreId)
        verify {
            mView?.displayPopularMovieList(getDummyMovies())
        }
    }
}