package org.traeg.fastip.test.mainactivity;

import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.traeg.fastip.MainActivity;
import org.traeg.fastip.R;
import org.traeg.fastip.test.helpers.ActivityHelpers;
import org.traeg.fastip.test.helpers.AmountValueValidator;

import java.util.Random;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.traeg.fastip.test.helpers.GetHelper.getCurrentTipAmount;

/**
 * Created by julia on 21/04/16.
 */
public class SetNewTipValue {
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {
        onView(withId(R.id.menu_settings)).perform(click());
        //for some reason clearText() was not working here, so replaceText() was used
        onView(withId(R.id.tipPercentageEditText))
                .perform(replaceText(""));
    }

    @Test
    public void saveValidTipValue() {
        //set new tip value to 2
        onView(withId(R.id.tipPercentageEditText))
                .perform(typeText("2"));
        onView(withId(R.id.saveSettingsButton))
                .perform(click());

        //should save successfully and go to MainActivity
        assertThat(ActivityHelpers.getActivityInstance(), instanceOf(MainActivity.class));
    }

    @Test
    public void saveValidTipAndShowNewTipValue() {
        String tipValue = "16.7";
        onView(withId(R.id.tipPercentageEditText))
                .perform(typeText(tipValue));
        onView(withId(R.id.saveSettingsButton))
                .perform(click());

        onView(withId(R.id.tipPctTextView))
                .check(matches(withText(tipValue + "%")));
    }

    @Test
    public void saveValidTipAndCalculateBill() {
        //generate valid random numbers to tip and bill
        int randomTip = new Random().nextInt(100);
        int randomBill = new Random().nextInt(50000);

        onView(withId(R.id.tipPercentageEditText))
                .perform(typeText(String.valueOf(randomTip)));
        onView(withId(R.id.saveSettingsButton))
                .perform(click());

        onView(withId(R.id.tipPctTextView))
                .check(matches(withText(randomTip + "%")));
        onView(withId(R.id.billAmtEditText))
                .perform(typeText(String.valueOf(randomBill)));
        onView(withId(R.id.calcTipButton))
                .perform(click());

        onView(withId(R.id.tipAmtTextView))
                .check(matches(withText(AmountValueValidator.tip(randomBill, randomTip))));
        onView(withId(R.id.totalAmtTextView))
                .check(matches(withText(AmountValueValidator.total(randomBill, getCurrentTipAmount()))));
    }
}

