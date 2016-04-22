# automation-challenge

## Index

[Planning](https://github.com/juhlila/automation-challenge#planning)

[Improvement Suggestions](https://github.com/juhlila/automation-challenge#improvement-suggestions)

[Instructions](https://github.com/juhlila/automation-challenge#instructions)


## Planning:
### Features - Written Test Scenarios and Validation

**1. Calculate Tip**

**1.1.** Insert 100 on EditText field and press "Calculate Tip" (tip percentage default is 15.0%) 

1.1.1. Validate Total Amount if its correct
  
1.1.2. Validate Tip amount if its correct

**1.2.** Insert 0.74 on EditText field and press "Calculate Tip"

1.2.1. Validate Total Amount if its correct

1.2.2. Validate Tip amount if its correct

**1.3.** Insert -58 on EditText field and press "Calculate Tip"

1.3.1. Validate Total Amount if its correct

1.3.2. Validate Tip amount if its correct

**1.4.** Clear EditText field and press "Calculate Tip"

1.4.1. Validate Total Amount if its still 0

1.4.2. Validate Tip amount if its still 0

-

**2. Settings**

**2.1.** Clear EditText field and press "Save Settings"

2.1.1. Validate incorrect number alert

**2.2.** Insert "16.7" on field and press "Save Settings"

2.2.1. Validate if new Value is shown

**2.3.** Insert random valid number and press Calculate Tip

2.3.1. Validate Total Amount if its correct

2.3.1. Validate Tip amount if its correct

**2.4.** Insert number 2 on field and press "Save Settings"

2.4.1. Validate if user was sent back to calculate tip page

**2.5.** Insert random valid number and press Calculate Tip

2.5.1. Validate Total Amount if its correct

2.5.2. Validate Tip amount if its correct

**2.6.** Clear EditText field and press Calculate Tip

2.6.1. Validate alert of invalid number

-

**3. Visibility of fields**

**3.1.** Assert that settings fields (and important textviews) are visible

**3.2.** Assert that calculate tip fields (and important textviews) are visible

-

**4. Not written tests**

**4.1.** Put app to background and resume it


## Improvement Suggestions
1. When someone type an invalid bill amount (ex: 0.00074, remove the extras zeros to 0.74, since a bill might never be 0.00n*)

2. Limit the max numbers that can be inputted on calculate tip field, numbers too large are breaking the layout after calculate - I consider this a bug.

3. Insert a back button on layout on Setings page

## Instructions:
### Run Tests
Framework used: **Espresso**

1. On Android Studio, with a device or emulator connected, right click on the package of tests (`app/src/androidTest/java/org/traeg/fastip/test/`) and press Run Tests

Espresso setup official page
https://google.github.io/android-testing-support-library/docs/espresso/setup/

### Generate Reports

To generate reports, open terminal on android studio and run the following command `./gradlew connectedAndroidTest`, this will generate a report index file under `app/build/reports/androidTests/connected/`. 
Open index.html

### Test Structure

Tests was separated by Activity. Every tests on main Activity is under `mainactivity` package, tests on settings activity is under `settings` package.
Helpers were created to make tests more readable, clean and easy to maintain, its under `helper` package.
