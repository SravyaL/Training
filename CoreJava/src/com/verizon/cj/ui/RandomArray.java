package com.verizon.cj.ui;

import java.util.Scanner;

import java.time.*;

public class RandomArray {
	public static void main(String[] args){
		//Time time = new java.time.format("HH-MM-SS");
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of ele: ");
		int count = s.nextInt();
		int nums[] = new int[count];
		
		for(int i=0;i<count;i++){
			nums[i]= (int)(Math.random()*100);
		}
		int sum=0, min = nums[0], max = nums[0];
		for(int x:nums){
			if(x<min){
				min =x; //Math.min(min,x)
			}
			if(x>max){
				max = x; //Math.max(max,x)
			}
			sum+=x;
			System.out.println(x);
		}
		System.out.println("sum: "+ sum);
		System.out.println("Max and Min: "+max+" "+min);
	}
}
