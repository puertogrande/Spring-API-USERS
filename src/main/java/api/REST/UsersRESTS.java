package api.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers(){
		User user = new User();
		//get data from mysql
		List<User> users = userDAO.findAll();
		return ResponseEntity.ok(users);
		
	}
	
	//@GetMapping //localhost:8080
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello world";
	}
	
	
}
