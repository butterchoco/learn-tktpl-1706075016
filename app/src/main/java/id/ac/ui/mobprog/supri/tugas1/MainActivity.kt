package id.ac.ui.mobprog.supri.tugas1

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    private var miliseconds = 0
    private var isStopWatchRunning = false
    private val LOG_APP = "tugas1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(LOG_APP, "onCreate")

        runTimer()
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Log.d(LOG_APP, "onSaveInstanceState")
        outState.putInt("miliseconds", miliseconds)
        outState.putBoolean("isStopWatchRunning", isStopWatchRunning)
    }

    public override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(LOG_APP, "onRestoreInstanceState")
        miliseconds = savedInstanceState.getInt("miliseconds")
        isStopWatchRunning = savedInstanceState.getBoolean("isStopWatchRunning")
    }

    override fun onBackPressed() {
        Toast.makeText(
            applicationContext,
            "Tap the 'EXIT' button to exit the app.",
            Toast.LENGTH_SHORT
        ).show()
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

    fun onClickStart(view: View?) {
        isStopWatchRunning = true
    }

    fun onClickStop(view: View?) {
        isStopWatchRunning = false
    }

    fun onClickReset(view: View?) {
        isStopWatchRunning = false
        miliseconds = 0
    }

    private fun runTimer() {
        val timeView = findViewById<TextView>(R.id.time_view)
        val handler = Handler()
        handler.post(object : Runnable {
            override fun run() {
                val milisecs = miliseconds % 100
                val secs = (miliseconds / 100) % 60
				val minutes = (miliseconds / 6000) % 60;
                val hours = miliseconds / 360000;

                val time = String.format(
                    Locale.getDefault(),
                    "%d:%02d:%02d.%02d", hours, minutes, secs, milisecs
                )

                timeView.text = time
                if (isStopWatchRunning) {
                    miliseconds++
                }
                handler.postDelayed(this, 10)
            }
        })
    }

    fun onClickExit(view: View?) {
        finish()
    }
}