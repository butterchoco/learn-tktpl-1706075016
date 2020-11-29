package id.ac.ui.cs.mobileprogramming.ahmadsupriyanto.tugas1

import android.net.wifi.ScanResult
import id.ac.ui.cs.mobileprogramming.ahmadsupriyanto.tugas1.model.WifiConnectionData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ApiManager {
    fun addWifiConnection(wifiConnection: WifiConnectionData, onResult: (WifiConnectionData?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.addWifiConnection(wifiConnection).enqueue(
            object : Callback<WifiConnectionData> {
                override fun onFailure(call: Call<WifiConnectionData>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<WifiConnectionData>, response: Response<WifiConnectionData>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }
}