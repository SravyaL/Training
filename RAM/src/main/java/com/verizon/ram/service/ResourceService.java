package com.verizon.ram.service;

import java.util.List;

import com.verizon.ram.model.Resourcer;

public interface ResourceService {
	
	List<Resourcer> getAllResources();
	
	Resourcer addResource(Resourcer resources);
	
	Resourcer findByRid(long rid);
	
	Resourcer getResourceByRid(long rid);
}
