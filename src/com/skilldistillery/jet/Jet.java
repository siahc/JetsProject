package com.skilldistillery.jet;

public abstract class Jet {
	private String model;
	private double speed;
	private int range;
	private long price;


	public Jet(String model, double speed, int range,long price ) {
		this.model = model;
	    this.speed = speed;
	    this.range = range;
	    this.price = price;

	}
	public void fly() {
		// ???
		System.out.println(this);
		System.out.println("This jet will run out of fuel once it has traveled " + speed/range + " hours.");
		// prints out the jet details and the amount of time 
		// the jet can fly until it runs out of fuel (based on
		// speed and range).
		
	}

	double getSpeedInMPH() {
		return speed;  // Speed is input in mph
	}
	
	double getSpeedInMach() {
		return speed / 767;  
	}

	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public double getSpeed() {
		return speed;
	}


	public void setSpeed(double speed) {
		this.speed = speed;
	}


	public int getRange() {
		return range;
	}


	public void setRange(int range) {
		this.range = range;
	}


	public long getPrice() {
		return price;
	}


	public void setPrice(long price) {
		this.price = price;
	}

	public String toString() {
		return String.format("%s: %.2fmph (mach %.2f) %dmi $%d", model, speed, getSpeedInMach(), range, price);
	}
}
