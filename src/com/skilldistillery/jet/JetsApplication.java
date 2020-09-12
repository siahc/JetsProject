package com.skilldistillery.jet;

import java.util.ArrayList;
import java.util.List;

//import com.skilldistillery.polymorphism.labs.vehicles.Automobile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.skilldistillery.jet.CargoPlane;
import com.skilldistillery.jet.FighterJet;
import com.skilldistillery.jet.JetImpl;
import com.skilldistillery.jet.AirField;

public class JetsApplication {

	private AirField airfield = new AirField();
	
	public JetsApplication() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JetsApplication app = new JetsApplication();
		app.launch();
	}
	public void loadJets() {

		try (BufferedReader bufIn = new BufferedReader(new FileReader("/Users/josiahcandler/SD/Java/workspace/JetsProject/src/com/skilldistillery/jet/jets.config"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] planeInfo = line.split(",");
				
				 if ( planeInfo[0].contentEquals("Fighter") ) {
					  
				      FighterJet newJet = 
			    		  new FighterJet(planeInfo[1],
			    				  Double.parseDouble(planeInfo[2]),
			    				  Integer.parseInt(planeInfo[3]),
			    				  Long.parseLong(planeInfo[4])
			    				  );
				      airfield.AddJet(newJet);
				  } else if ( planeInfo[0].contentEquals("Cargo") ) {
					  CargoPlane newJet = 
				    		  new CargoPlane(planeInfo[1],
				    				  Double.parseDouble(planeInfo[2]),
				    				  Integer.parseInt(planeInfo[3]),
				    				  Long.parseLong(planeInfo[4])
				    				  );
					      airfield.AddJet(newJet);
				  }else if ( planeInfo[0].contentEquals("Jet") ) {
				      JetImpl newJet = 
				    		  new JetImpl(planeInfo[1],
				    				  Double.parseDouble(planeInfo[2]),
				    				  Integer.parseInt(planeInfo[3]),
				    				  Long.parseLong(planeInfo[4])
				    				  );
					      airfield.AddJet(newJet);
				  } else { //error
				  }  				
			}
		} catch (

		IOException e) {
			System.err.println(e);
		}
	}

	private void menu() {
//		List fleet
//		Fly all jets
//		View fastest jet
//		View jet with longest range
//		Load all Cargo Jets
//		Dogfight!
//		Add a jet to Fleet
//		Remove a jet from Fleet
//		Quit
	}
	
	private void listFleet() {
		airfield.listAllJets();
	}
	private void launch() {
		// TODO Auto-generated method stub
		loadJets();
		menu();
	}

}
