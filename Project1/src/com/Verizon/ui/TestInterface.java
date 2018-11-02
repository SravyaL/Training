package com.Verizon.ui;

public class TestInterface {

	public static void main(String[] args) {
		
		FlexiEstimator est= new FlexiEstimator(10, 5);
		
		RectangularFlexi r = new RectangularFlexi(5, 9);
		CircularFlexi c = new CircularFlexi(5);
		
		System.out.println(est.estimateFixingCost(r));
		System.out.println(est.estimateFixingCost(c));
		System.out.println(est.estimatePrintCost(r));
		System.out.println(est.estimatePrintCost(c));
		

	}

}
