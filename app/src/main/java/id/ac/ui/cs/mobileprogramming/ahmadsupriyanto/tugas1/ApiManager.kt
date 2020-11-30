package id.ac.ui.cs.mobileprogramming.ahmadsupriyanto.tugas1

import android.widget.Toast
import id.ac.ui.cs.mobileprogramming.ahmadsupriyanto.tugas1.model.WifiConnectionData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiManager {
    fun addWifiConnection(wifiConnection: WifiConnectionData, onResult: (HashMap<String, Boolean>) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.addWifiConnection(wifiConnection).enqueue(
            object : Callback<WifiConnectionData> {
                override fun onFailure(call: Call<WifiConnectionData>, t: Throwable) {
                    onResult(hashMapOf("isSuccess" to false))
                }
                override fun onResponse( call: Call<WifiConnectionData>, response: Response<WifiConnectionData>) {
                    onResult(hashMapOf("isSuccess" to true))
                }
            }
        )
    }
}