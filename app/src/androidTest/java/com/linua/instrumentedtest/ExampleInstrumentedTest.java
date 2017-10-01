package com.linua.instrumentedtest;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    Intent mIntent = new Intent();
    @Rule //对单个Activity提供功能测试管理。在Test、Before之前生成，测试完成和After执行结束后终止管理
    public final ActivityTestRule activityTestRule =
            new ActivityTestRule<>(SecondActivity.class, false, false);


    @Before
    public void initData(){
        mIntent.putExtra("testString", "+add");
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        activityTestRule.launchActivity(mIntent);

        CountDownLatch countdown = new CountDownLatch(1);
        countdown.await();

        assertEquals("com.linua.instrumentedtest", appContext.getPackageName());
    }

}
