package com.skilldistillery.jet;

//import com.skilldistillery.polymorphism.labs.vehicles.Automobile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class JetsApplication {

	private AirField airfield = new AirField();
	private Scanner scanIn = new Scanner(System.in);

	public JetsApplication() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JetsApplication app = new JetsApplication();
		app.launch();
	}

	public void loadJets() {

		try (BufferedReader bufIn = new BufferedReader(new FileReader(
				"/Users/josiahcandler/SD/Java/workspace/JetsProject/src/com/skilldistillery/jet/jets.config"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] planeInfo = line.trim().split(",");

				String type = "";
				String model = "";
				double speed = 0.0;
				int range = 0;
				long price = (long) 0;
				if (planeInfo.length >= 5) {
					type = planeInfo[0].trim();
					model = planeInfo[1].trim();
					speed = Double.parseDouble(planeInfo[2]);
					range = Integer.parseInt(planeInfo[3]);
					price = Long.parseLong(planeInfo[4]);
				} else {
					System.out.println("Warning: skipped '" + line + "' -- not enough fields");
					continue;
				}
				addTypedJet(type, model, speed, range, price);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	private void addTypedJet(String type, String model, double speed, int range, long price) {
		if (type.contentEquals("Fighter") || type.contentEquals("fighter")) {
			FighterJet newJet = new FighterJet(model, speed, range, price);
			airfield.AddJet(newJet);
		} else if (type.contentEquals("Cargo") || type.contentEquals("cargo")) {
			CargoPlane newJet = new CargoPlane(model, speed, range, price);
			airfield.AddJet(newJet);
		} else if (type.contentEquals("Jet") || type.contentEquals("jet")) {
			JetImpl newJet = new JetImpl(model, speed, range, price);
			airfield.AddJet(newJet);
		} else { // error
			System.out.println(type + " is not recognized.");
		}
	}

	private void menu() {
		boolean quit = false;
		while (!quit) {

			System.out.println();
			System.out.println();
			System.out.println("Please select the number for the operation you would like to perform");
			System.out.println("1. List fleet");
			System.out.println("2. Fly all jets");
			System.out.println("3. View fastest jet");
			System.out.println("4. View jet with longest range");
			System.out.println("5. Load all Cargo Jets");
			System.out.println("6. Dogfight!");
			System.out.println("7. Add a jet to Fleet");
			System.out.println("8. Remove a jet from Fleet");
			System.out.println("9. Quit");
			System.out.println();
			System.out.print("Your selection: ");
			int input = scanIn.nextInt();
			scanIn.nextLine();

			switch (input) {
			case 1: {
				listFleet();
				break;
			}
			case 2: {
				flyAllJets();
				break;
			}
			case 3: {
				viewFastestJet();
				break;
			}
			case 4: {
				viewJetWithLongestRange();
				break;
			}
			case 5: {
				loadAllCargoJets();
				break;
			}
			case 6: {
				dogfight();
				break;
			}
			case 7: {
				addJetToFleet();
				break;
			}
			case 8: {
				removeJetFromFleet();
				break;
			}
			case 9: {
				// if user selects quit, program will exit the loop
				quit = true;
				System.out.println("Goodbye 🛫 ");
				break;
			}
			default: {
				// print bad input
				System.out.println("Please select a valid number");
			}
			}
		}
	}

	private void listFleet() {
		airfield.listAllJets();
	}

	private void flyAllJets() {
		ArrayList<Jet> hangar = airfield.getHangar();
		for (int i = 0; i < hangar.size(); i++) {
			Jet eachJet = hangar.get(i);
			eachJet.fly();
		}
	}

	private void viewFastestJet() {
		Jet fastestJet = null;
		ArrayList<Jet> hangar = airfield.getHangar();
		for (int i = 0; i < hangar.size(); i++) {
			Jet eachJet = hangar.get(i);
			if (fastestJet == null || eachJet.getSpeed() > fastestJet.getSpeed()) {
				fastestJet = eachJet;
			}
		}
		if (fastestJet != null)
			System.out.println(fastestJet);
		else
			System.out.println(" No jets in the hangar.");
	}

	private void viewJetWithLongestRange() {
		Jet longestJet = null;
		ArrayList<Jet> hangar = airfield.getHangar();
		for (int i = 0; i < hangar.size(); i++) {
			Jet eachJet = hangar.get(i);
			if (longestJet == null || eachJet.getRange() > longestJet.getRange()) {
				longestJet = eachJet;
			}
		}
		if (longestJet != null)
			System.out.println(longestJet);
		else
			System.out.println(" No jets in the hangar.");
	}

	private void loadAllCargoJets() {
		ArrayList<Jet> hangar = airfield.getHangar();
		for (int i = 0; i < hangar.size(); i++) {
			Jet eachJet = hangar.get(i);
			if (eachJet instanceof CargoCarrier) {
				CargoCarrier cc = (CargoCarrier) eachJet;
				cc.loadCargo();
			}
		}
	}

	private void dogfight() {
		ArrayList<Jet> hangar = airfield.getHangar();
		for (int i = 0; i < hangar.size(); i++) {
			Jet eachJet = hangar.get(i);
			// Casts jet into combat ready into an interface instance
			if (eachJet instanceof CombatReady) {
				CombatReady cr = (CombatReady) eachJet;
				cr.fight();
			}
		}
	}

	private void addJetToFleet() {
		System.out.println();
		System.out.print("Please input type of jet (Fighter/Cargo/Jet): ");
		String type = scanIn.nextLine();

		System.out.print("Please input model of jet: ");
		String model = scanIn.nextLine();

		System.out.print("Please input speed (mph) of jet: ");
		double speed = scanIn.nextDouble();
		scanIn.nextLine();
		
		System.out.print("Please input range (mi) of jet: ");
		int range = scanIn.nextInt();
		scanIn.nextLine();

		System.out.print("Please input price (USD) of jet: ");
		long price = scanIn.nextLong();
		scanIn.nextLine();

		addTypedJet(type, model, speed, range, price);

	}

	private void removeJetFromFleet() {
		ArrayList<Jet> hangar = airfield.getHangar();
		if (hangar.size() <= 0) {
			System.out.println("There is nothing to remove. ");
			return;
		}
		listFleet();
		System.out.print("Please select jet number you would like to remove: ");
		int index = scanIn.nextInt();
		Jet j = hangar.get(index);
		airfield.removeJet(index);
		System.out.println("You have removed " + j);
	}

	private void launch() {
		// TODO Auto-generated method stub
		loadJets();
		menu();
	}

}
