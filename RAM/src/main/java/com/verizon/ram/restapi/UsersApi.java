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

import com.verizon.ram.model.Users;
import com.verizon.ram.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UsersApi {
	@Autowired
	private UserService us;
	
	@GetMapping
	public ResponseEntity<List<Users>> getAllUsers() {
		return new ResponseEntity<>(us.getAllUsers(), HttpStatus.OK);

	}
	
	@GetMapping("/admin/{id}")
	public ResponseEntity<Users> getUserByUid(@PathVariable("id") long uid) {
		ResponseEntity<Users> resp;
		Users u = us.getUserById(uid);
		if (u == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(u, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/manager/{id}")
	public ResponseEntity<List<Users>> getUserByMgrId(@PathVariable("id") long mid) {
		ResponseEntity<List<Users>> resp;
		List<Users> u = us.getUserByMgrId(mid);
		if (u == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(u, HttpStatus.OK);
		return resp;
	}
	
	@PostMapping
	public ResponseEntity<Users> addUser(@RequestBody Users user) {
		ResponseEntity<Users> resp = null;

		
		if (resp == null) {
			Users u = us.addUser(user);
			if (u == null)
				resp = new ResponseEntity<Users>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<>(u, HttpStatus.OK);
		}
		return resp;
	}
}
