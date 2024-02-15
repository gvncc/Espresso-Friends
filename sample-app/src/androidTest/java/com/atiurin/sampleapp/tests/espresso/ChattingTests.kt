package com.atiurin.sampleapp.tests.espresso

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.atiurin.sampleapp.Steps.UIElementSteps.assertIsLoaded
import com.atiurin.sampleapp.Steps.UIElementSteps.assertText
import com.atiurin.sampleapp.Steps.UIElementSteps.checkCheckboxState
import com.atiurin.sampleapp.Steps.UIElementSteps.clickOnItem
import com.atiurin.sampleapp.Steps.UIElementSteps.dropDownOption
import com.atiurin.sampleapp.Steps.UIElementSteps.sendText
import com.atiurin.sampleapp.activity.MainActivity
import com.atiurin.sampleapp.helper.isTextOnScreen
import com.atiurin.sampleapp.helper.isViewDisplayed
import com.atiurin.sampleapp.helper.typeText
import com.atiurin.sampleapp.pages.UIElementPage
import com.atiurin.sampleapp.tests.BaseTest
import com.atiurin.ultron.extensions.tap
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ChattingTests: BaseTest() {

    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun textWithMyFriend() {
        with(UIElementPage) {
            isTextOnScreen("Friends")
            nameChandler.isViewDisplayed()
            nameChandler.tap()
            textInput.typeText("Hello Rachel")

            messageInputText.isViewDisplayed()

        }
    }

    @Test()
    fun chatWithFriend() {
        with(UIElementPage) {
            dashboard.assertIsLoaded()
            chatItem.clickOnItem()
            contact.clickOnItem()
            contactDisplay.assertText("Joey Tribbiani")
            textField.sendText("Hii Joe")
            enteredText.assertText("Hii Joe")
        }
    }

    @Test
    fun checkCustomPage() {
        with(UIElementPage) {
            dashboard.assertIsLoaded()
            mainMenu.clickOnItem()
            burgerMenu.clickOnItem()
            options.dropDownOption(1)
            customClickOption.clickOnItem()
            customClickPage.assertIsLoaded()
            selectAllCornerCircles.clickOnItem()
            cornerCirclesCheckboxes.checkCheckboxState()


        }
    }
}