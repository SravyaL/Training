package com.Verizon.ui;

public class FlexiEstimator {
	private double printCostPerUnit;
	private double fixingCostPerUnit;
	public FlexiEstimator(double printCostPerUnit, double fixingCostPerUnit) {
		super();
		this.printCostPerUnit = printCostPerUnit;
		this.fixingCostPerUnit = fixingCostPerUnit;
	}
	
	public double estimatePrintCost(FlexyBanner f){
		return f.getArea()*printCostPerUnit;
		
	}
	public double estimateFixingCost(FlexyBanner f){
		return f.getPerimeter()*fixingCostPerUnit;
	}
}
