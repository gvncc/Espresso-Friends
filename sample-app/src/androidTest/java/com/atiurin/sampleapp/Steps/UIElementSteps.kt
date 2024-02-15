package com.atiurin.sampleapp.Steps

import android.view.View
import android.widget.RadioButton
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.atiurin.ultron.extensions.click
import org.hamcrest.Matcher
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import com.atiurin.sampleapp.Steps.UIElementSteps.assertIsLoaded
import com.atiurin.ultron.extensions.typeText

object UIElementSteps {

    fun Matcher<View>.assertIsLoaded(): Boolean {
        return try {
            onView(this).check(ViewAssertions.matches(isDisplayed()))
            true
        } catch (_: Exception) {
            false
        }
    }

    fun Matcher<View>.clickOnItem() {
        onView(this).click()
    }

    fun Matcher<View>.assertText(addressee: String) {
        onView(this).check(ViewAssertions.matches(withText(addressee)))
    }

    fun Matcher<View>.sendText(sentText: String) {
        onView(this).typeText(sentText)
    }

    fun Matcher<View>.dropDownOption(positionNbr: Int) {
        onData(this).atPosition(positionNbr).click()
    }

    fun Matcher<View>.getCheckboxState(): Boolean {
            var isChecked = false
            onView(this).perform(object : ViewAction {
                override fun getConstraints(): Matcher<View> {
                    return isAssignableFrom(RadioButton::class.java)
                }

                override fun getDescription(): String {
                    return "checkbox state"
                }

                override fun perform(uiController: UiController, view: View) {
                    val tv = view as RadioButton
                    isChecked = tv.isChecked
                }
            })
        return isChecked

    }

    fun Matcher<View>.checkCheckboxState(){
        assert(getCheckboxState())
    }

}