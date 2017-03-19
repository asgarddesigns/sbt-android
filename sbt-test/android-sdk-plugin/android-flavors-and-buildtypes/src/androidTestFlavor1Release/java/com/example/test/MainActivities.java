package com.example.test;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivities {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule(MainActivity.class);
    @Test
    public void getActivityFlavor1Release() {
        assertEquals(activityRule.getActivity().getString(R.string.app_name), "Flavor1ReleaseActivity");
    }
}
