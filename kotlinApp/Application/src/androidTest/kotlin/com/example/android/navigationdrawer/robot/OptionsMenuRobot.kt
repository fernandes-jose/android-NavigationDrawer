package com.example.android.navigationdrawer.robot

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.NoActivityResumedException
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import com.example.android.navigationdrawer.R

/**
 * Created by oscar on 16/08/18.
 */

fun optionsMenuRobot(func: OptionsMenuRobot.() -> Unit) = OptionsMenuRobot().apply { func() }

class OptionsMenuRobot {

    fun optionsMenuActionVisible() {
        onView(withContentDescription(R.string.abc_action_menu_overflow_description))
                .check(matches(isDisplayed()))
    }

    infix fun openOptionsMenu(func: OptionsMenuOpenedRobot.() -> Unit) : OptionsMenuOpenedRobot {
        onView(withContentDescription(R.string.abc_action_menu_overflow_description))
                .perform(click())
        return OptionsMenuOpenedRobot().apply(func)
    }
}

class OptionsMenuOpenedRobot {
    fun optionsMenuVisible() {
        onView(withText(R.string.action_websearch)).check(matches(isDisplayed()))
    }

    infix fun doWebSearch(func: OptionsMenuResultRobot.() -> Unit) : OptionsMenuResultRobot {
        onView(withText(R.string.action_websearch)).perform(click())
        return OptionsMenuResultRobot().apply(func)
    }
}

class OptionsMenuResultRobot {
    fun hasLeftApp() {
        try {
            onView(withText("Mercury")).check(matches(isDisplayed()))
        } catch (ex: NoActivityResumedException) { }
    }
}