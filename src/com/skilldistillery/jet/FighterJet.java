package com.skilldistillery.jet;

public class FighterJet extends Jet implements CombatReady{

	public FighterJet(String model, double speed, int range, long price) {
		super(model,speed,range,price);
	}
		//method stub to fill out
	@Override
	public void fight() {
		System.out.println(getModel() + " is now armed and ready to fight. ");
		// TODO Auto-generated method stub
		
	}

}
