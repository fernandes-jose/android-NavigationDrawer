package com.example.android.navigationdrawer.robot

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import com.example.android.navigationdrawer.R
import org.hamcrest.core.AllOf.allOf

/**
 * Created by oscar on 14/08/18.
 */

fun mainRobot(func: MainRobot.() -> Unit) = MainRobot().apply { func() }

class MainRobot {

    fun checkTitle() {
        onView(withText(R.string.navigationdraweractivity_title))
                .check(matches(isDisplayed()))
    }

    fun checkDescription() {
        onView(allOf(withId(android.R.id.text2), withText(R.string.navigationdraweractivity_description)))
                .check(matches(isDisplayed()))
    }

    infix fun navigate(func: MainResultRobot.() -> Unit) : MainResultRobot {
        onView(withId(android.R.id.text1))
                .perform(click())
        return MainResultRobot().apply { func() }
    }
}

class MainResultRobot {
    fun isSuccess() {
        onView(withContentDescription(R.string.drawer_open))
                .check(matches(isDisplayed()))

    }
}