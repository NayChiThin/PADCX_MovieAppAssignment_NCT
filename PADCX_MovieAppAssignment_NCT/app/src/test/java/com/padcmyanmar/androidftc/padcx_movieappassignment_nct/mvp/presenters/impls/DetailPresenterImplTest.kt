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
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.dummy.getDummyMovies
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.presenters.DetailPresenterImpl
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.views.DetailView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class DetailPresenterImplTest {
    private lateinit var mPresenter : DetailPresenterImpl
    @RelaxedMockK
    private lateinit var mView : DetailView
    private lateinit var mMovieModel : MovieModel

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)
        MovieModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mMovieModel = MockMovieModelImpl
        mPresenter = DetailPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mMovieModel = this.mMovieModel
    }
    @Test
    fun onTapBack_callNavigateToMain() {
        mPresenter.onTapBack()
        verify {
            mView?.navigateToMainScreen()
        }
    }
    @Test
    fun onUiReady_callDisplayMovieDetails() {
        val movie = getDummyMovies().first()
        val lifecycleOwner = Mockito.mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        Mockito.`when`(lifecycleOwner.lifecycle).thenReturn(lifeCycleRegistry)
        mPresenter.onUiReady(lifecycleOwner,movie.id)
        verify {
            mView?.displayMovieDetails(movie)
        }
    }
}