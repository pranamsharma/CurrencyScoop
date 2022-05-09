package com.app.currencyscoop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.currencyscoop.R
import com.app.currencyscoop.activity.ui.main.MyFavouritesFragment

class MyFavouritesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_favourites_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MyFavouritesFragment.newInstance())
                .commitNow()
        }
    }
}