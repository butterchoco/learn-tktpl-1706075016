package id.ac.ui.mobprog.supri.tugas1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private val LOG_APP = "tugas1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_APP, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_APP, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_APP, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_APP, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_APP, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_APP, "onDestroy")
    }
}