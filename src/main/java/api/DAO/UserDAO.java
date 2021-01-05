package api.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import api.entitys.User;

public interface UserDAO extends JpaRepository<User, Long>{
	
	 // retrieve all active users
	 List<User> findByFlagTrue();
	 
	 // retrieve not repeated cities that star with the indicated name
	 @Query("SELECT DISTINCT u.city FROM User u where u.city LIKE :cityName%") 
	    List<String> findNames(@Param("cityName") String cityName);
	 
	 List<User> findAllByOrderByIdDesc();
	 List<User> findAllByOrderByIdAsc();
	 
	
}
