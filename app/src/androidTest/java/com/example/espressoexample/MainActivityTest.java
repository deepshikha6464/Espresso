package com.example.espressoexample;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    //ActivityTestRule basically provides functional testing of a single Activity
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkingLoginSuccess() {

        onView(withId(R.id.edt_email)).perform(typeText("deeps123@gmail.com"), closeSoftKeyboard());

        onView(withId(R.id.edt_pass)).perform(typeText("deeps123"), closeSoftKeyboard());

        onView(withId(R.id.btn_login)).perform(click());

        onView(withId(R.id.tv_result)).check(matches(withText("LOGIN SUCCESS!")));



    }

    @Test
    public void checkingLoginFail() {

        onView(withId(R.id.edt_email)).perform(typeText("deeps1234@gmail.com"), closeSoftKeyboard());

        onView(withId(R.id.edt_pass)).perform(typeText("deeps1235"), closeSoftKeyboard());

        onView(withId(R.id.btn_login)).perform(click());

        onView(withId(R.id.tv_result)).check(matches(withText("LOGIN SUCCESS!")));



    }
}
