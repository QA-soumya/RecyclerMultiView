package com.example.recyclermuiltivewtask;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.example.recyclermuiltivewtask.RecyclerViewMatcher.withRecyclerView;

@RunWith(AndroidJUnit4.class)
public class recyclerviewTest {

    public static final int itemposition = 0;
    public static final String toastmessage = "Clicked on image";

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);
    /* Test Condition :
    1. Verify that Texts are in odd positions and images are in even positions.
    2. Verify that, When a user, clicking on the Text or image, the respective toast message should be displayed .

   */

    @Test
    public void verifyText1atposition0() throws Exception {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition((itemposition), click()));
        onView((withText("Text 1"))).inRoot(new ToastMatcher()).check(matches(isDisplayed()));

        Thread.sleep(3000);
    }

    @Test
    public void verifyText2atposition2() throws Exception {
        Thread.sleep(2000);

        onView(withRecyclerView(R.id.recyclerView).atPosition(2, R.id.recyclerView)).perform(click());
        onView((withText("Text 2"))).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    @Test
    public void verifyText3atposition4() throws Exception {
        Thread.sleep(2000);

        onView(withRecyclerView(R.id.recyclerView).atPosition(4, R.id.recyclerView)).perform(click());
        onView((withText("Text 3"))).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    @Test
    public void verifyText4atposition6() throws Exception {
        Thread.sleep(2000);

        onView(withRecyclerView(R.id.recyclerView).atPosition(6, R.id.recyclerView)).perform(click());
        onView((withText("Text 4"))).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    @Test
    public void verifyText5atposition8() throws Exception {
        Thread.sleep(2000);
        onView(withId(R.id.recyclerView)).perform(scrollToPosition(8));                     // Scroll the screen and locate position 8
        onView(withRecyclerView(R.id.recyclerView).atPosition(8, R.id.recyclerView)).perform(click());
        onView((withText("Text 5"))).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    @Test
    public void verifyimageatposition1() throws Exception {
        Thread.sleep(2000);
        onView(withRecyclerView(R.id.recyclerView).atPosition(1, R.id.image)).perform(click());
        onView(withText(toastmessage)).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    @Test
    public void verifyimageatposition3() throws Exception {
        Thread.sleep(2000);
        onView(withRecyclerView(R.id.recyclerView).atPositionOnView(3, R.id.image)).perform(click());
        onView(withText(toastmessage)).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    @Test
    public void verifyimageatposition9() throws Exception {
        Thread.sleep(2000);
        onView(withId(R.id.recyclerView)).perform(scrollToPosition(9));                           // Scroll the screen and locate position 9
        onView(withRecyclerView(R.id.recyclerView).atPositionOnView(9, R.id.image)).perform(click());
        onView(withText(toastmessage)).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

}