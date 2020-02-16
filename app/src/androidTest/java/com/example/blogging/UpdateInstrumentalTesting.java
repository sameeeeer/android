package com.example.blogging;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.blogging.Activities.BlogActivity;
import com.example.blogging.Users.MainActivity;

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
public class UpdateInstrumentalTesting {
    @Rule
    public ActivityTestRule<BlogActivity> testRule = new ActivityTestRule<>(BlogActivity.class);

    @Before
    public void setupHomeFragment() {
        testRule.getActivity().getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void testUpdateTrip() {
        // verify that the trips recycler view is displayed
        onView(withId(R.id.profile)).perform(click());

        onView(withId(R.id.btnEditProfile)).perform(click());
        onView(withId(R.id.txtfn)).perform(replaceText(""));
        onView(withId(R.id.txtlsn)).perform(replaceText(""));
        onView(withId(R.id.txtem)).perform(replaceText(""));
        onView(withId(R.id.txtph)).perform(replaceText(""));
        onView(withId(R.id.txtfn)).perform(typeText("Sameeer"));
        onView(withId(R.id.txtlsn)).perform(typeText("Karki"));
        onView(withId(R.id.txtem)).perform(typeText("las@gmail.com"));
        onView(withId(R.id.txtph)).perform(typeText("9860049993"));
        closeSoftKeyboard();
        onView(withId(R.id.btnupdate)).perform(click());


    }
}
