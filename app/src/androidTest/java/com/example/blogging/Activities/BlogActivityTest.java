package com.example.blogging.Activities;

import android.view.View;
import android.widget.Button;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlogActivityTest {
    @Rule
    public ActivityTestRule<BlogActivity> activityTestRule = new ActivityTestRule<BlogActivity>(BlogActivity.class);
    private BlogActivity blogActivity = null;


    @Before
    public void setUp() throws Exception {
        blogActivity = activityTestRule.getActivity();
    }

    @Test
    public void TestFunction(){
        Button button = blogActivity.btnlogout;
        assertNotNull(button);
    }

    @Test
    public void Test2Function(){
        Button button = blogActivity.btnlogout;
        assertEquals("btnlogout",button.getText().toString());
    }

    @After
    public void tearDown() throws Exception {
    }

}