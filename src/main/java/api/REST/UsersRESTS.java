package api.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.DAO.UserDAO;
import api.entitys.User;

@RestController
@RequestMapping("users")
public class UsersRESTS {
	@Autowired
	private UserDAO userDAO;
	
	//find all active users
	@GetMapping
	public ResponseEntity<List<User>> getUsers(){
		List<User> users = userDAO.findByFlagTrue();
		return ResponseEntity.ok(users);
	}
	
	// find cities that start with x
	@RequestMapping(value="{cityName}")
	public ResponseEntity<List<String>> getCities(@PathVariable("cityName") String cityName){
		List<String> cities = userDAO.findNames(cityName);
		return ResponseEntity.ok(cities);
	}
	
	
	
	
	
	
}
