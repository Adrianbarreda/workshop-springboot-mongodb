package com.adrianbarreda.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adrianbarreda.workshopmongo.domain.User;
import com.adrianbarreda.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		/*List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());*/
		return ResponseEntity.ok().body(list);
	}

}
