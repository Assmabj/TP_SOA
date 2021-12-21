package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDto;
import com.example.exception.NotFoundException;
import com.example.model.User;
import com.example.repository.UserRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController {
	private static final Logger logger = LogManager.getLogger(UserController.class);

	
	@Autowired
	UserRepo userRepository;
	

	
	
	@GetMapping("")
	public List<User> list() {
		List<User> u = userRepository.findAll();
		for (User user : u) {
			logger.debug("log:     "+user);
			System.out.println("sysout:   "+user);
			
		}
        return u;
	    
	}

	@PostMapping("")
	public User create( @RequestBody UserDto userDto) {
	    User user = (new User())
	    		.setEmail(userDto.getEmail())
                .setPassword(userDto.getPassword());
		return userRepository.save(user);
	}

	
	@GetMapping("/{id}")
	public User get(@PathVariable(value = "id") Long Id) {
	    return userRepository.findById(Id).orElseThrow(() -> new NotFoundException("user not found"));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId) {
	    User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("user not found"));
	    
	    userRepository.delete(user);

	    return ResponseEntity.ok().build();
	}
	
	@PatchMapping("/{id}")
	public User update(@PathVariable(value = "id") Long Id,
	                                         @RequestBody UserDto userDto) {

	    User user =userRepository.findById(Id).orElseThrow(() -> new NotFoundException("user not found"));
	    
	     user.setEmail(userDto.getEmail());
	     user.setPassword(userDto.getPassword());
	     
	    User updatedUser = userRepository.save(user);
	    return updatedUser;
	}
	
	@PutMapping("/{id}")
	public User updateall(@PathVariable(value = "id") Long Id,
	                                         @RequestBody User userUp) {

	    User user =userRepository.findById(Id).orElseThrow(() -> new NotFoundException("user not found"));
	    
	     user.setEmail(userUp.getEmail());
	     user.setPassword(userUp.getPassword());
	     user.setFirstname(userUp.getFirstname());
	     user.setLastname(userUp.getLastname());
	     
	    User updatedUser = userRepository.save(user);
	    return updatedUser;
	}
}