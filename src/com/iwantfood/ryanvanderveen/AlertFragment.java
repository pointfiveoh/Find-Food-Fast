package com.iwantfood.ryanvanderveen;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class AlertFragment extends DialogFragment {
	
	public static AlertFragment newInstance(int title) {
		AlertFragment fragment = new AlertFragment();
		Bundle args = new Bundle();
		args.putInt("title", title);
		fragment.setArguments(args);		
		return fragment;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		//int title = getArguments().getInt("title");
		
		return null;
	}
}
