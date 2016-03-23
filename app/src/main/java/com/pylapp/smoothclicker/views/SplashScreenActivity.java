/*
    MIT License

    Copyright (c) 2016  Pierre-Yves Lapersonne (Twitter: @pylapp, Mail: pylapp(dot)pylapp(at)gmail(dot)com)

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
 */
// ✿✿✿✿ ʕ •ᴥ•ʔ/ ︻デ═一

package com.pylapp.smoothclicker.views;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;
import com.pylapp.smoothclicker.R;

/**
 * The splash screen activity
 *
 * @author pylapp
 * @version 1.2.0
 * @since 15/03/2016
 */
public class SplashScreenActivity extends AppCompatActivity {


    /* ********** *
     * ATTRIBUTES *
     * ********** */

    /**
     * Flag indicating if the app is starting for the first time or not
     */
    public static boolean sIsFirstLaunch = true;

    /**
     * The handler with starts the main activity after a delay
     */
    private Handler mHandler;
    /**
     * The callback triggered by the handler
     */
    private Runnable mCallback;


    /* ********* *
     * CONSTANTS *
     * ********* */

    /**
     * The duration in ms of the splash
     */
    private static final int SPLASH_TIME_OUT = 3000;


    /* ****************************** *
     * METHODS FROM AppCompatActivity *
     * ****************************** */

    /**
     * Triggered to create the view
     * @param savedInstanceState -
     */
    @Override
    protected void onCreate( Bundle savedInstanceState ){
        super.onCreate(savedInstanceState);
        if ( ! sIsFirstLaunch) {
            Intent i = new Intent(SplashScreenActivity.this, ClickerActivity.class);
            startActivity(i);
            finish();
        }
        sIsFirstLaunch = false;
        setContentView(R.layout.activity_splash_screen);
    }

    /**
     * Triggered when the view has been created
     * @param savedInstanceState -
     */
    @Override
    protected void onPostCreate( Bundle savedInstanceState ){

        HTextView htv = (HTextView) findViewById(R.id.htvSplashScreenDesc);
        htv.setAnimateType(HTextViewType.ANVIL);
        htv.animateText(getString(R.string.splashscreen_description)); // FIXME May throw an OutOfMemory error, this lib is a bit pity

        mHandler = new Handler();
        mCallback = new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, ClickerActivity.class);
                startActivity(i);
                finish();
            }
        };
        mHandler.postDelayed(mCallback, SPLASH_TIME_OUT);

        super.onPostCreate(savedInstanceState);

    }

    /**
     * Triggered when the back button has been pressed
     */
    @Override
    public void onBackPressed(){
        if ( mHandler != null && mCallback != null ){
            mHandler.removeCallbacks(mCallback);
            mHandler = null;
            mCallback = null;
        }
        sIsFirstLaunch = true;
        finish();
    }

}
