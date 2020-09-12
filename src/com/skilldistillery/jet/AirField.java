package com.skilldistillery.jet;

import java.util.ArrayList;

public class AirField {

	private ArrayList<Jet> hanger = new ArrayList<> ();
			
	public AirField() {
		
	}

	public void AddJet(Jet newJet) {
		// TODO Auto-generated method stub
		hanger.add(newJet);
		
	}

	public void  removeJet(int index) {
		hanger.remove(index);
	}
	public void listAllJets() {
		// TODO: instead of calling the arraylist tostring,
		// loop through each index and print on separate lines
		System.out.println(hanger);
	}
	
}
