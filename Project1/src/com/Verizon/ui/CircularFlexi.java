package com.Verizon.ui;

public class CircularFlexi implements FlexyBanner {
	//public static final double PIE = 3.14;
	private double radius;
	
	public CircularFlexi(int radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI*Math.pow(radius, 2);
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*Math.PI*radius;
	}

	@Override
	public String toString() {
		return "CircularFlexi [radius=" + radius + "]";
	}

}
