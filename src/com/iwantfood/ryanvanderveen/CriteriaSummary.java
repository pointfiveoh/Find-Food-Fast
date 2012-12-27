package com.iwantfood.ryanvanderveen;

import android.content.res.Resources;

public class CriteriaSummary {
	//Static variables for preserving selection state (hopefully)
	private static int energyChoiceSelection;
	private static int hungerChoiceSelection;
	private static int costChoiceSelection;
	//Resources for accessing UI elements
	private static Resources res;
	
	public static enum energyChoice {
		LOWENERGY(res.getStringArray(R.array.EnergyCriteria)[0]),
		MEDIUMENERGY(res.getStringArray(R.array.EnergyCriteria)[1]),
		HIGHENERGY(res.getStringArray(R.array.EnergyCriteria)[2]);

		private String value;
		private energyChoice(String _value) {
			value = _value;	
		}
		public String getEnergyChoice() {   
			return value;
		}
	}
	
	public static enum hungerChoice {
		LOWHUNGER(res.getStringArray(R.array.HungerCriteria)[0]),
		MEDIUMHUNGER(res.getStringArray(R.array.HungerCriteria)[1]),
		HIGHHUNGER(res.getStringArray(R.array.HungerCriteria)[2]);
		
		private String value;
		private hungerChoice(String _value) {
			value = _value;	
		}
		public String getHungerChoice() {
			return value;
		}
	}
	
	public static enum costChoice {
		LOWCOST(res.getStringArray(R.array.CostCriteria)[0]),
		MEDIUMCOST(res.getStringArray(R.array.CostCriteria)[1]),
		HIGHCOST(res.getStringArray(R.array.CostCriteria)[2]);
		
		private String value;
		private costChoice(String _value) {
			value = _value;	
		}
		public String getCostChoice() {
			return value;
		}
	}
	
	public CriteriaSummary(int energyChoice, 
			int hungerChoice, 
			int costChoice, Resources _res) {
		res = _res;
		setEnergyChoiceSelection(energyChoice);
		setHungerChoiceSelection(hungerChoice);
		setCostChoiceSelection(costChoice);
	}
	
	/* Get & Set Energy Selection */
	public static int getEnergyChoiceSelection() { return energyChoiceSelection; }
	public static void setEnergyChoiceSelection(int energyChoiceSelection) { CriteriaSummary.energyChoiceSelection = energyChoiceSelection;	}
	/* Get & Set Hunger Selection */
	public static int getHungerChoiceSelection() { return hungerChoiceSelection; }
	public static void setHungerChoiceSelection(int hungerChoiceSelection) { CriteriaSummary.hungerChoiceSelection = hungerChoiceSelection; }
	/* Get & Set Cost Selection */
	public static int getCostChoiceSelection() { return costChoiceSelection;	}
	public static void setCostChoiceSelection(int costChoiceSelection) { CriteriaSummary.costChoiceSelection = costChoiceSelection; }	
	/* Allow instantiation (setting) of Resource variable */
	public static void setResources(Resources _res) { CriteriaSummary.res = _res; }

	public static String getChoices() {
		String retVal = "";
		
		if (energyChoiceSelection < 0 || energyChoiceSelection > 2){
			if (hungerChoiceSelection < 0 || hungerChoiceSelection > 2){
				if (costChoiceSelection < 0 || costChoiceSelection > 2){
					retVal += energyChoice.values()[energyChoiceSelection] + " ";
					retVal += hungerChoice.values()[hungerChoiceSelection] + " ";
					retVal += costChoice.values()[costChoiceSelection] + " ";
				}
			}
		}
			
		return retVal;
	}
}
