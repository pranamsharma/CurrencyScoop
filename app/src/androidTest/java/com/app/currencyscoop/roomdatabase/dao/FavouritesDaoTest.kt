package com.app.currencyscoop.roomdatabase.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.app.currencyscoop.getOrAwaitValue
import com.app.currencyscoop.roomdatabase.database.FavouritesDatabase
import com.app.currencyscoop.roomdatabase.entity.FavouritesEntity
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class FavouritesDaoTest {
    @get:Rule
    var instantTaskExecutorRule= InstantTaskExecutorRule()

    private lateinit var database: FavouritesDatabase
    private lateinit var dao:FavouritesDao

    @Before
    fun setUp(){
        database= Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            FavouritesDatabase::class.java
        ).allowMainThreadQueries().build()

        dao=database.getFavouritesDao()
    }

    @After
    fun tearDown(){
        database.close()
    }


    @Test
   fun insertFavouriteTest()= runBlockingTest {
        val favourite=FavouritesEntity("INR")
        dao.insert(favourite)

        val allFavourite=dao.getAllFavourites().getOrAwaitValue()

        assertThat(allFavourite.contains(favourite)).isFalse()
    }


    @Test
    fun deleteFavouriteTest()=runBlockingTest {
        val favourite=FavouritesEntity("INR")
        dao.insert(favourite)
        dao.delete(favourite)

        val allFavourite=dao.getAllFavourites().getOrAwaitValue()
        assertThat(allFavourite).doesNotContain(favourite)
    }
}