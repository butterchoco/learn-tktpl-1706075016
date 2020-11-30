package id.ac.ui.cs.mobileprogramming.ahmadsupriyanto.tugas1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.os.Bundle
import android.util.Log
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import id.ac.ui.cs.mobileprogramming.ahmadsupriyanto.tugas1.model.WifiConnection
import id.ac.ui.cs.mobileprogramming.ahmadsupriyanto.tugas1.model.WifiConnectionData

class WifiActivity : AppCompatActivity() {

    lateinit var wifi: WifiManager
    val wifiScanReceiver = object : BroadcastReceiver() {
      override fun onReceive(context: Context, intent: Intent) {
          val result: List<ScanResult> = wifi.scanResults
          val toastText = String.format("%s connection found.", result.size)
          Toast.makeText(applicationContext, toastText, Toast.LENGTH_LONG).show()
          postWifiConnection(result)
          WifiConnection.setITEMS(result)
          supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<WifiConnectionFragment>(R.id.fragment_container)
        }
      }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)

        val service = Context.WIFI_SERVICE;
        wifi = getSystemService(service) as WifiManager
        val intentFilter = IntentFilter()
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)
        applicationContext.registerReceiver(wifiScanReceiver, intentFilter)

        if (!wifi.isWifiEnabled) {
            if (wifi.wifiState != WifiManager.WIFI_STATE_ENABLING)
                    wifi.setWifiEnabled(true)
        }
        wifi.startScan()

        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            wifi.startScan()
            Snackbar.make(findViewById(R.id.coordinator), "Scanning available wifi...", Snackbar.LENGTH_LONG).show()
        }

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<WifiConnectionFragment>(R.id.fragment_container)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun postWifiConnection(result: List<ScanResult>) {
        val apiManager = ApiManager()
        val wifiConnectionData = WifiConnectionData(result)
        apiManager.addWifiConnection(wifiConnectionData) {
            if (it["isSuccess"]!!) {
                Toast.makeText(applicationContext, "Wifi connection uploaded", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, "Failed to upload wifi connection", Toast.LENGTH_LONG).show()
            }
        }
    }

}