package com.verizon.ram.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.ram.dao.ResourcerDao;
import com.verizon.ram.model.Resourcer;

@Service
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	private ResourcerDao rd;

	@Override
	public Resourcer addResource(Resourcer resources) {

		return rd.save(resources);
	}

	@Override
	public Resourcer findByRid(long rid) {
		
		return rd.findByRid(rid);
	}

	@Override
	public List<Resourcer> getAllResources() {
		return rd.findAll();
	}

	@Override
	public Resourcer getResourceByRid(long rid) {
		Resourcer resource=null;
//		if(rd.existsById(rid)){  // Data base is hit twice while searching and retrieving
//			Customer= rd.findById(rid).get();
//		}
		Optional<Resourcer> optCustomer=rd.findById(rid);
		if(optCustomer.isPresent()){// checking if data is available
			resource=optCustomer.get();// retrieve the data using .get
		}
		return resource;
	}

}
