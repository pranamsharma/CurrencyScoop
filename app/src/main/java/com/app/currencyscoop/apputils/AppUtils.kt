package com.app.currencyscoop.apputils

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.ViewModel
import com.app.currencyscoop.viewmodel.CurrencyListViewModel
import com.app.currencyscoop.viewmodel.CurrencyRatesViewModel
import kotlin.system.exitProcess

object AppUtils {

    fun alertSimple(context: Activity,title:String)
    {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage(title)
            .setCancelable(false)
            .setPositiveButton("Ok", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
        // create dialog box
        val alert = dialogBuilder.create()
        alert.show()
    }

    fun alertError(context: Activity,title:String,viewModel: CurrencyListViewModel)
    {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage(title)
            .setCancelable(false)
            .setPositiveButton("Retry", DialogInterface.OnClickListener {
                    dialog, id ->viewModel.makeApiCall(context,viewModel)
            })
            // negative button text and action
            .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
        // create dialog box
        val alert = dialogBuilder.create()
        alert.show()
    }

    fun alertErrorCurrencyRates(base_currency:String,context: Activity,title:String,viewModel: CurrencyRatesViewModel)
    {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage(title)
            .setCancelable(false)
            .setPositiveButton("Retry", DialogInterface.OnClickListener {
                    dialog, id ->viewModel.makeApiCall(base_currency,context,viewModel)
            })
            // negative button text and action
            .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                    dialog, id -> exitProcess(0)
            })
        // create dialog box
        val alert = dialogBuilder.create()
        alert.show()
    }

    fun internetCheck(c: Context): Boolean {
        val cmg = c.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            // Android 10+
            cmg.getNetworkCapabilities(cmg.activeNetwork)?.let { networkCapabilities ->
                return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                        || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
            }
        } else {
            return cmg.activeNetworkInfo?.isConnectedOrConnecting == true
        }
        return false
    }
}