package com.iwantfood.ryanvanderveen;

import android.content.res.Resources;

public class CriteriaSummary {
	private static String energyChoiceSelection;
	private static String hungerChoiceSelection;
	private static String costChoiceSelection;
	private static Resources res;
	
	public enum energyChoice {
		LOWENERGY(res.getStringArray(R.array.EnergyCriteria)[0], 0),
		MEDIUMENERGY(res.getStringArray(R.array.EnergyCriteria)[1], 1),
		HIGHENERGY(res.getStringArray(R.array.EnergyCriteria)[2], 2);
		
		private String stringValue;
		private int intValue;
		private energyChoice(String s, int i) {
			stringValue = s;
			intValue = i;
		}
		
		public String toString() {
			return stringValue;
		}
	}
	
	public enum hungerChoice {
		LOWHUNGER(res.getStringArray(R.array.HungerCriteria)[0], 0),
		MEDIUMHUNGER(res.getStringArray(R.array.HungerCriteria)[1], 1),
		HIGHHUNGER(res.getStringArray(R.array.HungerCriteria)[2], 2);
		
		private String stringValue;
		private int intValue;
		private hungerChoice(String s, int i) {
			stringValue = s;
			intValue = i;
		}
		public String toString() {
			return stringValue;
		}
	}
	
	public enum costChoice {
		LOWCOST(res.getStringArray(R.array.CostCriteria)[0], 0),
		MEDIUMCOST(res.getStringArray(R.array.CostCriteria)[1], 1),
		HIGHCOST(res.getStringArray(R.array.CostCriteria)[2], 2);
		
		private String stringValue;
		private int intValue;
		private costChoice(String s, int i) {
			stringValue = s;
			intValue = i;
		}
		public String toString() {
			return stringValue;
		}
	}
	
	public CriteriaSummary(int energyChoice, 
			int hungerChoice, 
			int costChoice, Resources _res) {
		
		res = _res;
		setEnergyChoiceMessageByInt(energyChoice);
		setHungerChoiceMessageByInt(hungerChoice);
		setCostChoiceMessageByInt(costChoice);
	}
	
	/*Get/Set for static vars*/
	public static String getEnergyChoiceMessage() { return energyChoiceSelection;	}
	public static void setEnergyChoiceMessage(String energyChoiceMessage) { CriteriaSummary.energyChoiceSelection = energyChoiceMessage; 	}
	public static String getHungerChoiceMessage() { return hungerChoiceSelection; }
	public static void setHungerChoiceMessage(String hungerChoiceMessage) {	CriteriaSummary.hungerChoiceSelection = hungerChoiceMessage; 	}
	public static String getCostChoiceMessage() { return costChoiceSelection; }
	public static void setCostChoiceMessage(String costChoiceMessage) { CriteriaSummary.costChoiceSelection = costChoiceMessage; }
	public static void setResources(Resources _res) { CriteriaSummary.res = _res; }
	/*Get/Set the static vars via integers*/
	public static void setEnergyChoiceMessageByInt(int energyChoiceMessage) { CriteriaSummary.energyChoiceSelection = generateEnergyChoice(energyChoiceMessage); 	}
	public static void setHungerChoiceMessageByInt(int hungerChoiceMessage) { CriteriaSummary.hungerChoiceSelection = generateHungerChoice(hungerChoiceMessage); 	}
	public static void setCostChoiceMessageByInt(int costChoiceMessage) { CriteriaSummary.costChoiceSelection = generateCostChoice(costChoiceMessage); }
	
	
	
	public static double getEnergy() {
		if (energyChoiceSelection != null) {
			//switch (energyChoiceMessage) {
			
			//}
		}
		
		return 0.0;
	}
	
	public static void getHunger() {
		//do something
		//do something more
	}   
	
	public static void getCost() {
		//do something
	}
	
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
		
		toString = energyChoiceSelection + " ";
		toString += hungerChoiceSelection + " ";
		toString += costChoiceSelection + " ";
		
		return toString;		
	}	
}
