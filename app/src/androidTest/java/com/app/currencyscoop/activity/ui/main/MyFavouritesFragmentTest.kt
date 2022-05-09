package com.app.currencyscoop.activity.ui.main

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.app.currencyscoop.R
import com.app.currencyscoop.roomdatabase.entity.FavouritesEntity
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MyFavouritesFragmentTest{


    @Test
    fun testEventFragment() {
        val scenario = launchFragmentInContainer<MyFavouritesFragment>()
        scenario.recreate()
        scenario.onFragment { fragment ->
            onView(withId(R.layout.my_favourites_fragment))
        }
    }
}