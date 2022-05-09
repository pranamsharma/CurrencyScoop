package com.app.currencyscoop.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.currencyscoop.R
import com.app.currencyscoop.model.CurrencyRatesModel
import kotlinx.android.synthetic.main.currency_rates_row.view.*

class CurrencyRatesAdapter(val activity: Activity,val addFavouritesInterface: AddFavouritesInterface):RecyclerView.Adapter<CurrencyRatesAdapter.MyViewHolder>() {
    private var currencyList:List<CurrencyRatesModel>?=null

     fun setCurrencyList(currencyList:ArrayList<CurrencyRatesModel>)
    {
        this.currencyList=currencyList
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CurrencyRatesAdapter.MyViewHolder {
         val view= LayoutInflater.from(parent.context).inflate(R.layout.currency_rates_row,parent,false)
   return MyViewHolder(view = view)
    }

    override fun onBindViewHolder(holder: CurrencyRatesAdapter.MyViewHolder, position: Int) {
                 holder.bind(currencyList?.get(position)!!,addFavouritesInterface)

    }


    override fun getItemCount(): Int {
        if(currencyList == null) return 0
        else return currencyList?.size!!
    }

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
         val currencyRates= view.currencyRatesTv
        val addFavouriteIb= view.add_fav_ib
         fun bind(data : CurrencyRatesModel,addFavouritesInterface: AddFavouritesInterface){
             currencyRates.text=data.rates
             addFavouriteIb.setOnClickListener {
                 addFavouritesInterface.onAddFavourite(data.rates)
             }
         }
    }


}
interface AddFavouritesInterface {
    fun onAddFavourite(currency:String)
}