package id.ac.ui.cs.mobileprogramming.ahmadsupriyanto.tugas1.model

import android.net.wifi.ScanResult
import com.google.gson.annotations.SerializedName

data class WifiConnectionData(
    @SerializedName("wifi_connection") val wifiConnection: List<ScanResult>
)