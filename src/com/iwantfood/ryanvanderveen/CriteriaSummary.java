package com.iwantfood.ryanvanderveen;

import android.content.res.Resources;

public class CriteriaSummary {
	private static String energyChoiceMessage;
	private static String hungerChoiceMessage;
	private static String costChoiceMessage;
	private static Resources res;
	
	public CriteriaSummary(int energyChoice, 
			int hungerChoice, 
			int costChoice, Resources _res) {
		
		res = _res;
		setEnergyChoiceMessageByInt(energyChoice);
		setHungerChoiceMessageByInt(hungerChoice);
		setCostChoiceMessageByInt(costChoice);
	}
	
	/*Get/Set for static vars*/
	public static String getEnergyChoiceMessage() { return energyChoiceMessage;	}
	public static void setEnergyChoiceMessage(String energyChoiceMessage) { CriteriaSummary.energyChoiceMessage = energyChoiceMessage; 	}
	public static String getHungerChoiceMessage() { return hungerChoiceMessage; }
	public static void setHungerChoiceMessage(String hungerChoiceMessage) {	CriteriaSummary.hungerChoiceMessage = hungerChoiceMessage; 	}
	public static String getCostChoiceMessage() { return costChoiceMessage; }
	public static void setCostChoiceMessage(String costChoiceMessage) { CriteriaSummary.costChoiceMessage = costChoiceMessage; }
	public static void setResources(Resources _res) { CriteriaSummary.res = _res; }
	/*Get/Set the static vars via integers*/
	public static void setEnergyChoiceMessageByInt(int energyChoiceMessage) { CriteriaSummary.energyChoiceMessage = generateEnergyChoice(energyChoiceMessage); 	}
	public static void setHungerChoiceMessageByInt(int hungerChoiceMessage) { CriteriaSummary.hungerChoiceMessage = generateHungerChoice(hungerChoiceMessage); 	}
	public static void setCostChoiceMessageByInt(int costChoiceMessage) { CriteriaSummary.costChoiceMessage = generateCostChoice(costChoiceMessage); }
	
	private static String generateEnergyChoice(int choice) {
		String returnValue = "";
		String[] choices = res.getStringArray(R.array.EnergyCriteria);
		switch (choice) {
		case 0:
			returnValue = choices[0];
			break;
		case 1:
			returnValue = choices[1];
			break;
		case 2:
			returnValue = choices[2];
			break;
		default:
			
			break;
		}
		return returnValue;
	}
	
	private static String generateHungerChoice(int choice){
		String returnValue = "";
		String[] choices = res.getStringArray(R.array.HungerCriteria);
		switch (choice) {
		case 0:
			returnValue = choices[0];
			break;
		case 1:
			returnValue = choices[1];
			break;
		case 2:
			returnValue = choices[2];
			break;
		default:
			
			break;
		}
		return returnValue;
	}
	
	private static String generateCostChoice(int choice) {
		String returnValue = "";
		String[] choices = res.getStringArray(R.array.CostCriteria);
		switch (choice) {
		case 0:
			returnValue = choices[0];
			break;
		case 1:
			returnValue = choices[1];
			break;
		case 2:
			returnValue = choices[2];
			break;
		default:
			
			break;
		}
		return returnValue;
	}
	
	public static String staticToString() {
		String toString = "";
		
		toString = energyChoiceMessage + " ";
		toString += hungerChoiceMessage + " ";
		toString += costChoiceMessage + " ";
		
		return toString;		
	}	
}
