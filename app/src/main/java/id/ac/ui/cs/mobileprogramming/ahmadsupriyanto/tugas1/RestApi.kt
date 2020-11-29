package id.ac.ui.cs.mobileprogramming.ahmadsupriyanto.tugas1

import id.ac.ui.cs.mobileprogramming.ahmadsupriyanto.tugas1.model.WifiConnectionData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RestApi {
    @Headers("Content-Type: application/json")
    @POST("users")
    fun addWifiConnection(@Body wifiConnection: WifiConnectionData): Call<WifiConnectionData>
}