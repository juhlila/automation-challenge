package org.traeg.fastip.test.mainactivity;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.traeg.fastip.MainActivity;
import org.traeg.fastip.R;
import org.traeg.fastip.test.helpers.AmountValueValidator;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.traeg.fastip.test.helpers.GetHelper.getCurrentTipAmount;
import static org.traeg.fastip.test.helpers.GetHelper.getCurrentTipPercentage;

/**
 * Created by julia on 21/04/16.
 */
@RunWith(AndroidJUnit4.class)
public class CalculateTip {
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void calculateTipWithAcceptableBillValues() {
        double[] billValue = {100, 0.74, -58};

        for (double i : billValue) {
            onView(withId(R.id.billAmtEditText))
                    .perform(clearText())
                    .perform(typeText(String.valueOf(i)));
            onView(withId(R.id.calcTipButton))
                    .perform(click());

            onView(withId(R.id.tipAmtTextView))
                    .check(matches(withText(AmountValueValidator.tip(i, getCurrentTipPercentage()))));
            onView(withId(R.id.totalAmtTextView))
                    .check(matches(withText(AmountValueValidator.total(i, getCurrentTipAmount()))));
        }
    }

    @Test
    public void calculateTipWithNoBillValueSet() {
        onView(withId(R.id.billAmtEditText))
                .perform(clearText());
        onView(withId(R.id.calcTipButton))
                .perform(click());

        onView(withId(R.id.tipAmtTextView))
                .check(matches(withText(AmountValueValidator.tip(0, getCurrentTipPercentage()))));
        onView(withId(R.id.totalAmtTextView))
                .check(matches(withText(AmountValueValidator.total(0, getCurrentTipAmount()))));
    }
}
