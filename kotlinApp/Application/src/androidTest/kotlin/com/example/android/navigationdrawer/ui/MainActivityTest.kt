package com.example.android.navigationdrawer.ui

import com.example.android.navigationdrawer.MainActivity
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import android.support.test.runner.AndroidJUnit4
import com.example.android.navigationdrawer.robot.mainRobot
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by oscar on 14/08/18.
 */

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mainActivityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun shouldSeeDrawerMenu() {
        mainRobot {
            checkTitle()
            checkDescription()
        } navigate {
            isSuccess()
        }
    }
}