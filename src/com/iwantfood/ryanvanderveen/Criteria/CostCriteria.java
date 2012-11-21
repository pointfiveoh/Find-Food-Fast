package com.iwantfood.ryanvanderveen.Criteria;

import com.iwantfood.ryanvanderveen.R;
import com.iwantfood.ryanvanderveen.R.array;

import android.content.res.Resources;

public class CostCriteria extends FoodCriteria {
	
	//private static final long serialVersionUID = -3772339180662776030L;

	public CostCriteria(Resources _resources) {
		//call parent/super class's constructor to instantiate res/context objects
		super(_resources);
		//instantiate the variables
		criteria = res.getStringArray(R.array.CostCriteria);
		this.title = "Cost";
		this.header = "I have: ";
		
	}
}
