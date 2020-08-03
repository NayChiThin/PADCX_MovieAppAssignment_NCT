package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.uitests

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.R
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.activities.DetailActivity
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.activities.MainActivity
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.viewholders.PopularMovieViewHolder
import kotlinx.android.synthetic.main.activity_detail.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class GoToMainTest {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)
    @Before
    fun setUp() {
        activityTestRule.launchActivity(Intent())
    }
    @Test
    fun onTapBack_navigateToMain() {

        onView(withId(R.id.rvPopularMovies)).perform(RecyclerViewActions.actionOnItemAtPosition<PopularMovieViewHolder>(0,click()))
        onView(withId(R.id.ivBack)).perform(click())
        onView(withId(R.id.rvPopularMovies)).check(matches(isDisplayed()))
    }
}
