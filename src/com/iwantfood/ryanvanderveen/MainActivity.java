package com.iwantfood.ryanvanderveen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity{
	//final static String TAG = "************888888888888888*************";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void mainButtonClicked(View v) {
    	//switch to determine which button was clicked
    	switch(v.getId()) {
    	case R.id.iwantfoodButton:
    		goToCriteria();
    		break;
    	case R.id.jkButton:
    		finish();
    		System.exit(0);
    		//break;
    	}
    }
    
    //Method that encapsulates the logic to begin the PageViewAdapter Criterion Activity
    public void goToCriteria() {
    	Intent CriteriaIntent = new Intent(MainActivity.this, CriteriaFragmentActivity.class);
		MainActivity.this.startActivity(CriteriaIntent);
    }
}