package com.app.currencyscoop.activity

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.app.currencyscoop.R
import com.app.currencyscoop.apputils.AppUtils
import com.app.currencyscoop.viewmodel.ConvertViewModel
import kotlinx.android.synthetic.main.activity_convert.*
import java.text.DecimalFormat

class ConvertActivity : AppCompatActivity() {



    lateinit var from_currency:String
    lateinit var to_currency:String
    lateinit var currency_code_intent:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convert)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Currency Converter"


        currency_code_intent= intent.getStringExtra("currency_code_intent") as String
        val currencyList = resources.getStringArray(R.array.currency_array)
        val adapter =object: ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item, currencyList)
        {
            override fun isEnabled(position: Int): Boolean {

                return position != 0
            }

            override fun getDropDownView(
                position: Int,
                convertView: View?,
                parent: ViewGroup
            ): View {
                val view: TextView = super.getDropDownView(position, convertView, parent) as TextView
                if(position == 0) {
                    view.setTextColor(Color.GRAY)
                }
                return view
            }

        }
        from_spinner.adapter = adapter
        to_spinner.adapter = adapter



        from_spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {

                from_currency=currencyList[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        //to
        to_spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {


                val selectionPosition = adapter.getPosition(currency_code_intent)
                to_spinner.setSelection(selectionPosition)

                to_currency=currency_code_intent
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        convert_btn.setOnClickListener {

            if(from_currency.contentEquals("Select Currency"))
                AppUtils.alertSimple(this, "Please select any currency")

            else if (amount_et.text.isEmpty()) amount_et.error="Enter Amount!"
            else
                getAmount(resources.getString(R.string.api_key),from_currency,to_currency,amount_et.text.toString())
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    fun getAmount(apiKey: String, from_currency: String, to_currency: String, amount: String) {

        progress_convert_bar.visibility= View.VISIBLE
        val viewModel: ConvertViewModel = ViewModelProvider(this).get(ConvertViewModel ::class.java)
        viewModel.getLiveDataObserver().observe(this) {
            if (it != null) {

                progress_convert_bar.visibility = View.GONE
                Log.e("response", it.response.toString())

                value_tv.visibility = View.VISIBLE
                val df = DecimalFormat("#.##")
                value_tv.text = df.format(it.response.value).toString() + " " + to_currency
            } else {

                progress_convert_bar.visibility = View.GONE
                //Toast.makeText(this, "Something went Wrong!", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.makeApiCall(apiKey,from_currency,to_currency,amount,this)
    }
}