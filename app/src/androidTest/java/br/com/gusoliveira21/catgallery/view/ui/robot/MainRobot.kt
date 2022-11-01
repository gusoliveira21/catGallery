package br.com.gusoliveira21.catgallery.view.ui.robot

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import br.com.gusoliveira21.catgallery.view.ui.mainFragment.MainFragment

// Reference:  https://medium.com/android-bits/espresso-robot-pattern-in-kotlin-fc820ce250f7
class MainRobot {

    fun startScreen() = apply {
        launchFragmentInContainer<MainFragment>()
    }

    fun verifyNoConnectionDisplayed() = apply {
        Espresso.onView(ViewMatchers.withText("Sem sinal de internet!"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}