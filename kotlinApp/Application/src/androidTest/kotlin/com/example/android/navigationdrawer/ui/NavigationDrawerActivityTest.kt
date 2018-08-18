package com.example.android.navigationdrawer.ui

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.android.navigationdrawer.NavigationDrawerActivity
import com.example.android.navigationdrawer.robot.navigationDrawerRobot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by oscar on 15/08/18.
 */

@RunWith(AndroidJUnit4::class)
class NavigationDrawerActivityTest {

    @Rule
    @JvmField
    var navigationDrawerActivityRule = ActivityTestRule<NavigationDrawerActivity>(NavigationDrawerActivity::class.java)

    @Test
    fun canOpenAndCloseDrawerWithClick() {
        navigationDrawerRobot {
            drawerButtonVisible()
            drawerClosed()
        }.openDrawerWithClick {
            isOpened()
        } closeDrawer {
            drawerIsClosed()
        }
    }

    @Test
    fun canOpenAndCloseDrawerWithSwipe() {
        navigationDrawerRobot {
            drawerButtonVisible()
            drawerClosed()
        }.openDrawerWithSwipe {
            isOpened()
        } closeDrawer {
            drawerIsClosed()
        }
    }

    @Test
    fun canSeeMercury() {
        navigationDrawerRobot {
            drawerButtonVisible()
            drawerClosed()
        }.openDrawer {
            isOpened()
        }.touchPlanet("Mercury") {
            planetVisible()
        }
    }

    @Test
    fun canSeeEarth() {
        navigationDrawerRobot {
            drawerButtonVisible()
            drawerClosed()
        }.openDrawer {
            isOpened()
        }.touchPlanet("Earth")  {
            planetVisible()
        }
    }

    @Test
    fun canSeeMars() {
        navigationDrawerRobot {
            drawerButtonVisible()
            drawerClosed()
        }.openDrawer {
            isOpened()
        }.touchPlanet("Mars")  {
            planetVisible()
        }
    }

    @Test
    fun canSeeJupiter() {
        navigationDrawerRobot {
            drawerButtonVisible()
            drawerClosed()
        }.openDrawer {
            isOpened()
        }.touchPlanet("Jupiter")  {
            planetVisible()
        }
    }

    @Test
    fun canSeeSaturn() {
        navigationDrawerRobot {
            drawerButtonVisible()
            drawerClosed()
        }.openDrawer {
            isOpened()
        }.touchPlanet("Saturn")  {
            planetVisible()
        }
    }

    @Test
    fun canSeeUranus() {
        navigationDrawerRobot {
            drawerButtonVisible()
            drawerClosed()
        }.openDrawer {
            isOpened()
        }.touchPlanet("Uranus")  {
            planetVisible()
        }
    }

    @Test
    fun canSeeNeptune() {
        navigationDrawerRobot {
            drawerButtonVisible()
            drawerClosed()
        }.openDrawer {
            isOpened()
        }.touchPlanet("Neptune")  {
            planetVisible()
        }
    }
}