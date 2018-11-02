package com.verizon.cd.service;

public class Swapper<T> {
	public void doSwap(T var1, T var2){
		System.out.println("Before Swapping: "+var1+" "+var2);
		T temp = var1;
		var1 = var2;
		var2 = temp;
		System.out.println("After Swapping: "+var1+" "+var2);

	}

}
