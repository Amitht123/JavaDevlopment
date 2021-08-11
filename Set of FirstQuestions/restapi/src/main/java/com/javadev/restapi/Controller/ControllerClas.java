package com.javadev.restapi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javadev.restapi.Repo.UserRepo;
import com.javadev.restapi.Model.*;


@RestController
public class ControllerClas {
	
	@Autowired
	private UserRepo userRepo;

	@GetMapping(value = "allemployeeinfo")
	private List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	
	@PostMapping(value= "addEmployee")
	public String addEmployee(@RequestBody User user) {
		userRepo.save(user);
		return "Employee Details Added Successfully";
	}
	
	 @GetMapping("/viewemployee/{id}")
	    public Optional<User> getCompanyById(
	    @PathVariable(value = "id") long id)
	    {
	        return userRepo.findById(id);
	    }
	
	}

	

