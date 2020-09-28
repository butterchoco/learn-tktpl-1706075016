package id.ac.ui.mobprog.supri.tugas1

import org.junit.Assert.*
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun emptyUsernameReturnFalse() {
        val result = RegistrationUtil.validateRegistration(
            "",
            "0812354721",
            "Jl.Jambu 6"
        )

        assertEquals(false, result)
    }

    @Test
    fun existUsernameReturnFalse() {
        val result = RegistrationUtil.validateRegistration(
            "admin",
            "000000",
            "Jl. Haji"
        )

        assertEquals(false, result)
    }

    @Test
    fun registrationReturnTrue() {
        val result = RegistrationUtil.validateRegistration(
            "Test",
            "0812354721",
            "Jl.Jambu 6"
        )

        assertEquals(true, result)
    }
}