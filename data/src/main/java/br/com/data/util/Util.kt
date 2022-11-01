package br.com.data.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import br.com.data.modelResultRetrofit.Image
import br.com.domain.entities.CatEntity

object Util {
    fun statusInternet(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }
    fun Image.toCatEntity() = CatEntity(
        image = link,
        type = type
    )
}