package com.atiurin.sampleapp.Steps

import android.view.View
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import com.atiurin.sampleapp.helper.*
import com.atiurin.sampleapp.pages.UIElementPage.bottomCenter
import com.atiurin.sampleapp.pages.UIElementPage.bottomLeft
import com.atiurin.sampleapp.pages.UIElementPage.bottomRight
import com.atiurin.sampleapp.pages.UIElementPage.centerLeft
import com.atiurin.sampleapp.pages.UIElementPage.centerRight
import com.atiurin.sampleapp.pages.UIElementPage.topCenter
import com.atiurin.sampleapp.pages.UIElementPage.topLeft
import com.atiurin.sampleapp.pages.UIElementPage.topRight
import com.atiurin.ultron.extensions.click
import com.atiurin.ultron.extensions.typeText
import org.hamcrest.Matcher


object UIElementSteps {

    fun Matcher<View>.assertIsLoaded(): Boolean {
        return try {
            onView(this).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            true
        } catch (_: Exception) {
            false
        }
    }

    private var device: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    fun clRecurringOrderWithIndex(index: Int): UiObject = device.findObject(UiSelector().resourceId("com.atiurin.sampleapp:id/message_text").instance(index))

    fun Matcher<View>.clickOnItem() {
        onView(this).click()
    }

    fun Matcher<View>.assertText(addressee: String) {
        onView(this).check(ViewAssertions.matches(withText(addressee)))
    }
    fun Matcher<View>.sendText(sentText: String) {
        onView(this).typeText(sentText)
    }

    fun clickAllRadioButtons(){
        val elements: Array<Matcher<View>> =  arrayOf(topLeft, topCenter, topRight, centerLeft, centerRight, bottomLeft, bottomCenter, bottomRight)
        for (i: Int in 0..7 step 1){
            onView(elements[i]).click()
            onView(elements[i]).tap()
        }
    }

    fun checkIfAllRadioButtonsIsSelected(){
        val elements: Array<Matcher<View>> =  arrayOf(topLeft, topCenter, topRight, centerLeft, centerRight, bottomLeft, bottomCenter, bottomRight)
        for (i: Int in 0..7 step 1){
            onView(elements[i]).check(matches(isChecked()))
            onView(elements[i]).tap()
        }
    }

}