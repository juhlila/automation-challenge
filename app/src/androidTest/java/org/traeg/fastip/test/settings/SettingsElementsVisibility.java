package org.traeg.fastip.test.settings;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.traeg.fastip.R;
import org.traeg.fastip.SettingsActivity;
import org.traeg.fastip.test.helpers.TestConstants;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by julia on 21/04/16.
 */
@RunWith(AndroidJUnit4.class)

public class SettingsElementsVisibility {
    @Rule
    public ActivityTestRule<SettingsActivity> activityRule = new ActivityTestRule<>(SettingsActivity.class);

    @Test
    public void tipEditTextField() {
        onView(withId(R.id.tipPercentageEditText)).check(matches(isDisplayed()));
    }

    @Test
    public void saveSettingsButton() {
        onView(withId(R.id.saveSettingsButton)).check(matches(isDisplayed()));
    }

    @Test
    public void pageTitle() {
        onView(withText(TestConstants.ACTION_BAR_SETTINGS)).check(matches(isDisplayed()));
    }
}
