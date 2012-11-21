package com.iwantfood.ryanvanderveen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class CriteriaSummaryActivity extends Activity {
	/**
	 * @see android.app.Activity#onCreate(Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.criteriasummary);
		
		Log.d("DEBUGDEBUGDEBUG", CriteriaSummary.staticToString());
		
		LayoutInflater mInflater = LayoutInflater.from(this);
		View rootLinearLayout = (LinearLayout)findViewById(R.id.rootCriteriaSummary);
		
		TextView tv = new TextView(this);
		tv.setText(CriteriaSummary.staticToString());
		tv.setId(6);
		tv.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
		((LinearLayout) rootLinearLayout).addView(tv);

	}
	
	public void summaryButtonClicked(View v) {
		//switch to determine which button was clicked
    	switch(v.getId()) {
    	case R.id.restartCriteriaButton:
    		goToCriteria();
    		break;
    	case R.id.findFoodButton:
    		goToPlaces();
    		//go to the places API implementation portion of the app
    		break;
    	}
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		//repopulate choices
		//populateChoicesTextView();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}
	
	//methods for event handling
	private void goToCriteria() {
    	Intent CriteriaIntent = new Intent(CriteriaSummaryActivity.this, CriteriaFragmentActivity.class);
		CriteriaSummaryActivity.this.startActivity(CriteriaIntent);
    }
	private void goToPlaces() {
		Intent PlacesIntent = new Intent(CriteriaSummaryActivity.this, PlaceFinderActivity.class);
		CriteriaSummaryActivity.this.startActivity(PlacesIntent);
	}
	
}
