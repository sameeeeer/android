package com.example.blogging;

import androidx.test.rule.ActivityTestRule;

import com.example.blogging.Activities.BlogActivity;
import com.example.blogging.Users.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class PostUpdateDeleteTests {
    @Rule
    public ActivityTestRule<BlogActivity> testRule = new ActivityTestRule<>(BlogActivity.class);

    @Before
    public void setupHomeFragement(){
        testRule.getActivity().getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void testUpdatePost(){

    }

}
