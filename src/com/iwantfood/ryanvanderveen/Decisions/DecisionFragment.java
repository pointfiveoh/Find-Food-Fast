package com.iwantfood.ryanvanderveen.Decisions;

import com.iwantfood.ryanvanderveen.R;
import com.iwantfood.ryanvanderveen.Criteria.CostCriteria;
import com.iwantfood.ryanvanderveen.Criteria.EnergyCriteria;
import com.iwantfood.ryanvanderveen.Criteria.HungerCriteria;
import com.iwantfood.ryanvanderveen.R.layout;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DecisionFragment<T> extends ListFragment {
	private int position;			
	private String decisions[];		//a group of decisions (unknown size)
	private Resources resources;	
	OnListItemClickedListener clickCallback;
	
	public interface OnListItemClickedListener {
		public void onListItemClicked(int listviewNumber);
	}
	
    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		position = getArguments() != null ? getArguments().getInt("num") : 0;
		resources = this.getResources();
		
		
    }

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		//custom view loaded from criteria xml layout file.
		View view = inflater.inflate(R.layout.criterion_pages, container, false);        
        return view;
	}
	
	/**
	 * This method generates the UI from the Criteria class(es)
	 */
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Bundle args = getArguments();
		
		//TODO: recursively build decision tree.
			
	}
	
	/**
	 * Checks to make sure it implements the callback interface for decision
	 * click events
	 */
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		try {
			clickCallback = (OnListItemClickedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
	}
	
	/**
	 * Handles the selecting a list item (decision) event.
	 */
	public void onListItemClick(ListView l, View v, int position, long id) {
		//TODO: implement onListItemClick
	}
	
}
