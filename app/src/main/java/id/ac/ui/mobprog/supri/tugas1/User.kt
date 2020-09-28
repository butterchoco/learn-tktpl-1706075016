package id.ac.ui.mobprog.supri.tugas1

import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class User(var name: String, var phone: String, var address: String) {

    fun updateProfile(name_display: TextView, address_display: TextView, phone_display: TextView): User {
        name_display.text = name
        address_display.text = address
        phone_display.text = phone
        return this
    }
}
