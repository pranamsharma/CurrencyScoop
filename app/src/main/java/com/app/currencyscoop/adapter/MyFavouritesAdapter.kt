package com.app.currencyscoop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.currencyscoop.R
import com.app.currencyscoop.roomdatabase.entity.FavouritesEntity
import kotlinx.android.synthetic.main.currency_rates_row.view.*

class MyFavouritesAdapter(val activity: Context, private val deleteFavouritesInterface: DeleteFavouritesInterface):RecyclerView.Adapter<MyFavouritesAdapter.MyViewHolder>() {
    private var currencyList:List<FavouritesEntity>?=null

     fun setCurrencyList(currencyList:List<FavouritesEntity>)
    {
        this.currencyList=currencyList
    }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyFavouritesAdapter.MyViewHolder {
         val view= LayoutInflater.from(parent.context).inflate(R.layout.currency_rates_row,parent,false)
   return MyViewHolder(view = view)
    }

    override fun onBindViewHolder(holder: MyFavouritesAdapter.MyViewHolder, position: Int) {
                 holder.bind(currencyList?.get(position)!!,deleteFavouritesInterface)

    }


    override fun getItemCount(): Int {
        if(currencyList == null)return 0
        else return currencyList?.size!!
    }

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
         val currencyRates= view.currencyRatesTv
        val addFavouriteIb= view.add_fav_ib
         fun bind(data : FavouritesEntity,deleteFavouritesInterface: DeleteFavouritesInterface){
             currencyRates.text=data.currencyCode
             addFavouriteIb.setOnClickListener {
                 deleteFavouritesInterface.onDeleteFavourite(data,adapterPosition)
             }
         }
    }


}
interface DeleteFavouritesInterface {
    fun onDeleteFavourite(favouritesEntity: FavouritesEntity, position: Int)
}