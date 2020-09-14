package com.skilldistillery.jet;

import java.util.ArrayList;

public class AirField {

	private ArrayList<Jet> hangar = new ArrayList<> ();
			
	public AirField() {
		
	}

	public ArrayList<Jet> getHangar() {
		return hangar;
	}


	public void AddJet(Jet newJet) {
		// TODO Auto-generated method stub
		hangar.add(newJet);
		
	}

	public void  removeJet(int index) {
		hangar.remove(index);
	}
	public void listAllJets() {
		// loop through each index and print on separate lines
		for (int c = 0; c < hangar.size(); c++) {
			Jet j = hangar.get(c);
			System.out.print(c + ". ");
			System.out.println(j);
		}
	}
	 
	
}
