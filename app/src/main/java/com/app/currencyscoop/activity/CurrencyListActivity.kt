package com.app.currencyscoop.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.currencyscoop.R
import com.app.currencyscoop.adapter.CurrencyListAdapter
import com.app.currencyscoop.apputils.AppUtils
import com.app.currencyscoop.model.CurrencyModel
import com.app.currencyscoop.viewmodel.CurrencyListViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_currency_list.*
import org.json.JSONObject

class CurrencyListActivity : AppCompatActivity() {
    lateinit var currencyListAdapter:CurrencyListAdapter


    companion object{
        lateinit var dataCurrencyModel:CurrencyModel
        var isChecked:Boolean = false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_list)

        initRecyclerview()
        if (AppUtils.internetCheck(this))
            initViewModel()
        else
        {
            //no internet
            val intent=   Intent(this, CurrencyRatesActivity::class.java)
            startActivity(intent)
            finish()

        }

        next_button.setOnClickListener {
            if (!isChecked)
            {
                AppUtils.alertSimple(this, "Please select currency")
            }else {
                val intent = Intent(this, CurrencyRatesActivity::class.java)
                intent.putExtra("base_currency", dataCurrencyModel)
                startActivity(intent) }
        }
    }

    private fun initRecyclerview(){
        currencyListRecyclerView.layoutManager=LinearLayoutManager(this)
        currencyListAdapter= CurrencyListAdapter(this,object : CurrencyListAdapter.OnClickListenerItem{
            override fun onClick(currencyModel: CurrencyModel) {
                isChecked=true
                dataCurrencyModel = currencyModel
            }
        })
        currencyListRecyclerView.adapter=currencyListAdapter
    }

    private fun initViewModel()
    {
        progress_bar.visibility=View.VISIBLE
        val viewModel:CurrencyListViewModel=ViewModelProvider(this).get(CurrencyListViewModel ::class.java)
        viewModel.getLiveDataObserver().observe(this) {
            if (it != null) {
                progress_bar.visibility = View.GONE
                val dataList = ArrayList<CurrencyModel>()
                val jsonResponse = Gson().toJson(it.response)
                val obj = JSONObject(jsonResponse)
                val listPathObject: JSONObject = obj.getJSONObject("fiats")
                val iter = listPathObject.keys()
                while (iter.hasNext()) {
                    val key = iter.next()
                    val value: String = listPathObject.getString(key)
                    val currency_name_val = JSONObject(value).get("currency_name")
                    val currency_code_val: String = JSONObject(value).get("currency_code") as String
                    dataList.add(CurrencyModel(currency_name_val.toString(), currency_code_val))
                }
                currencyListAdapter.setCurrencyList(dataList)
                currencyListAdapter.notifyDataSetChanged()
            } else {
                progress_bar.visibility = View.GONE
            }
        }
        viewModel.makeApiCall(this,viewModel)
    }
}