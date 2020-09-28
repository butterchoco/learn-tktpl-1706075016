package id.ac.ui.mobprog.supri.tugas1

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class InstrumentedRegistrationUtilTest {
    @Rule
    var activityScenarioRule =
        ActivityScenarioRule(
            MainActivity::class.java
        )

    @Test
    fun updateProfileWhenProfileAdded() {
        onView(withId(R.id.name_input))
            .perform(typeText("Test"), closeSoftKeyboard());
        onView(withId(R.id.phone_input))
            .perform(typeText("0812312312"), closeSoftKeyboard());
        onView(withId(R.id.address_input))
            .perform(typeText("Jl. Jambu"), closeSoftKeyboard());

        onView(withId(R.id.update_profile)).perform(click());

        onView(withId(R.id.name_display)).check(
            matches(withText("Test"))
        );
        onView(withId(R.id.phone_display)).check(
            matches(withText("0812312312"))
        );
        onView(withId(R.id.address_display)).check(
            matches(withText("Jl. Jambu"))
        );

    }
}