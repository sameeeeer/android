package com.example.blogging;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.blogging.Activities.BlogActivity;
import com.example.blogging.Users.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
@RunWith(AndroidJUnit4.class)
public class LogoutTesting {
    @Rule
    public ActivityTestRule<BlogActivity> testRule = new ActivityTestRule<>(BlogActivity.class);

    @Before
    public void setupHomeFragment() {
        testRule.getActivity().getSupportFragmentManager().beginTransaction();
    }
    @Test
    public void testLogout() {

        onView(withId(R.id.btnlogout)).perform(click());


    }
}
