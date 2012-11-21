package com.iwantfood.ryanvanderveen;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;

public class CriteriaFragmentActivity extends FragmentActivity implements CriteriaFragment.OnListItemClickedListener{
	private static final int 		NUM_ITEMS = 3;
	private List<CriteriaFragment> 	fragments;					//individual criterion fragment
    private SectionsPagerAdapter 	mSectionsPagerAdapter;		//adapter for the pager
    private ViewPager				mViewPager;					//the actual content for the viewpager
    private CriteriaFragment 		EnergyFragment;
    private CriteriaFragment 		HungerFragment;
    private CriteriaFragment 		CostFragment;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.criteriafragmentpageradapter);
        //Set the resource in CriteriaSummary class
        CriteriaSummary.setResources(this.getResources());
        //instantiate the list of fragments
        fragments = new ArrayList<CriteriaFragment>();
        //build the fragments and corrosponding args
        buildFragmentList();
     	// Create the adapter that will return a fragment for each of 
        //the three primary sections of the app.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.criteria_pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);   
    }

	@Override
	public void onListItemClicked(int listViewNumber) {
		turnPage(listViewNumber);
	}
    
    private void turnPage(int listViewNumber) {
    	if(listViewNumber >= 2) {
    		Intent i = new Intent(CriteriaFragmentActivity.this, CriteriaSummaryActivity.class);
    		//potentially pass the info using key/value argments eg...
    		//i.putExtra(key, value);
    		//retrieve on next activity via
    		//Intent intent = getIntent();
    		//String value = intent.getStringExtra("key");
    		CriteriaFragmentActivity.this.startActivity(i);
    	}
    	else if (listViewNumber < 2) {
    		mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
    	}
    	else {
    		Log.wtf("WTFWTFWTF", "CriteriaFragmentActivity.turnPage. ALso this is impossible to reach");
    	}
    }
    
	private void buildFragmentList() {   	
        
    	for(int i=0; i<3; i++) {
    		Bundle b = new Bundle();
    		b.putInt("num", i);
    	
    		switch (i) {
    		case 0:
    			EnergyFragment = new CriteriaFragment();
    		    EnergyFragment.setArguments(b);       
    			break;
    		case 1:
    			HungerFragment = new CriteriaFragment();
    	        HungerFragment.setArguments(b);
    			break;
    		case 2:
    			CostFragment = new CriteriaFragment();
    	        CostFragment.setArguments(b);
    			break;
    		default:
    			Log.wtf("WTFWTFWTF", "CriteriaFragmentActivity.buildFragmentLIst");
    		}
    	}

        fragments.add(EnergyFragment);
        fragments.add(HungerFragment);
        fragments.add(CostFragment);
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.criteriafragmentpageradapter, menu);
        return true;
    }
    
    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the primary
     * sections of the app.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }
        
        public ListFragment getListFragmentItem(int i) {
        	return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: return getString(R.string.energy).toUpperCase();
                case 1: return getString(R.string.hunger).toUpperCase();
                case 2: return getString(R.string.cost).toUpperCase();
            }
            return null;
        }
    }
}
