package com.iwantfood.ryanvanderveen;

import com.iwantfood.ryanvanderveen.Criteria.*;

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

public class CriteriaFragment extends ListFragment {
	public static final String ARG_SECTION_NUMBER = "section_number";
	private int mNum;	//used for position/num tracking (from args etc)
	private Resources resources;
	private EnergyCriteria ec;
	private HungerCriteria hc;
	private CostCriteria cc;
	OnListItemClickedListener clickCallback;
	
	public interface OnListItemClickedListener {
		public void onListItemClicked(int listviewNumber);
	}
	
    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mNum = getArguments() != null ? getArguments().getInt("num") : 1;
		resources = this.getResources();
		
		if (mNum == 0)
			ec = new EnergyCriteria(resources);
		else if (mNum == 1)
			hc = new HungerCriteria(resources);
		else if (mNum == 2)
			cc = new CostCriteria(resources);
		else
			Log.wtf("WTFWTFWTFWTFWTFWTFWTFWTFWTF" , "FAILURE ON ARGS NUM <> 0,1,or2");
		
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
		
		switch (args.getInt("num")) {
		case 0:
			setListAdapter(new ArrayAdapter<String>(getActivity(), 
					android.R.layout.simple_list_item_1, ec.getCriteria()));
			break;
		case 1:
			setListAdapter(new ArrayAdapter<String>(getActivity(), 
					android.R.layout.simple_list_item_1, hc.getCriteria()));
			break;
		case 2:
			setListAdapter(new ArrayAdapter<String>(getActivity(), 
					android.R.layout.simple_list_item_1, cc.getCriteria()));
			break;
		default:
			Log.wtf("WTFWTFWTF", "default case hit on switch in CriteriaFragment.onActivityCreated");		
			break;
		}	
	}
	
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
	 * This method is an event handler for selecting an item in the list.
	 * Not sure if this will be "remembered" by the app if the user scrolls
	 * back a fragment or two. Needs implementation
	 */
	public void onListItemClick(ListView l, View v, int position, long id) {
		switch (mNum) {
		case 0:
			CriteriaSummary.setEnergyChoiceMessageByInt(position);
			//Log.i("Energy Choice", "Position selected was  " + position);
			clickCallback.onListItemClicked(mNum);
			break;
		case 1:
			CriteriaSummary.setHungerChoiceMessageByInt(position);
			//Log.i("Hunger Choice", "Position selected was  " + position);
			clickCallback.onListItemClicked(mNum);
			break;
		case 2:
			CriteriaSummary.setCostChoiceMessageByInt(position);
			//Log.i("Cost Choice", "Position selected was  " + position);
			clickCallback.onListItemClicked(mNum); 
			break;
		default:
			Log.wtf("TAG", "CriteriaFragmnet.onLIstItemClick... WTFWTFWTFWTF");
	
		}
	}
}
	
	
	
	
	
