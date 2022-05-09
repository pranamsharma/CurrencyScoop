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
import kotlinx.android.synthetic.main.activity_currency_list.*

class CurrencyListActivity : AppCompatActivity() {
    lateinit var currencyListAdapter:CurrencyListAdapter


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
    }

    private fun initRecyclerview(){
        currencyListRecyclerView.layoutManager=LinearLayoutManager(this)
        currencyListAdapter= CurrencyListAdapter(this)
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
                dataList.add(CurrencyModel(it.response.fiats.AED.currency_name,
                    it.response.fiats.AED.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.AFN.currency_name,
                    it.response.fiats.AFN.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.ALL.currency_name,
                    it.response.fiats.ALL.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.AMD.currency_name,
                    it.response.fiats.AMD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.ANG.currency_name,
                    it.response.fiats.ANG.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.AOA.currency_name,
                    it.response.fiats.AOA.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.ARS.currency_name,
                    it.response.fiats.ARS.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.AUD.currency_name,
                    it.response.fiats.AUD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.AWG.currency_name,
                    it.response.fiats.AWG.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.AZN.currency_name,
                    it.response.fiats.AZN.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.BAM.currency_name,
                    it.response.fiats.BAM.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.BBD.currency_name,
                    it.response.fiats.BBD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.BDT.currency_name,
                    it.response.fiats.BDT.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.BGN.currency_name,
                    it.response.fiats.BGN.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.BHD.currency_name,
                    it.response.fiats.BHD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.BIF.currency_name,
                    it.response.fiats.BIF.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.BMD.currency_name,
                    it.response.fiats.BMD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.BND.currency_name,
                    it.response.fiats.BND.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.BOB.currency_name,
                    it.response.fiats.BOB.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.BOV.currency_name,
                    it.response.fiats.BOV.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.BRL.currency_name,
                    it.response.fiats.BRL.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.BSD.currency_name,
                    it.response.fiats.BSD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.BTN.currency_name,
                    it.response.fiats.BTN.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.BWP.currency_name,
                    it.response.fiats.BWP.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.BZD.currency_name,
                    it.response.fiats.BZD.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.CAD.currency_name,
                    it.response.fiats.CAD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.CDF.currency_name,
                    it.response.fiats.CDF.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.CHE.currency_name,
                    it.response.fiats.CHE.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.CHW.currency_name,
                    it.response.fiats.CHW.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.CLF.currency_name,
                    it.response.fiats.CLF.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.CLP.currency_name,
                    it.response.fiats.CLP.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.CNY.currency_name,
                    it.response.fiats.CNY.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.COP.currency_name,
                    it.response.fiats.COP.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.COU.currency_name,
                    it.response.fiats.COU.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.CRC.currency_name,
                    it.response.fiats.CRC.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.CUC.currency_name,
                    it.response.fiats.CUC.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.CUP.currency_name,
                    it.response.fiats.CUP.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.CVE.currency_name,
                    it.response.fiats.CVE.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.CZK.currency_name,
                    it.response.fiats.CZK.currency_code))


                dataList.add(CurrencyModel(it.response.fiats.DJF.currency_name,
                    it.response.fiats.DJF.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.DKK.currency_name,
                    it.response.fiats.DKK.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.DOP.currency_name,
                    it.response.fiats.DOP.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.DZD.currency_name,
                    it.response.fiats.DZD.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.EGP.currency_name,
                    it.response.fiats.EGP.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.ERN.currency_name,
                    it.response.fiats.ERN.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.ETB.currency_name,
                    it.response.fiats.ETB.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.EUR.currency_name,
                    it.response.fiats.EUR.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.FJD.currency_name,
                    it.response.fiats.FKP.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.FKP.currency_name,
                    it.response.fiats.CRC.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.GBP.currency_name,
                    it.response.fiats.GBP.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.GEL.currency_name,
                    it.response.fiats.GEL.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.GHS.currency_name,
                    it.response.fiats.GHS.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.GIP.currency_name,
                    it.response.fiats.GIP.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.GMD.currency_name,
                    it.response.fiats.GMD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.GNF.currency_name,
                    it.response.fiats.GNF.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.GTQ.currency_name,
                    it.response.fiats.GTQ.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.GYD.currency_name,
                    it.response.fiats.GYD.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.HKD.currency_name,
                    it.response.fiats.HKD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.HNL.currency_name,
                    it.response.fiats.HNL.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.HRK.currency_name,
                    it.response.fiats.HRK.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.HTG.currency_name,
                    it.response.fiats.HTG.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.HUF.currency_name,
                    it.response.fiats.HUF.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.IDR.currency_name,
                    it.response.fiats.IDR.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.ILS.currency_name,
                    it.response.fiats.ILS.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.INR.currency_name,
                    it.response.fiats.INR.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.IQD.currency_name,
                    it.response.fiats.IQD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.IRR.currency_name,
                    it.response.fiats.IRR.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.ISK.currency_name,
                    it.response.fiats.ISK.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.JMD.currency_name,
                    it.response.fiats.JMD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.JOD.currency_name,
                    it.response.fiats.JOD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.JPY.currency_name,
                    it.response.fiats.JPY.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.KES.currency_name,
                    it.response.fiats.KES.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.KGS.currency_name,
                    it.response.fiats.KGS.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.KHR.currency_name,
                    it.response.fiats.KHR.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.KMF.currency_name,
                    it.response.fiats.KMF.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.KPW.currency_name,
                    it.response.fiats.KPW.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.KRW.currency_name,
                    it.response.fiats.KRW.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.KWD.currency_name,
                    it.response.fiats.KWD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.KYD.currency_name,
                    it.response.fiats.KYD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.KZT.currency_name,
                    it.response.fiats.KZT.currency_code))


                dataList.add(CurrencyModel(it.response.fiats.LAK.currency_name,
                    it.response.fiats.LAK.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.LBP.currency_name,
                    it.response.fiats.LBP.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.LKR.currency_name,
                    it.response.fiats.LKR.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.LRD.currency_name,
                    it.response.fiats.LRD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.LSL.currency_name,
                    it.response.fiats.LSL.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.LYD.currency_name,
                    it.response.fiats.LYD.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.MAD.currency_name,
                    it.response.fiats.MAD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.MDL.currency_name,
                    it.response.fiats.MDL.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.MGA.currency_name,
                    it.response.fiats.MGA.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.MKD.currency_name,
                    it.response.fiats.MKD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.MMK.currency_name,
                    it.response.fiats.MMK.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.MNT.currency_name,
                    it.response.fiats.MNT.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.MOP.currency_name,
                    it.response.fiats.MOP.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.MRU.currency_name,
                    it.response.fiats.MRU.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.MUR.currency_name,
                    it.response.fiats.MUR.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.MVR.currency_name,
                    it.response.fiats.MVR.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.MWK.currency_name,
                    it.response.fiats.MWK.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.MXN.currency_name,
                    it.response.fiats.MXN.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.MXV.currency_name,
                    it.response.fiats.MXV.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.MYR.currency_name,
                    it.response.fiats.MYR.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.MZN.currency_name,
                    it.response.fiats.MZN.currency_code))


                dataList.add(CurrencyModel(it.response.fiats.NAD.currency_name,
                    it.response.fiats.NAD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.NGN.currency_name,
                    it.response.fiats.NGN.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.NIO.currency_name,
                    it.response.fiats.NIO.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.NOK.currency_name,
                    it.response.fiats.NOK.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.NPR.currency_name,
                    it.response.fiats.NPR.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.NZD.currency_name,
                    it.response.fiats.NZD.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.OMR.currency_name,
                    it.response.fiats.OMR.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.PAB.currency_name,
                    it.response.fiats.PAB.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.PEN.currency_name,
                    it.response.fiats.PEN.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.PGK.currency_name,
                    it.response.fiats.PGK.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.PHP.currency_name,
                    it.response.fiats.PHP.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.PKR.currency_name,
                    it.response.fiats.PKR.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.PLN.currency_name,
                    it.response.fiats.PLN.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.PYG.currency_name,
                    it.response.fiats.PYG.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.QAR.currency_name,
                    it.response.fiats.QAR.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.RON.currency_name,
                    it.response.fiats.RON.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.RSD.currency_name,
                    it.response.fiats.RSD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.RUB.currency_name,
                    it.response.fiats.RUB.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.RWF.currency_name,
                    it.response.fiats.RWF.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.SAR.currency_name,
                    it.response.fiats.SAR.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.SBD.currency_name,
                    it.response.fiats.SBD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.SCR.currency_name,
                    it.response.fiats.SCR.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.SDG.currency_name,
                    it.response.fiats.SDG.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.SEK.currency_name,
                    it.response.fiats.SEK.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.SGD.currency_name,
                    it.response.fiats.SGD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.SHP.currency_name,
                    it.response.fiats.SHP.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.SLL.currency_name,
                    it.response.fiats.SLL.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.SOS.currency_name,
                    it.response.fiats.SOS.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.SRD.currency_name,
                    it.response.fiats.SRD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.SSP.currency_name,
                    it.response.fiats.SSP.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.STN.currency_name,
                    it.response.fiats.STN.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.SVC.currency_name,
                    it.response.fiats.SVC.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.SZL.currency_name,
                    it.response.fiats.SZL.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.THB.currency_name,
                    it.response.fiats.THB.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.TJS.currency_name,
                    it.response.fiats.TJS.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.TMT.currency_name,
                    it.response.fiats.TMT.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.TND.currency_name,
                    it.response.fiats.TND.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.TOP.currency_name,
                    it.response.fiats.TOP.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.TRY.currency_name,
                    it.response.fiats.TRY.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.TTD.currency_name,
                    it.response.fiats.TTD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.TWD.currency_name,
                    it.response.fiats.TWD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.TZS.currency_name,
                    it.response.fiats.TZS.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.UAH.currency_name,
                    it.response.fiats.UAH.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.UGX.currency_name,
                    it.response.fiats.UGX.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.USD.currency_name,
                    it.response.fiats.USD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.USN.currency_name,
                    it.response.fiats.USN.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.UYI.currency_name,
                    it.response.fiats.UYI.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.UYU.currency_name,
                    it.response.fiats.UYU.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.UYW.currency_name,
                    it.response.fiats.UYW.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.UZS.currency_name,
                    it.response.fiats.UZS.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.VES.currency_name,
                    it.response.fiats.VES.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.VND.currency_name,
                    it.response.fiats.VND.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.VUV.currency_name,
                    it.response.fiats.VUV.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.WST.currency_name,
                    it.response.fiats.WST.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.XAF.currency_name,
                    it.response.fiats.XAF.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.XAG.currency_name,
                    it.response.fiats.XAG.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.XAU.currency_name,
                    it.response.fiats.XAU.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.XBA.currency_name,
                    it.response.fiats.XBA.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.XBB.currency_name,
                    it.response.fiats.XBB.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.XBC.currency_name,
                    it.response.fiats.XBC.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.XBD.currency_name,
                    it.response.fiats.XBD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.XCD.currency_name,
                    it.response.fiats.XCD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.XDR.currency_name,
                    it.response.fiats.XDR.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.XOF.currency_name,
                    it.response.fiats.XOF.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.XPD.currency_name,
                    it.response.fiats.XPD.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.XPF.currency_name,
                    it.response.fiats.XPF.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.XPT.currency_name,
                    it.response.fiats.XPT.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.XSU.currency_name,
                    it.response.fiats.XSU.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.XTS.currency_name,
                    it.response.fiats.XTS.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.XUA.currency_name,
                    it.response.fiats.XUA.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.XXX.currency_name,
                    it.response.fiats.XXX.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.YER.currency_name,
                    it.response.fiats.YER.currency_code))

                dataList.add(CurrencyModel(it.response.fiats.ZAR.currency_name,
                    it.response.fiats.ZAR.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.ZMW.currency_name,
                    it.response.fiats.ZMW.currency_code))
                dataList.add(CurrencyModel(it.response.fiats.ZWL.currency_name,
                    it.response.fiats.ZWL.currency_code))

                currencyListAdapter.setCurrencyList(dataList)
                currencyListAdapter.notifyDataSetChanged()
            } else {

                progress_bar.visibility = View.GONE
            }
        }
        viewModel.makeApiCall(this,viewModel)
    }
}