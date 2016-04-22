package org.traeg.fastip.test.helpers;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Matcher;
import org.traeg.fastip.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by julia on 21/04/16.
 */
public class GetHelper {
    public static String getText(final Matcher<View> matcher) {
        final String[] stringHolder = { null };
        onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return "getting text from a TextView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                TextView tv = (TextView) view;
                stringHolder[0] = tv.getText().toString();
            }
        });
        return stringHolder[0];
    }

    public static String getValueOf(int id) {
        return GetHelper.getText(withId(id));
    }

    public static Double getCurrentTipPercentage() {
        return Double.valueOf((GetHelper.getValueOf(R.id.tipPctTextView)).replaceAll("[^\\d.]", ""));
    }

    public static Double getCurrentTipAmount() {
        return Double.valueOf((GetHelper.getValueOf(R.id.tipAmtTextView)).replaceFirst("[^\\d.]", "").replace(",", "."));
    }

    public static Double getCurrentBillAmount() {
        return Double.valueOf((GetHelper.getValueOf(R.id.billAmtEditText)).replaceFirst("[^\\d.]", "").replace(",", "."));
    }
}
