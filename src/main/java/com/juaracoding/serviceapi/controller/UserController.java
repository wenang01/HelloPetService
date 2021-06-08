package com.juaracoding.serviceapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.serviceapi.entity.User;
import com.juaracoding.serviceapi.payload.response.MessageResponse;
import com.juaracoding.serviceapi.repository.RoleRepository;
import com.juaracoding.serviceapi.repository.UserRepository;
import com.juaracoding.serviceapi.services.ModelUsers;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	ModelUsers modelUser;
	
	@Autowired
	UserRepository userRepo;

	@Autowired
	RoleRepository roleRepository;

	
	@GetMapping("/")
	public String indexUsers(Model model) {
		model.addAttribute("lstUsers", modelUser.getAllUser());
		return "List Users";
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
		if (userRepo.existsByUsername(user.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepo.existsByEmail(user.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User userAdd = new User(user.getName(), user.getUsername(), user.getEmail(),
				encoder.encode(user.getPassword()), user.getAddress_one(), user.getAddress_two(),
				user.getProvinces_id(), user.getRegencies_id(), user.getZip_code(),
				user.getCountry(), user.getPhone_number(), user.getBirthday(), user.getGender()
				 );

		userRepo.save(userAdd);

		return ResponseEntity.ok(new MessageResponse("User Added Successfully!"));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUsers(@PathVariable String id, @Valid @RequestBody User user) {
//		Optional<User> users = modelUser.getUserById(id);
		if (userRepo.existsByUsername(user.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepo.existsByEmail(user.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		user.setId(Long.parseLong(id));
		User userUpdate = new User(user.getName(), user.getUsername(), user.getEmail(),
				encoder.encode(user.getPassword()), user.getAddress_one(), user.getAddress_two(),
				user.getProvinces_id(), user.getRegencies_id(), user.getZip_code(),
				user.getCountry(), user.getPhone_number(), user.getBirthday(), user.getGender()
				 );
		user.setId(Long.parseLong(id));
		
		userRepo.save(userUpdate);
		return ResponseEntity.ok(new MessageResponse("User Updated Successfully!"));
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUsers(@PathVariable String id, Model model) {
		this.modelUser.deleteUser(id);
		return "User has been Deleted!";
	}
}
