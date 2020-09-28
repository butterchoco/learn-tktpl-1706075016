package id.ac.ui.mobprog.supri.tugas1

import java.util.*
import kotlin.collections.ArrayList

object RegistrationUtil {

    private val adminUser = User("admin", "000000", "Jl. Haji")
    private lateinit var user: User
    private var users:MutableList<User> = mutableListOf<User>(adminUser)

    fun validateRegistration(
        name: String,
        phone: String,
        address: String
    ) : Boolean {
        if (name != ""
                && phone != ""
                && address != "") {
            user = User(name, phone, address)
            for(data in users) {
                 if (data.name == user.name) {
                     return false
                 }
            }
        } else {
            return false
        }
        return true
    }

    fun addUser(name: String, phone: String, address: String): User? {
        if (validateRegistration(name, phone, address)) {
            users.add(user)
            return user
        } else {
            return null
        }
    }
}