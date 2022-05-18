package com.app.currencyscoop.activity


import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.app.currencyscoop.R
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ConvertActivityTest{


    private lateinit var scenario:ActivityScenario<ConvertActivity>

    @Before
    fun setup(){
        scenario= ActivityScenario.launch(ConvertActivity::class.java)
        scenario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun testConvertActivity() {

        onView(withId(R.layout.activity_convert))
        val result=scenario.onActivity {
            it.from_currency=="USD" && it.to_currency=="INR"
            it.getAmount("422ffc3866e625a5989e3fac8a2486e7","USD","INR","1")
        }

        assertThat(result!=null).isTrue()

}
}
















