package com.verizon.tlp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.tlp.dao.PlansRepository;
import com.verizon.tlp.model.ServicePack;

@Service
public class ServiceIntImpl implements ServiceInt {
	
	@Autowired
	private PlansRepository serviceRepo;



//	@Override
//	public List<Contact> findAllByLastName(String lastName) {
//		return contactRepo.findAllByLastName(lastName);
//	}

	@Override
	public ServicePack getServiceByTitle(String title) {
		ServicePack serv = null;
		
		Optional<ServicePack> optService =serviceRepo.findById(title);
		if(optService.isPresent()) {
			serv = optService.get();
		}
		
		return serv;
	}

	@Override
	public List<ServicePack> getAllServices() {
		
		return serviceRepo.findAll();
	}

	@Override
	public boolean existsBySpeed(long speed) {
		return serviceRepo.existsBySpeed(speed);
	}

	@Override
	public boolean existsByMaxUsage(long maxUsage) {
		return serviceRepo.existsByMaxUsage(maxUsage);
	}

	@Override
	public boolean existsByChargePM(long chargePM) {
		return serviceRepo.existsByChargePM(chargePM);
	}

	@Override
	public ServicePack findBySpeed(long speed) {
		return serviceRepo.findBySpeed(speed);
	}

	@Override
	public ServicePack findByMaxUsage(long maxUsage) {
		
		return serviceRepo.findByMaxUsage(maxUsage);
	}

	@Override
	public ServicePack findByChargePM(long chargePM) {
		
		return serviceRepo.findByChargePM(chargePM);	}

}
