package com.app.currencyscoop.activity

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.app.currencyscoop.R
import com.app.currencyscoop.model.CurrencyModel
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class CurrencyListActivityTest{

    private lateinit var scenario:ActivityScenario<CurrencyListActivity>

    @Before
    fun setup(){
        scenario= ActivityScenario.launch(CurrencyListActivity::class.java)
        scenario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun testCurrencyListActivity(){
        onView(withId(R.layout.activity_currency_list))
        val result= scenario.onActivity {
            it.currencyListAdapter.setCurrencyList(ArrayList<CurrencyModel>())
        }
        assertThat(result!==null).isTrue()
    }
}