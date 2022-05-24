package com.app.currencyscoop

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.app.currencyscoop.activity.CurrencyListActivity
import com.app.currencyscoop.activity.CurrencyRatesActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )


        Handler().postDelayed({
            val sharedPreference =  getSharedPreferences("app", Context.MODE_PRIVATE)
            if(sharedPreference.contains("currency_name")){
                val intent = Intent(this, CurrencyRatesActivity::class.java)
                startActivity(intent)
                finish()
            }else {
                val intent = Intent(this, CurrencyListActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 1500)
    }
}