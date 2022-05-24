package com.app.currencyscoop.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.app.currencyscoop.R
import com.app.currencyscoop.model.CurrencyModel
import kotlinx.android.synthetic.main.currency_list_row.view.*

class CurrencyListAdapter(val activity: Activity,val onClickListener: OnClickListenerItem):RecyclerView.Adapter<CurrencyListAdapter.MyViewHolder>() {
    private var currencyList:List<CurrencyModel>?=null
    private var lastCheckedRB: RadioButton? = null
    fun setCurrencyList(currencyList:ArrayList<CurrencyModel>)
    {
        this.currencyList=currencyList
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CurrencyListAdapter.MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.currency_list_row,parent,false)
        return MyViewHolder(view = view)
    }

    override fun onBindViewHolder(holder: CurrencyListAdapter.MyViewHolder, position: Int) {
        holder.bind(currencyList?.get(position)!!,activity)

        holder.view_btn.setOnClickListener {
            if (lastCheckedRB!=null){
                lastCheckedRB?.isChecked=false
            }
            lastCheckedRB = holder.view_btn
            if(onClickListener!=null){
                onClickListener!!.onClick(currencyList?.get(position)!!)
            }
        }

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        if(currencyList == null)return 0
        else return currencyList?.size!!
    }

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){

        val currencyName= view.currencyNameTv
        val currencyCode= view.currencyCodeTv
        val view_btn=view.view_btn
        fun bind(data : CurrencyModel,activity: Activity){


            currencyName.text=data.currency_name
            currencyCode.text=data.currency_code
        }
    }

    interface OnClickListenerItem{
        fun onClick(currencyModel: CurrencyModel)
    }
}