package com.app.currencyscoop.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.currencyscoop.R
import com.app.currencyscoop.adapter.AddFavouritesInterface
import com.app.currencyscoop.adapter.CurrencyRatesAdapter
import com.app.currencyscoop.adapter.DeleteFavouritesInterface
import com.app.currencyscoop.adapter.MyFavouritesAdapter
import com.app.currencyscoop.apputils.AppUtils
import com.app.currencyscoop.model.CurrencyModel
import com.app.currencyscoop.model.CurrencyRatesModel
import com.app.currencyscoop.roomdatabase.entity.BaseCurrencyEntity
import com.app.currencyscoop.roomdatabase.entity.FavouritesEntity
import com.app.currencyscoop.viewmodel.BaseCurrencyDBViewModel
import com.app.currencyscoop.viewmodel.CurrencyRatesViewModel
import com.app.currencyscoop.viewmodel.FavouritesViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_currency_rates.*
import org.json.JSONObject
import java.text.DecimalFormat


class CurrencyRatesActivity : AppCompatActivity() {

    lateinit var currencyRatesAdapter: CurrencyRatesAdapter

    lateinit var viewModal: FavouritesViewModel
    lateinit var bcdViewModel: BaseCurrencyDBViewModel
    lateinit var currency_code_intent:String


    var data_check_List:List<FavouritesEntity>?=null


    //private lateinit var viewModel: FavouritesViewModel

    lateinit var myFavouritesAdapter: MyFavouritesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_rates)
        supportActionBar?.hide()


        val sharedPreference =  getSharedPreferences("app", Context.MODE_PRIVATE)

        if(intent.hasExtra("base_currency")) {
            val currencyModel = intent?.getSerializableExtra("base_currency") as CurrencyModel

            basecurrency_tv.text = currencyModel.currency_name + "(${currencyModel.currency_code})"

            currency_code_intent=currencyModel.currency_code

            var editor = sharedPreference.edit()
            editor.putString("currency_name",currencyModel.currency_name)
            editor.putString("currency_code",currencyModel.currency_code)
            editor.commit()

        }

        if(sharedPreference.contains("currency_name"))
        {
            basecurrency_tv.text = sharedPreference.getString("currency_name"," ") + " ("+sharedPreference.getString("currency_code"," ")+ ") "

            currency_code_intent= sharedPreference.getString("currency_code"," ").toString()


        }


        initRecyclerview()


        //This is for Favourites
        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(FavouritesViewModel::class.java)

        //This is for Basecureency
        bcdViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(BaseCurrencyDBViewModel::class.java)

        convert_ib.setOnClickListener {
            val intent=   Intent(this, ConvertActivity::class.java)
            intent.putExtra("currency_code_intent",currency_code_intent)
            startActivity(intent)
        }
        currency_list_ib.setOnClickListener {
            val intent=   Intent(this, CurrencyListActivity::class.java)
            //intent.flags =  Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            //finish()
        }


        /*----------- My favouorites --------------*/
        initFavRecyclerview()
        viewModal.allFavourites.observe(this, Observer { list ->
            list?.let {

                data_check_List=it;
                myFavouritesAdapter.setCurrencyList(it)
            }
        })


        if (AppUtils.internetCheck(this)){
            if(intent.hasExtra("base_currency"))
            {
                val currencyModel = intent?.getSerializableExtra("base_currency") as CurrencyModel
                initViewModel(currencyModel.currency_code)
            }else{
                initViewModel(sharedPreference.getString("currency_code","") as String)
            }


        }
        else {
            getOfflineData()
        }
    }

    private fun initRecyclerview(){
        currencyListRecyclerView.layoutManager= LinearLayoutManager(this)
        currencyRatesAdapter= CurrencyRatesAdapter(this,object : AddFavouritesInterface{
            override fun onAddFavourite(currency: String) {
                favouritesViewModel(currency)

            }




        })
        currencyListRecyclerView.adapter=currencyRatesAdapter

    }

    private fun initFavRecyclerview(){
        favouriteListRecyclerView.layoutManager= LinearLayoutManager(this)
        myFavouritesAdapter= MyFavouritesAdapter(this ,object : DeleteFavouritesInterface {
            override fun onDeleteFavourite(favouritesEntity: FavouritesEntity, position: Int) {
                viewModal.deleteFavourites(favouritesEntity)
                // myFavouritesAdapter!!.notifyItemRemoved(position)
                myFavouritesAdapter!!.notifyDataSetChanged()
                myFavouritesAdapter!!.notifyItemRemoved(position)
                Toast.makeText(applicationContext, "${favouritesEntity.currencyCode} Deleted", Toast.LENGTH_LONG).show()

            }

        })
        favouriteListRecyclerView.adapter=myFavouritesAdapter

    }

    private fun initViewModel(base_currency:String)
    {
        val dataList = ArrayList<CurrencyRatesModel>()
        progress_bar.visibility= View.VISIBLE
        val viewModel: CurrencyRatesViewModel = ViewModelProvider(this).get(CurrencyRatesViewModel ::class.java)
        viewModel.getLiveDataObserver().observe(this) {
            if (it != null) {

                progress_bar.visibility = View.GONE



                val jsonResponse = Gson().toJson(it.response)
                val obj = JSONObject(jsonResponse)
                val listPathObject: JSONObject = obj.getJSONObject("rates")
                val iter = listPathObject.keys()

                val df = DecimalFormat("#,##.00")
                while (iter.hasNext()) {
                    val key = iter.next()
                    val value: String = listPathObject.getString(key)

                    val df = DecimalFormat()
                    df.maximumFractionDigits = 2
                    dataList.add(CurrencyRatesModel(key +" : " + value))

                }


                currencyRatesAdapter.setCurrencyList(dataList)
                currencyRatesAdapter.notifyDataSetChanged()

            } else {

                progress_bar.visibility = View.GONE
                Toast.makeText(this, "Something went Wrong!", Toast.LENGTH_SHORT).show()
            }

            for (i in dataList)
            {
                saveBaseCurrencyDataInDB(base_currency,i)
            }

        }

        viewModel.makeApiCall(base_currency,this,viewModel)
    }




    private fun favouritesViewModel(currency:String)
    {
        viewModal.addFavourites(FavouritesEntity(currency))
        Toast.makeText(this, "$currency Added in Favourites", Toast.LENGTH_LONG).show()
    }

    private fun saveBaseCurrencyDataInDB(base_currency: String,conversion_list:CurrencyRatesModel){

        bcdViewModel.addBaseCurrencyData(BaseCurrencyEntity(base_currency,conversion_list.rates))


    }

    private fun getOfflineData()
    {

        val dataList=ArrayList<CurrencyRatesModel>()
        bcdViewModel.allBaseCurrencyData.observe(this, Observer { list ->
            list?.let {
                for (i in it) {
                    Log.e("check", i.conversion_list)

                    dataList.add(CurrencyRatesModel( i.conversion_list))
                    currencyRatesAdapter.setCurrencyList(dataList)
                    currencyRatesAdapter.notifyDataSetChanged()
                }
                basecurrency_tv.text= it[0].base_currency

            }
        })

    }

    fun backOperation(view: View) {
        //onBackPressed()
        System.exit(0)
        finish()
    }


}