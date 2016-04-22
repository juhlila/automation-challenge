package org.traeg.fastip.test.helpers;

/**
 * Created by julia on 21/04/16.
 */
public class AmountValueValidator {
    public static String tip(double valueInput, double tipInput) {
        return String.format("$%.2f",(valueInput*tipInput/100));
    }

    public static String total(double billInput, double tipAmount) {
        return String.format("$%.2f",(billInput+tipAmount));
    }
}
