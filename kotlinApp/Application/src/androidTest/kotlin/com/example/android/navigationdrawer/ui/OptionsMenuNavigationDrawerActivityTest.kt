package com.example.android.navigationdrawer.ui

import android.support.test.rule.ActivityTestRule
import com.example.android.navigationdrawer.NavigationDrawerActivity
import com.example.android.navigationdrawer.robot.optionsMenuRobot
import org.junit.Rule
import org.junit.Test

/**
 * Created by oscar on 16/08/18.
 */

class OptionsMenuNavigationDrawerActivityTest {

    @Rule
    @JvmField
    var navigationDrawerActivityRule = ActivityTestRule<NavigationDrawerActivity>(NavigationDrawerActivity::class.java)

    @Test
    fun canDoAWebSearch() {
        optionsMenuRobot {
            optionsMenuActionVisible()
        } openOptionsMenu {
            optionsMenuVisible()
        } doWebSearch {
            hasLeftApp()
        }
    }
}