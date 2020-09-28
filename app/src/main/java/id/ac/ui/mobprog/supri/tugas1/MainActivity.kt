package id.ac.ui.mobprog.supri.tugas1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var name: String = ""
    var address: String = ""
    var phone: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        update_profile.setOnClickListener() {
            var user: User = User(name, phone, address)
            user.updateProfile(name_display, address_display, phone_display)
        }
    }
}
