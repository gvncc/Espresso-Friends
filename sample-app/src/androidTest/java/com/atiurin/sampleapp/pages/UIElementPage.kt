package com.atiurin.sampleapp.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.*
import com.atiurin.sampleapp.R
import org.hamcrest.CoreMatchers
import org.hamcrest.Matcher
import org.hamcrest.Matchers

object UIElementPage {

    val radioBtnInvisible: Matcher<View> by lazy { withId(R.id.invisible) }
    val radioBtnVisible: Matcher<View> by lazy { withText("VISIBLE") }
    val mainManuBtn: Matcher<View> by lazy { withClassName(CoreMatchers.`is`("android.widget.ImageButton")) }
    val nameChandler: Matcher<View> by lazy {
        Matchers.allOf(
            withId(R.id.tv_name),
            withText("Chandler Bing")
        )
    }
    val messageInputText: Matcher<View> by lazy {
        Matchers.allOf(
            withId(R.id.message_input_text),
            withText("Enter text")
        )
    }
    val textInput: Matcher<View> by lazy { Matchers.allOf(withId(R.id.message_input_text)) }
    val clearTextOption: Matcher<View> by lazy { withClassName(CoreMatchers.`is`("android.widget.ImageView")) }


    /**
     * first test case elements
     */
    val dashboard: Matcher<View> by lazy { withClassName(CoreMatchers.`is`("androidx.recyclerview.widget.RecyclerView")) }
    val contact: Matcher<View> by lazy { withText("Phoebe Buffay") }
    val textField: Matcher<View> by lazy { withId(R.id.message_input_text) }
    val sendText: Matcher<View> by lazy { withId(R.id.send_button) }

    /**
     * second test case elements
     */
    val mainMenu: Matcher<View> by lazy { withContentDescription(R.string.navigation_drawer_open) }
    val customClick: Matcher<View> by lazy { withId(R.id.custom_clicks_nav_item) }
    val customClickPage: Matcher<View> by lazy { withId(R.id.action_bar_root) }
    val topLeft: Matcher<View> by lazy { withId(R.id.rB_top_left) }
    val topCenter: Matcher<View> by lazy { withId(R.id.rB_top_center) }
    val topRight: Matcher<View> by lazy { withId(R.id.rB_top_right) }
    val centerLeft: Matcher<View> by lazy { withId(R.id.rB_center_left) }
    val centerRight: Matcher<View> by lazy { withId(R.id.rB_center_right) }
    val bottomLeft: Matcher<View> by lazy { withId(R.id.rB_bottom_left) }
    val bottomCenter: Matcher<View> by lazy { withId(R.id.rB_bottom_center) }
    val bottomRight: Matcher<View> by lazy { withId(R.id.rB_bottom_right) }
}