package com.atiurin.sampleapp.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.*
import com.atiurin.sampleapp.R
import org.hamcrest.CoreMatchers
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.containsString
import org.hamcrest.Matchers.instanceOf

object UIElementPage {

    val radioBtnInvisible: Matcher<View> by lazy { withId(R.id.invisible) }
    val radioBtnVisible: Matcher<View> by lazy { withText("VISIBLE") }
    val mainManuBtn: Matcher<View> by lazy { withClassName(CoreMatchers.`is`("android.widget.ImageButton")) }
    val nameChandler: Matcher<View> by lazy { Matchers.allOf(withId(R.id.tv_name), withText("Chandler Bing")) }
    val messageInputText: Matcher<View> by lazy { Matchers.allOf(withId(R.id.message_input_text), withText("Enter text")) }
    val textInput: Matcher<View> by lazy { Matchers.allOf(withId(R.id.message_input_text)) }
    val clearTextOption: Matcher<View> by lazy { withClassName(CoreMatchers.`is`("android.widget.ImageView")) }


    /**
     * first test case elements
     */
    val dashboard: Matcher<View> by lazy { withText("dashboard")}
    val chatItem: Matcher<View> by lazy { withId(899)}
    val contact: Matcher<View> by lazy { withText("Joey")}
    val contactDisplay: Matcher<View> by lazy { withId(5654)}
    val textField: Matcher<View> by lazy { withSubstring("set text value")}
    val enteredText: Matcher<View> by lazy { withHint("entered text")}

    /**
     * second test case elements
     */
    val mainMenu: Matcher<View> by lazy { withClassName(CoreMatchers.`is`("android.widget.mainMenu")) }
    val burgerMenu: Matcher<View> by lazy { withId(100100) }
    val options: Matcher<View> by lazy { withText("options") }
    val customClickOption: Matcher<View> by lazy { withSubstring("custom click")}
    val customClickPage: Matcher<View> by lazy { withHint("custom page")}
    val selectAllCornerCircles: Matcher<View> by lazy { withText("selectAll")}
    val cornerCirclesCheckboxes: Matcher<View> by lazy { withText("checkboxes")}

}