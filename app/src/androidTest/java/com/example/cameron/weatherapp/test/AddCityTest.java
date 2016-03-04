package com.example.cameron.weatherapp.test;

import com.example.cameron.weatherapp.view.SplashScreen;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


public class AddCityTest extends ActivityInstrumentationTestCase2<SplashScreen> {
  	private Solo solo;
  	
  	public AddCityTest() {
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
        //Click on Add City
		solo.clickOnView(solo.getView(com.example.cameron.weatherapp.R.id.addNewBtn));
        //Wait for activity: 'com.example.cameron.weatherapp.view.SettingActivity'
		assertTrue("com.example.cameron.weatherapp.view.SettingActivity is not found!", solo.waitForActivity(com.example.cameron.weatherapp.view.SettingActivity.class));
        //Click on Add City
		solo.clickOnView(solo.getView(com.example.cameron.weatherapp.R.id.settingAddBtn));
        //Wait for dialog
		solo.waitForDialogToOpen(5000);
        //Click on Empty Text View
		solo.clickOnView(solo.getView(android.widget.EditText.class, 0));
        //Enter the text: 'Leeds'
		solo.clearEditText((android.widget.EditText) solo.getView(android.widget.EditText.class, 0));
		solo.enterText((android.widget.EditText) solo.getView(android.widget.EditText.class, 0), "Leeds");
        //Click on Add City
		solo.clickOnView(solo.getView(android.R.id.button1));
        //Press menu back key
		solo.goBack();
        //Wait for dialog
		solo.waitForDialogToOpen(5000);
        //Click on Yes
		solo.clickOnView(solo.getView(android.R.id.button1));
        //Click on Leeds
		solo.clickOnView(solo.getView(com.example.cameron.weatherapp.R.id.settingDaysSpinner));
	}
}
