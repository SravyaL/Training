package com.verizon.ram.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.ram.model.Resourcer;
import com.verizon.ram.service.ResourceService;

@RestController
@CrossOrigin
@RequestMapping("/resource")
public class ResourceApi {

	@Autowired
	private ResourceService rs;
	
	@GetMapping
	public ResponseEntity<List<Resourcer>> getAllResources() {
		return new ResponseEntity<>(rs.getAllResources(), HttpStatus.OK);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Resourcer> getResourcerByRefid(@PathVariable("id") long rid) {
		ResponseEntity<Resourcer> resp;
		Resourcer c = rs.getResourceByRid(rid);
		if (c == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(c, HttpStatus.OK);
		return resp;
	}
	
	
	@PostMapping
	public ResponseEntity<Resourcer> addCustomer(@RequestBody Resourcer resource) {
		ResponseEntity<Resourcer> resp = null;

		
		if (resp == null) {
			Resourcer c = rs.addResource(resource);
			if (c == null)
				resp = new ResponseEntity<Resourcer>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Resourcer>(c, HttpStatus.OK);
		}
		return resp;
	}
}
