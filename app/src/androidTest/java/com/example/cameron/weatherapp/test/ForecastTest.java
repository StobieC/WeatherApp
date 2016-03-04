package com.example.cameron.weatherapp.test;

import com.example.cameron.weatherapp.view.SplashScreen;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


public class ForecastTest extends ActivityInstrumentationTestCase2<SplashScreen> {
  	private Solo solo;
  	
  	public ForecastTest() {
		super(SplashScreen.class);
  	}

  	public void setUp() throws Exception {
        super.setUp();
		solo = new Solo(getInstrumentation());
		getActivity();
  	}
  
   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
  	}
  
	public void testRun() {
        //Wait for activity: 'com.example.cameron.weatherapp.view.SplashScreen'
		solo.waitForActivity(com.example.cameron.weatherapp.view.SplashScreen.class, 2000);
        //Wait for activity: 'com.example.cameron.weatherapp.view.MainActivity'
		assertTrue("com.example.cameron.weatherapp.view.MainActivity is not found!", solo.waitForActivity(com.example.cameron.weatherapp.view.MainActivity.class));
        //Click on Leeds
		solo.clickOnView(solo.getView(com.example.cameron.weatherapp.R.id.settingDaysSpinner));
        //Click on Retrieve Forecast
		solo.clickOnView(solo.getView(com.example.cameron.weatherapp.R.id.homeRetrieveBtn));
        //Wait for activity: 'com.example.cameron.weatherapp.view.WeatherForecastActivity'
		assertTrue("com.example.cameron.weatherapp.view.WeatherForecastActivity is not found!", solo.waitForActivity(com.example.cameron.weatherapp.view.WeatherForecastActivity.class));
        //Assert that: 'Leeds' is shown
		assertTrue("'Leeds' is not shown!", solo.waitForView(solo.getView(com.example.cameron.weatherapp.R.id.forecastCurrentCity)));
        //Set default small timeout to 54246 milliseconds
		Timeout.setSmallTimeout(54246);
        //Click on LinearLayout Temperature: Min:2.04  C Max: 2.04  C Average: 2.0369999999999
		solo.clickInList(1, 0);
	}
}
