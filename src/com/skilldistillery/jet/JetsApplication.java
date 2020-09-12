package com.skilldistillery.jet;

//import com.skilldistillery.polymorphism.labs.vehicles.Automobile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
				Double speed = 0.0;
				Integer range = 0;
				Long price = (long) 0;
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

				if (type.contentEquals("Fighter")) {
					FighterJet newJet = new FighterJet(model, speed, range, price);
					airfield.AddJet(newJet);
				} else if (type.contentEquals("Cargo")) {
					CargoPlane newJet = new CargoPlane(model, speed, range, price);
					airfield.AddJet(newJet);
				} else if (type.contentEquals("Jet")) {
					JetImpl newJet = new JetImpl(model, speed, range, price);
					airfield.AddJet(newJet);
				} else { // error
				}
			}
		} catch (IOException e) {
			System.err.println(e);
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
				viewJetWithLongestRange();
				break;
			}
			case 4: {
				loadAllCargoJets();
				break;
			}
			case 5: {
				viewFastestJet();
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
	}

	private void viewJetWithLongestRange() {
	}

	private void loadAllCargoJets() {
	}

	private void viewFastestJet() {
	}

	private void dogfight() {
	}

	private void addJetToFleet() {
	}

	private void removeJetFromFleet() {
	}

	private void launch() {
		// TODO Auto-generated method stub
		loadJets();
		menu();
	}

}
