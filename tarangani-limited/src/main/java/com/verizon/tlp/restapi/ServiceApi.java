package com.verizon.tlp.restapi;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.tlp.model.ServicePack;

import com.verizon.tlp.service.ServiceInt;

@RestController
@CrossOrigin
@RequestMapping("/services")
public class ServiceApi {

	@Autowired
	private ServiceInt service;

	@GetMapping
	public ResponseEntity<List<ServicePack>> getAllServices() {
		return new ResponseEntity<>(service.getAllServices(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ServicePack> getServiceById(@PathVariable("id") String title) {
		ResponseEntity<ServicePack> resp;
		ServicePack c = service.getServiceByTitle(title);
		if (c == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(c, HttpStatus.OK);
		return resp;
	}

	@GetMapping("/{field}/{srhValue}")
	public ResponseEntity<List<ServicePack>> getAllServices(@PathVariable("field") String fieldBy,
			@PathVariable("srhValue") long searchValue) {

		ResponseEntity<List<ServicePack>> resp = null;

		switch (fieldBy) {
		case "speed":
			ServicePack sBySpeed = service.findBySpeed(searchValue);
			if (sBySpeed != null) {
				resp = new ResponseEntity<>(Collections.singletonList(sBySpeed), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			break;
		case "maxUsage":
			ServicePack sByMaxUsage = service.findByMaxUsage(searchValue);
			if (sByMaxUsage != null) {
				resp = new ResponseEntity<>(Collections.singletonList(sByMaxUsage), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			break;
		case "chargePM":
			//List<Contact> results = service.findAllByLastName(searchValue);
			ServicePack sByChargePM = service.findByChargePM(searchValue);
			if (sByChargePM != null) {
				resp = new ResponseEntity<>(Collections.singletonList(sByChargePM), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
//			if (results != null && results.size() != 0) {
//				resp = new ResponseEntity<>(results, HttpStatus.OK);
//			} else {
//				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}
//			break;
//		default:
//			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//			break;
		}

		return resp;
	}

	


}
