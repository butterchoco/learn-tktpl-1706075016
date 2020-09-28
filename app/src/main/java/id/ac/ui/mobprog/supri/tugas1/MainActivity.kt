package id.ac.ui.mobprog.supri.tugas1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        update_profile.setOnClickListener() {
            updateProfile()
        }
    }

    fun updateProfile() {
        val name = name_input.text.toString()
        val phone = phone_input.text.toString()
        val address = address_input.text.toString()
        val user = RegistrationUtil.addUser(name, phone, address)
        if (user !== null) {
            name_display.text = user.name
            phone_display.text = user.phone
            address_display.text = user.address
        }
    }
}
