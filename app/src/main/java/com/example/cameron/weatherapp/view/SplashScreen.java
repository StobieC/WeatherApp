package com.example.cameron.weatherapp.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.example.cameron.weatherapp.R;

/**
 * Created by Cameron on 03/03/2016.
 */
public class SplashScreen extends Activity {

    private Intent intent = null;

    /**
     * Represents a spinner declaration for the welcome loading progress.
     */
    private ProgressBar spinner = null;

    Handler handler = new Handler();
    int progressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        spinner = (ProgressBar) this.findViewById(R.id.progressBar1);

        /**
         * Creates a Handler inside Thread to handle modification over the
         * Progress delay in seconds
         */

        new Thread(new Runnable() {

            int i = 0;

            public void run() {
                while (progressStatus < 2) {
                    progressStatus += doWork();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    handler.post(new Runnable() {
                        public void run() {
                            spinner.setProgress(progressStatus);
                            i++;
                        }
                    });
                }

                intent = new Intent(SplashScreen.this, MainActivity.class);
                SplashScreen.this.startActivity(intent);
                SplashScreen.this.finish();
            }

            private int doWork() {

                return i++;
            }

        }).start();

    }

}
