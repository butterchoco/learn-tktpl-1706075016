package id.ac.ui.mobprog.supri.tugas1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            showUserChoiceFragment()
        }
    }

    fun showUserDetailsFragment() {
		var fragment = UserDetailFragment();
		supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
	}

    fun showUserChoiceFragment() {
		var fragment = UserChoiceFragment();
		supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
	}
}
