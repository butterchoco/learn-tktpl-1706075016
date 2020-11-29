package id.ac.ui.cs.mobileprogramming.ahmadsupriyanto.tugas1.model

import android.net.wifi.ScanResult
import java.util.ArrayList
import java.util.HashMap

object WifiConnection {

    val ITEMS: MutableList<ScanResult> = ArrayList()

    fun addItem(item: ScanResult) {
        ITEMS.add(item)
    }

    fun setITEMS(list: List<ScanResult>) {
        ITEMS.clear()
        list.forEach { data ->
            addItem(data)
        }
    }

}