package api.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.DAO.UserDAO;
import api.entitys.User;

@RestController
@RequestMapping("/")
public class UsersRESTS {
	@Autowired
	private UserDAO userDAO;
	
	//find all active users
	@GetMapping
	public ResponseEntity<List<User>> getUsers(){
		try {
			List<User> users = userDAO.findByFlagTrue();
			return ResponseEntity.ok(users);
		}
		catch (Exception e) {
			throw new RuntimeException("Error to many requests");
		}	
	}
	
	// find cities that start with x
	@RequestMapping(value="{cityName}")
	public ResponseEntity<List<String>> getCities(@PathVariable("cityName") String cityName){
		try {
			List<String> cities = userDAO.findNames(cityName);
			if (!cities.isEmpty()) {
				return ResponseEntity.ok(cities);
			}
			else {
				return ResponseEntity.noContent().build();
			}
		}
		catch (Exception e) {
			throw new RuntimeException("Error to many requests");
		}
		
	}
	
	@RequestMapping(value="/asc")
	public ResponseEntity<List<User>> UsersAsc(){
		try {
			List<User> users = userDAO.findAllByOrderByIdAsc();
			return ResponseEntity.ok(users);
		}
		catch (Exception e) {
			throw new RuntimeException("Error to many requests");
		}
		
	}
	
	@RequestMapping(value="/desc")
	public ResponseEntity<List<User>> UsersDesc(){
		List<User> users = userDAO.findAllByOrderByIdDesc();
		return ResponseEntity.ok(users);
	}
	
	
	@PostMapping ResponseEntity<User> createUser(@RequestBody User user){
		User newUser =  userDAO.save(user);
		return ResponseEntity.ok(newUser);
	}
	
	
}
