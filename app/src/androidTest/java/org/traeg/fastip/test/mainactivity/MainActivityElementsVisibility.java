package org.traeg.fastip.test.mainactivity;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.traeg.fastip.MainActivity;
import org.traeg.fastip.R;
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

public class MainActivityElementsVisibility {
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void bllAmountEditTextField() {
        onView(withId(R.id.billAmtEditText)).check(matches(isDisplayed()));
    }

    @Test
    public void calculateTipButton() {
        onView(withId(R.id.calcTipButton)).check(matches(isDisplayed()));
    }

    @Test
    public void tipPercentageValue() {
        onView(withId(R.id.tipPctTextView)).check(matches(isDisplayed()));
    }

    @Test
    public void tipAmountValue() {
        onView(withId(R.id.tipAmtTextView)).check(matches(isDisplayed()));
    }

    @Test
    public void totalAmountValue() {
        onView(withId(R.id.totalAmtTextView)).check(matches(isDisplayed()));
    }

    @Test
    public void settingsButton() {
        onView(withId(R.id.menu_settings)).check(matches(isDisplayed()));
    }

    @Test
    public void pageTitle() {
        onView(withText(TestConstants.ACTION_BAR_MAIN)).check(matches(isDisplayed()));
    }
}
