package com.example.android.navigationdrawer.robot

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.*
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import com.example.android.navigationdrawer.R
import org.hamcrest.CoreMatchers.not
import org.hamcrest.core.AllOf.allOf

/**
 * Created by oscar on 15/08/18.
 */

fun navigationDrawerRobot(func: NavigationDrawerRobot.() -> Unit) = NavigationDrawerRobot().apply { func() }

class NavigationDrawerRobot {

    fun drawerButtonVisible() {
        onView(withContentDescription(R.string.drawer_open)).check(matches(isDisplayed()))
    }

    fun drawerClosed() {
        onView(withId(R.id.left_drawer)).check(matches(not(isDisplayed())))
    }

    fun openDrawer(func: NavigationDrawerOpenedRobot.() -> Unit) : NavigationDrawerOpenedRobot {
        return openDrawerWithClick(func)
    }

    fun openDrawerWithClick(func: NavigationDrawerOpenedRobot.() -> Unit) : NavigationDrawerOpenedRobot {
        onView(withContentDescription(R.string.drawer_open)).perform(click())
        return NavigationDrawerOpenedRobot().apply(func)
    }

    fun openDrawerWithSwipe(func: NavigationDrawerOpenedRobot.() -> Unit) : NavigationDrawerOpenedRobot {
        onView(withId(R.id.drawer_layout)).perform(
                ViewActions.actionWithAssertions(
                        GeneralSwipeAction(
                                Swipe.FAST,
                                GeneralLocation.CENTER_LEFT,
                                GeneralLocation.CENTER_RIGHT,
                                Press.FINGER
                        )
                )
        )
        return NavigationDrawerOpenedRobot().apply(func)
    }
}

class NavigationDrawerOpenedRobot {

    fun isOpened() {
        onView(withId(R.id.left_drawer)).check(matches(isDisplayed()))
    }

    fun touchPlanet(planet: String, func: NavigationDrawerResultRobot.() -> Unit) : NavigationDrawerResultRobot {
        onView(withText(planet)).perform(click())
        return NavigationDrawerResultRobot(planet).apply { func() }
    }

    infix fun closeDrawer(func: NavigationDrawerResultRobot.() -> Unit) : NavigationDrawerResultRobot {
        onView(withContentDescription(R.string.drawer_open)).perform(click())
        return NavigationDrawerResultRobot().apply(func)
    }
}

class NavigationDrawerResultRobot(private val planet: String = "") {
    fun planetVisible() {
        onView(allOf(withText(planet), not(isDescendantOfA(withId(R.id.left_drawer)))))
                .check(matches(isDisplayed()))
    }

    fun drawerIsClosed() {
        onView(withId(R.id.left_drawer)).check(matches(not(isDisplayed())))
    }
}