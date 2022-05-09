package com.app.currencyscoop.activity

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
import com.app.currencyscoop.apputils.AppUtils
import com.app.currencyscoop.model.CurrencyModel
import com.app.currencyscoop.model.CurrencyRatesModel
import com.app.currencyscoop.roomdatabase.entity.BaseCurrencyEntity
import com.app.currencyscoop.roomdatabase.entity.FavouritesEntity
import com.app.currencyscoop.viewmodel.BaseCurrencyDBViewModel
import com.app.currencyscoop.viewmodel.CurrencyRatesViewModel
import com.app.currencyscoop.viewmodel.FavouritesViewModel
import kotlinx.android.synthetic.main.activity_currency_rates.*
import java.text.DecimalFormat

class CurrencyRatesActivity : AppCompatActivity() {

lateinit var currencyRatesAdapter: CurrencyRatesAdapter

    lateinit var viewModal: FavouritesViewModel
    lateinit var bcdViewModel: BaseCurrencyDBViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_rates)
        supportActionBar?.hide()


         if(intent.hasExtra("base_currency")) {
            val currencyModel = intent?.getSerializableExtra("base_currency") as CurrencyModel



             basecurrency_tv.text = currencyModel.currency_name + "(${currencyModel.currency_code})"
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
             startActivity(intent)
        }
        my_favourites_ib.setOnClickListener {
            val intent=   Intent(this, MyFavouritesActivity::class.java)
             startActivity(intent)
        }


        if (AppUtils.internetCheck(this)){
            val currencyModel = intent?.getSerializableExtra("base_currency") as CurrencyModel
            initViewModel(currencyModel.currency_code)}
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

    private fun initViewModel(base_currency:String)
    {
        val dataList = ArrayList<CurrencyRatesModel>()
        progress_bar.visibility= View.VISIBLE
        val viewModel: CurrencyRatesViewModel = ViewModelProvider(this).get(CurrencyRatesViewModel ::class.java)
        viewModel.getLiveDataObserver().observe(this) {
            if (it != null) {

                progress_bar.visibility = View.GONE




                val df = DecimalFormat("#.##")

                dataList.add(CurrencyRatesModel("AED: " + df.format(it.response.rates.AED)))
                dataList.add(CurrencyRatesModel("AFN: " + df.format(it.response.rates.AFN)))
                dataList.add(CurrencyRatesModel("ALL: " + df.format(it.response.rates.ALL)))
                dataList.add(CurrencyRatesModel("AMD: " + df.format(it.response.rates.AMD)))
                dataList.add(CurrencyRatesModel("ANG: " + df.format(it.response.rates.ANG)))
                dataList.add(CurrencyRatesModel("AOA: " + df.format(it.response.rates.AOA)))
                dataList.add(CurrencyRatesModel("ARS :" + df.format(it.response.rates.ARS)))
                dataList.add(CurrencyRatesModel("AUD :" + df.format(it.response.rates.AUD)))
                dataList.add(CurrencyRatesModel("AWG :" + df.format(it.response.rates.AWG)))
                dataList.add(CurrencyRatesModel("AZN :" + df.format(it.response.rates.AZN)))

                dataList.add(CurrencyRatesModel("BAM : " + df.format(it.response.rates.BAM)))
                dataList.add(CurrencyRatesModel("BBD : " + df.format(it.response.rates.BBD)))
                dataList.add(CurrencyRatesModel("BDT : " + df.format(it.response.rates.BDT)))
                dataList.add(CurrencyRatesModel("BGN : " + df.format(it.response.rates.BGN)))
                dataList.add(CurrencyRatesModel("BHD : " + df.format(it.response.rates.BHD)))
                dataList.add(CurrencyRatesModel("BIF : " + df.format(it.response.rates.BIF)))

                dataList.add(CurrencyRatesModel("BMD:" + df.format(it.response.rates.BMD)))
                dataList.add(CurrencyRatesModel("BND : " + df.format(it.response.rates.BND)))
                dataList.add(CurrencyRatesModel("BOB : " + df.format(it.response.rates.BOB)))
                dataList.add(CurrencyRatesModel("BRL : " + df.format(it.response.rates.BRL)))
                dataList.add(CurrencyRatesModel("BSD : " + df.format(it.response.rates.BSD)))
                dataList.add(CurrencyRatesModel("BTN : " + df.format(it.response.rates.BTN)))
                dataList.add(CurrencyRatesModel("BWP:" + df.format(it.response.rates.BWP)))
                dataList.add(CurrencyRatesModel("BYN : " + df.format(it.response.rates.BYN)))
                dataList.add(CurrencyRatesModel("BYR : " + df.format(it.response.rates.BYR)))
                dataList.add(CurrencyRatesModel("BZD : " + df.format(it.response.rates.BZD)))

                dataList.add(CurrencyRatesModel("CAD:" + df.format(it.response.rates.CAD)))
                dataList.add(CurrencyRatesModel("CDF : " + df.format(it.response.rates.CDF)))
                dataList.add(CurrencyRatesModel("CHF : " + df.format(it.response.rates.CHF)))
                dataList.add(CurrencyRatesModel("CLF : " + df.format(it.response.rates.CLF)))
                dataList.add(CurrencyRatesModel("CLP : " + df.format(it.response.rates.CLP)))
                dataList.add(CurrencyRatesModel("CNH : " + df.format(it.response.rates.CNH)))
                dataList.add(CurrencyRatesModel("CNY:" + df.format(it.response.rates.CNY)))
                dataList.add(CurrencyRatesModel("COP : " + df.format(it.response.rates.COP)))
                dataList.add(CurrencyRatesModel("CRC : " + df.format(it.response.rates.CRC)))
                dataList.add(CurrencyRatesModel("CUC : " + df.format(it.response.rates.CUC)))
                dataList.add(CurrencyRatesModel("CUP:" + df.format(it.response.rates.CUP)))
                dataList.add(CurrencyRatesModel("CVE : " + df.format(it.response.rates.CVE)))
                dataList.add(CurrencyRatesModel("CZK : " + df.format(it.response.rates.CZK)))

                dataList.add(CurrencyRatesModel("DEM : " + df.format(it.response.rates.DEM)))
                dataList.add(CurrencyRatesModel("DJF : " + df.format(it.response.rates.DJF)))
                dataList.add(CurrencyRatesModel("DKK : " + df.format(it.response.rates.DKK)))
                dataList.add(CurrencyRatesModel("DOGE :" + df.format(it.response.rates.DOGE)))
                dataList.add(CurrencyRatesModel("DOP : " + df.format(it.response.rates.DOP)))
                dataList.add(CurrencyRatesModel("DOT : " + df.format(it.response.rates.DOT)))
                dataList.add(CurrencyRatesModel("DZD : " + df.format(it.response.rates.DZD)))


                dataList.add(CurrencyRatesModel("EEK : " + df.format(it.response.rates.EEK)))
                dataList.add(CurrencyRatesModel("EGP : " + df.format(it.response.rates.EGP)))
                dataList.add(CurrencyRatesModel("ERN : " + df.format(it.response.rates.ERN)))
                dataList.add(CurrencyRatesModel("ESP :" + df.format(it.response.rates.ESP)))
                dataList.add(CurrencyRatesModel("ETB : " + df.format(it.response.rates.ETB)))
                dataList.add(CurrencyRatesModel("ETH : " + df.format(it.response.rates.ETH)))
                dataList.add(CurrencyRatesModel("EUR : " + df.format(it.response.rates.EUR)))

                dataList.add(CurrencyRatesModel("FIM : " + df.format(it.response.rates.FIM)))
                dataList.add(CurrencyRatesModel("FJD : " + df.format(it.response.rates.FJD)))
                dataList.add(CurrencyRatesModel("FKP : " + df.format(it.response.rates.FKP)))
                dataList.add(CurrencyRatesModel("FRF :" + df.format(it.response.rates.FRF)))

                dataList.add(CurrencyRatesModel("GBP : " + df.format(it.response.rates.GBP)))
                dataList.add(CurrencyRatesModel("GEL : " + df.format(it.response.rates.GEL)))
                dataList.add(CurrencyRatesModel("GGP : " + df.format(it.response.rates.GGP)))
                dataList.add(CurrencyRatesModel("GHC : " + df.format(it.response.rates.GHC)))
                dataList.add(CurrencyRatesModel("GHS : " + df.format(it.response.rates.GHS)))
                dataList.add(CurrencyRatesModel("GIP : " + df.format(it.response.rates.GIP)))
                 dataList.add(CurrencyRatesModel("GMD : " + df.format(it.response.rates.GMD)))
                dataList.add(CurrencyRatesModel("GRD : " + df.format(it.response.rates.GRD)))
                 dataList.add(CurrencyRatesModel("GTQ : " + df.format(it.response.rates.GTQ)))
                 dataList.add(CurrencyRatesModel("GYD : " + df.format(it.response.rates.GYD)))

                dataList.add(CurrencyRatesModel("HKD : " + df.format(it.response.rates.HKD)))
                dataList.add(CurrencyRatesModel("HNL : " + df.format(it.response.rates.HNL)))
                dataList.add(CurrencyRatesModel("HRK : " + df.format(it.response.rates.HRK)))
                dataList.add(CurrencyRatesModel("HTG : " + df.format(it.response.rates.HTG)))
                dataList.add(CurrencyRatesModel("HUF : " + df.format(it.response.rates.HUF)))
                 dataList.add(CurrencyRatesModel("IDR : " + df.format(it.response.rates.IDR)))
                dataList.add(CurrencyRatesModel("IEP : " + df.format(it.response.rates.IEP)))
                dataList.add(CurrencyRatesModel("ILS : " + df.format(it.response.rates.ILS)))

               dataList.add(CurrencyRatesModel("JEP : " + df.format(it.response.rates.JEP)))
                dataList.add(CurrencyRatesModel("JMD : " + df.format(it.response.rates.JMD)))
                dataList.add(CurrencyRatesModel("JOD : " + df.format(it.response.rates.JOD)))
                dataList.add(CurrencyRatesModel("KGS : " + df.format(it.response.rates.KGS)))
                dataList.add(CurrencyRatesModel("KHR : " + df.format(it.response.rates.KHR)))
                 dataList.add(CurrencyRatesModel("KMF : " +df.format( it.response.rates.KMF)))
                dataList.add(CurrencyRatesModel("KPW : " + df.format(it.response.rates.KPW)))
                dataList.add(CurrencyRatesModel("KRW : " + df.format(it.response.rates.KRW)))
                dataList.add(CurrencyRatesModel("KWD : " + df.format(it.response.rates.KWD)))
                  dataList.add(CurrencyRatesModel("KYD : " + df.format(it.response.rates.KYD)))
                  dataList.add(CurrencyRatesModel("KZT : " + df.format(it.response.rates.KZT)))

                dataList.add(CurrencyRatesModel("LAK : " + df.format(it.response.rates.LAK)))
                dataList.add(CurrencyRatesModel("LBP : " + df.format(it.response.rates.LBP)))
                 dataList.add(CurrencyRatesModel("LINK : " + df.format(it.response.rates.LINK)))
                dataList.add(CurrencyRatesModel("LKR : " + df.format(it.response.rates.LKR)))
                dataList.add(CurrencyRatesModel("LRD : " + df.format(it.response.rates.LRD)))
                dataList.add(CurrencyRatesModel("LSL : " + df.format(it.response.rates.LSL)))
                dataList.add(CurrencyRatesModel("LTC : " + df.format(it.response.rates.LTC)))
                dataList.add(CurrencyRatesModel("LTL : " + df.format(it.response.rates.LTL)))
                dataList.add(CurrencyRatesModel("LUF : " + df.format(it.response.rates.LUF)))
                dataList.add(CurrencyRatesModel("LUNA : " + df.format(it.response.rates.LUNA)))
                 dataList.add(CurrencyRatesModel("LVL : " + df.format(it.response.rates.LVL)))
                dataList.add(CurrencyRatesModel("LYD : " + df.format(it.response.rates.LYD)))

                /*   dataList.add(CurrencyRatesModel("MAD : " + it.response.rates.MAD.toString()))
                 dataList.add(CurrencyRatesModel("MDL : " + it.response.rates.MDL.toString()))
                 dataList.add(CurrencyRatesModel("MGA : " + it.response.rates.MGA.toString()))
                 dataList.add(CurrencyRatesModel("MGF : " + it.response.rates.MGF.toString()))
                 dataList.add(CurrencyRatesModel("MKD : " + it.response.rates.MKD.toString()))
                 dataList.add(CurrencyRatesModel("MMK : " + it.response.rates.MMK.toString()))
                 dataList.add(CurrencyRatesModel("MNT : " + it.response.rates.MNT.toString()))
                 dataList.add(CurrencyRatesModel("MOP : " + it.response.rates.MOP.toString()))
                 dataList.add(CurrencyRatesModel("MRO : " + it.response.rates.MRO.toString()))
                 dataList.add(CurrencyRatesModel("MRU : " + it.response.rates.MRU.toString()))
                 dataList.add(CurrencyRatesModel("MTL : " + it.response.rates.MTL.toString()))
                 dataList.add(CurrencyRatesModel("MUR : " + it.response.rates.MUR.toString()))
                 dataList.add(CurrencyRatesModel("MVR : " + it.response.rates.MVR.toString()))
                 dataList.add(CurrencyRatesModel("MWK : " + it.response.rates.MWK.toString()))
                 dataList.add(CurrencyRatesModel("MXN : " + it.response.rates.MXN.toString()))
                 dataList.add(CurrencyRatesModel("MXV : " + it.response.rates.MXV.toString()))
                 dataList.add(CurrencyRatesModel("MYR : " + it.response.rates.MYR.toString()))
                 dataList.add(CurrencyRatesModel("MZM : " + it.response.rates.MZM.toString()))
*/

            dataList.add(CurrencyRatesModel("NAD : " + df.format(it.response.rates.NAD)))
               dataList.add(CurrencyRatesModel("NGN : " + df.format(it.response.rates.NGN)))
               dataList.add(CurrencyRatesModel("NIO : " + df.format(it.response.rates.NIO)))
               dataList.add(CurrencyRatesModel("NLG : " + df.format(it.response.rates.NLG)))
               dataList.add(CurrencyRatesModel("NOK : " + df.format(it.response.rates.NOK)))
               dataList.add(CurrencyRatesModel("NPR : " + df.format(it.response.rates.NPR)))
               dataList.add(CurrencyRatesModel("NZD : " + df.format(it.response.rates.NZD)))

    /*dataList.add(CurrencyRatesModel("OMR : " + it.response.rates.OMR.toString()))
               dataList.add(CurrencyRatesModel("PAB : " + it.response.rates.PAB.toString()))
               dataList.add(CurrencyRatesModel("PEN : " + it.response.rates.PEN.toString()))
               dataList.add(CurrencyRatesModel("PGK : " + it.response.rates.PGK.toString()))
               dataList.add(CurrencyRatesModel("PHP : " + it.response.rates.PHP.toString()))
               dataList.add(CurrencyRatesModel("PKR : " + it.response.rates.PKR.toString()))
               dataList.add(CurrencyRatesModel("PLN : " + it.response.rates.PLN.toString()))
                dataList.add(CurrencyRatesModel("PTE : " + it.response.rates.PTE.toString()))
               dataList.add(CurrencyRatesModel("PYG : " + it.response.rates.PYG.toString()))

               dataList.add(CurrencyRatesModel("QAR : " + it.response.rates.QAR.toString()))*/

              /* dataList.add(CurrencyRatesModel("ROL : " + it.response.rates.ROL.toString()))
               dataList.add(CurrencyRatesModel("RON : " + it.response.rates.RON.toString()))
               dataList.add(CurrencyRatesModel("RSD : " + it.response.rates.RSD.toString()))
               dataList.add(CurrencyRatesModel("RUB : " + it.response.rates.RUB.toString()))
                dataList.add(CurrencyRatesModel("RWF : " + it.response.rates.RWF.toString()))
*/
             /*  dataList.add(CurrencyRatesModel("SAR : " + it.response.rates.SAR.toString()))
               dataList.add(CurrencyRatesModel("SBD : " + it.response.rates.SBD.toString()))
               dataList.add(CurrencyRatesModel("SCR : " + it.response.rates.SCR.toString()))
                dataList.add(CurrencyRatesModel("SDD : " + it.response.rates.SDD.toString()))
               dataList.add(CurrencyRatesModel("SEK : " + it.response.rates.SEK.toString()))
               dataList.add(CurrencyRatesModel("SGD : " + it.response.rates.SGD.toString()))
               dataList.add(CurrencyRatesModel("SHP : " + it.response.rates.SHP.toString()))
                dataList.add(CurrencyRatesModel("SIT : " + it.response.rates.SIT.toString()))
               dataList.add(CurrencyRatesModel("SKK : " + it.response.rates.SKK.toString()))
               dataList.add(CurrencyRatesModel("SLE : " + it.response.rates.SLE.toString()))
                dataList.add(CurrencyRatesModel("SLL : " + it.response.rates.SLL.toString()))
               dataList.add(CurrencyRatesModel("SEK : " + it.response.rates.SEK.toString()))
               dataList.add(CurrencyRatesModel("SOS : " + it.response.rates.SOS.toString()))
               dataList.add(CurrencyRatesModel("SPL : " + it.response.rates.SPL.toString()))

                dataList.add(CurrencyRatesModel("SRD : " + it.response.rates.SRD.toString()))
               dataList.add(CurrencyRatesModel("SRG : " + it.response.rates.SRG.toString()))
               dataList.add(CurrencyRatesModel("STD : " + it.response.rates.STD.toString()))
                dataList.add(CurrencyRatesModel("STN : " + it.response.rates.STN.toString()))
               dataList.add(CurrencyRatesModel("SVC : " + it.response.rates.SVC.toString()))
               dataList.add(CurrencyRatesModel("SYP : " + it.response.rates.SYP.toString()))
               dataList.add(CurrencyRatesModel("SZL : " + it.response.rates.SZL.toString()))*/

            /* dataList.add(CurrencyRatesModel("THB : " + it.response.rates.THB.toString()))
               dataList.add(CurrencyRatesModel("TJS : " + it.response.rates.TJS.toString()))
               dataList.add(CurrencyRatesModel("TMM " + it.response.rates.TMM.toString()))
                dataList.add(CurrencyRatesModel("TMT : " + it.response.rates.TMT.toString()))
               dataList.add(CurrencyRatesModel("TND : " + it.response.rates.TND.toString()))
               dataList.add(CurrencyRatesModel("TOP : " + it.response.rates.TOP.toString()))
               dataList.add(CurrencyRatesModel("TRL : " + it.response.rates.TRL.toString()))
                dataList.add(CurrencyRatesModel("TRY : " + it.response.rates.TRY.toString()))
               dataList.add(CurrencyRatesModel("TTD : " + it.response.rates.TTD.toString()))
               dataList.add(CurrencyRatesModel("TVD " + it.response.rates.TVD.toString()))
                dataList.add(CurrencyRatesModel("TWD : " + it.response.rates.TWD.toString()))
               dataList.add(CurrencyRatesModel("TZS : " + it.response.rates.TZS.toString()))

*/
               dataList.add(CurrencyRatesModel("UAH : " + df.format(it.response.rates.UAH)))
               dataList.add(CurrencyRatesModel("UGX : " + df.format(it.response.rates.UGX)))
             dataList.add(CurrencyRatesModel("UNI : " + df.format(it.response.rates.UNI)))
               dataList.add(CurrencyRatesModel("USD : " +df.format(it.response.rates.USD)))
                dataList.add(CurrencyRatesModel("UYU : " + df.format(it.response.rates.UYU)))
               dataList.add(CurrencyRatesModel("UZS : " +df.format( it.response.rates.UZS)))

                /*   dataList.add(CurrencyRatesModel("VAL : " + it.response.rates.VAL.toString()))
                   dataList.add(CurrencyRatesModel("VEB : " + it.response.rates.VEB.toString()))
                 dataList.add(CurrencyRatesModel("VED : " + it.response.rates.VED.toString()))
                   dataList.add(CurrencyRatesModel("VEF : " + it.response.rates.VEF.toString()))
                 dataList.add(CurrencyRatesModel("VES : " + it.response.rates.VES.toString()))
                   dataList.add(CurrencyRatesModel("VND : " + it.response.rates.VND.toString()))
                dataList.add(CurrencyRatesModel("VUV : " + it.response.rates.VUV.toString()))*/

                      dataList.add(CurrencyRatesModel("WST : " + df.format(it.response.rates.WST)))

                   dataList.add(CurrencyRatesModel("XAF : " + df.format(it.response.rates.XAF)))
                   dataList.add(CurrencyRatesModel("XAG : " + df.format(it.response.rates.XAG)))
                /* dataList.add(CurrencyRatesModel("XAU : " + it.response.rates.XAU.toString()))

                 dataList.add(CurrencyRatesModel("BTC : " + it.response.rates.BTC.toString()))

                   dataList.add(CurrencyRatesModel("XBT : " + it.response.rates.XBT.toString()))
                     dataList.add(CurrencyRatesModel("XCD : " + it.response.rates.XCD.toString()))
                    dataList.add(CurrencyRatesModel("XDR : " + it.response.rates.XDR.toString()))
                   dataList.add(CurrencyRatesModel("XLM : " + it.response.rates.XLM.toString()))
                   dataList.add(CurrencyRatesModel("XOF : " + it.response.rates.XOF.toString()))
                    dataList.add(CurrencyRatesModel("XPD : " + it.response.rates.XPD.toString()))
                   dataList.add(CurrencyRatesModel("XPF : " + it.response.rates.XPF.toString()))
                   dataList.add(CurrencyRatesModel("XRP : " + it.response.rates.XRP.toString()))*/


                /*        dataList.add(CurrencyRatesModel("YER : " + it.response.rates.YER.toString()))
                        dataList.add(CurrencyRatesModel("ZAR : " + it.response.rates.ZAR.toString()))
       dataList.add(CurrencyRatesModel("ZMK : " + it.response.rates.ZMK.toString()))
      dataList.add(CurrencyRatesModel("ZMW : " + it.response.rates.ZMW.toString()))
      dataList.add(CurrencyRatesModel("ZWD : " + it.response.rates.ZWD.toString()))*/



                //storing the data in ROOM DB


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
                    Log.e("chouiuy", i.conversion_list)

                    dataList.add(CurrencyRatesModel( i.conversion_list))
                    currencyRatesAdapter.setCurrencyList(dataList)
                    currencyRatesAdapter.notifyDataSetChanged()
                }
                basecurrency_tv.text= it[0].base_currency

            }
        })

    }


}