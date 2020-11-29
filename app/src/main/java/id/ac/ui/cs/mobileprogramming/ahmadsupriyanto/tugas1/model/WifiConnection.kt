package id.ac.ui.cs.mobileprogramming.ahmadsupriyanto.tugas1.model

import java.util.ArrayList
import java.util.HashMap

object WifiConnection {

    val ITEMS: MutableList<WifiConnectionItem> = ArrayList()

    private fun addItem(item: WifiConnectionItem) {
        ITEMS.add(item)
    }

    private fun createWifiConnectionItem(position: Int): WifiConnectionItem {
        return WifiConnectionItem(position.toString(), "Item " + position)
    }

    data class WifiConnectionItem(val id: String, val content: String) {
        override fun toString(): String = content
    }
}