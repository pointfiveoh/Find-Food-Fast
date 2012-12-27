package com.iwantfood.ryanvanderveen;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class AlertFragment extends DialogFragment {
	
	public static AlertFragment newInstance(Context context, String title, String message, Boolean status) {
		AlertFragment fragment = new AlertFragment();
		Bundle args = new Bundle();

		args.putString("title", title);
		args.putString("message", message);
		if(status != null)
            // Setting alert dialog icon
            args.putInt("icon", (status) ? R.drawable.ic_launcher : R.drawable.ic_launcher);		
		
		fragment.setArguments(args);		
		
		return fragment;
	}

	/*@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		String title = getArguments().getString("title");
		
		return new AlertDialog.Builder(getActivity())
			.setIcon(getArguments().getInt("icon"))
			.setTitle(getArguments().getString("title))" +
			.setPositiveButton("Yes"),
				new DialogInterface.OnClickListener() {
                	public void onClick(DialogInterface dialog, int whichButton) {
                		((FragmentAlertDialog)getActivity()).doPositiveClick();
                	}
            	}
			)
			.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
                		public void onClick(DialogInterface dialog, int whichButton) {
                			((FragmentAlertDialog)getActivity()).doNegativeClick();
                		}
            		}
				)
				.create();
	}*/
}
