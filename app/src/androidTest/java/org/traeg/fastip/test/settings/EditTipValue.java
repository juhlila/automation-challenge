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
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isDialog;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by julia on 21/04/16.
 */
@RunWith(AndroidJUnit4.class)
public class EditTipValue {
    @Rule
    public ActivityTestRule<SettingsActivity> activityRule = new ActivityTestRule<>(SettingsActivity.class);

    @Test
    public void inputBlankTipValueAndSave() {
        onView(withId(R.id.tipPercentageEditText))
                .perform(replaceText(""));
        onView(withId(R.id.saveSettingsButton))
                .perform(click());

        onView(withText(TestConstants.INVALID_TIP_DIALOG_TITLE))
                .inRoot(isDialog())
                .check(matches(isDisplayed()));

        onView(withText(TestConstants.OK_BUTTON))
                .perform(click());
    }
}