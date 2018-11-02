package com.verizon.tlp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.verizon.tlp.model.ServicePack;

@Repository
public interface PlansRepository extends JpaRepository<ServicePack, String>{

	boolean existsBySpeed(long speed);
	boolean existsByMaxUsage(long maxUsage);
	boolean existsByChargePM(long chargePM);
	
	ServicePack findBySpeed(long speed);
	ServicePack findByMaxUsage(long maxUsage);
	ServicePack findByChargePM(long chargePM);
	
	//List<Contact> findAllByLastName(String lastName);
	
}
