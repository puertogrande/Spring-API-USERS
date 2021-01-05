package api.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import api.entitys.User;

public interface UserDAO extends JpaRepository<User, Long>{
	
	 List<User> findByFlagTrue();
	 
	 /*@Query("SELECT u.city FROM User u WHERE u.city LIKE (:cityName,'%')")
	 List<String> findCitiesWithPartOfName(@Param("cityName") String cityName);*/
	 
	 @Query("SELECT u.city FROM User u where u.city = :cityName") 
	    List<String> findNames(@Param("cityName") String cityName);
	 
	
}
