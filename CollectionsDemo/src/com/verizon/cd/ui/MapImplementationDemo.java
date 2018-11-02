package com.verizon.cd.ui;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapImplementationDemo {

	public static void main(String[] args) {
		Map<String, Double> map1 = new HashMap<>();
		Map<String, Double> map2 = new LinkedHashMap<>();
		Map<String, Double> map3 = new TreeMap<>();
		
		map1.put("Oranges", 1024.0);
		map1.put("Oranges", 124.0);
		map1.put("Bananas", 2024.0);
		map1.put("Grapes", 3024.0);
		map1.put("Apples", 4024.0);
		map1.put(null, 1.0);

		map2.put("Oranges", 1024.0);
		map2.put("Oranges", 124.0);
		map2.put("Bananas", 2024.0);
		map2.put("Grapes", 3024.0);
		map2.put("Apples", 4024.0);
		map2.put(null, 1.0);

		
		map3.put("Oranges", 1024.0);
		map3.put("Oranges", 124.0);
		map3.put("Bananas", 224.0);
		//map3.put(null, 1.0);

		map3.put("Grapes", 3024.0);
		map3.put("Apples", 024.0);
		
		for(String key: map1.keySet()){
			System.out.println(key + "\t"+ map1.get(key));	
		}
		System.out.println("");
		
		for(String key: map2.keySet()){
			System.out.println(key + "\t"+ map2.get(key));	
		}
		System.out.println("");
		
		for(String key: map3.keySet()){
			System.out.println(key + "\t"+ map3.get(key));	
		}
		System.out.println("");
	}

}
