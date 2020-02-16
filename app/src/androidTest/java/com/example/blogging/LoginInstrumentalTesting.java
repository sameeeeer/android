package com.example.blogging;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.blogging.Users.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginInstrumentalTesting {
    @Rule
    public ActivityTestRule<MainActivity> testRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void testUpdateUserProfile() {
        // type new first name in the first name field
        onView(withId(R.id.txtemail)).perform(typeText("las@gmail.com"));
        // close the keyboard
        closeSoftKeyboard();
        onView(withId(R.id.txtpswd)).perform(typeText("12345"));
        // close the keyboard
        closeSoftKeyboard();
        // click update profile button
        onView(withId(R.id.btnlogin)).perform(click());
    }
}
