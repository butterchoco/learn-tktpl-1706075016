package id.ac.ui.mobprog.supri.tugas1

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserChoiceViewModel : ViewModel() {
    var userChoiceList = mutableListOf<String>("Partner", "Customers")
    private var userChoiceData = MutableLiveData<String>();

    fun getUserChoiceData(): LiveData<String> {
        return userChoiceData
    }

    fun setUserChoiceData(data: String) {
        userChoiceData.setValue(data)
    }
}