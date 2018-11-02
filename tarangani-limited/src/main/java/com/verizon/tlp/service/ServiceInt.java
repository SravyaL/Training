package com.verizon.tlp.service;

import java.util.List;


import com.verizon.tlp.model.ServicePack;

public interface ServiceInt {

	ServicePack getServiceByTitle(String title);
	List<ServicePack> getAllServices();
	
	
	boolean existsBySpeed(long speed);
	boolean existsByMaxUsage(long maxUsage);
	boolean existsByChargePM(long chargePM);
	
	ServicePack findBySpeed(long speed);
	ServicePack findByMaxUsage(long maxUsage);
	ServicePack findByChargePM(long chargePM);
	
	
}
