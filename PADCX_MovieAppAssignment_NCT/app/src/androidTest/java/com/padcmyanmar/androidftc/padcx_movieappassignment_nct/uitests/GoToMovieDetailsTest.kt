package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.uitests

import android.content.Intent
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ScrollView
import androidx.core.widget.NestedScrollView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ScrollToAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.R
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.activities.MainActivity
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.viewholders.PopularMovieViewHolder
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.anyOf
import org.hamcrest.Matcher
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class GoToMovieDetailsTest {

    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    val customScrollTo: ViewAction = object : ViewAction {
        override fun getConstraints(): Matcher<View> {
            return CoreMatchers.allOf(
                withEffectiveVisibility(Visibility.VISIBLE),
                isDescendantOfA(
                    anyOf(
                        isAssignableFrom(ScrollView::class.java),
                        isAssignableFrom(HorizontalScrollView::class.java),
                        isAssignableFrom(NestedScrollView::class.java)
                    )
                )
            )
        }

        override fun getDescription(): String {
            return ""
        }

        override fun perform(uiController: UiController?, view: View?) {
            ScrollToAction().perform(uiController, view)
        }
    }

    @Before
    fun setUp() {
        activityTestRule.launchActivity(Intent())
    }
      @Test
      fun tapOnGenreMovie_navigateToMovieDetails() {

          onView(withId(R.id.rvMovies)).perform(customScrollTo,RecyclerViewActions.actionOnItemAtPosition<PopularMovieViewHolder>(0,click()))
          onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
      }
}