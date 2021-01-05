package api.REST;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.entitys.User;

@RestController
@RequestMapping("users")
public class ProductsRESTS {
	
	@GetMapping
	public ResponseEntity<User> getUser(){
		User user = new User();
		//get data from mysql
		return ResponseEntity.ok(user);
		
	}
	
	//@GetMapping //localhost:8080
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello world";
	}
	
	
}
