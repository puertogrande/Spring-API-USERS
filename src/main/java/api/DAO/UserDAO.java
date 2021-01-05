package api.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import api.entitys.User;

public interface UserDAO extends JpaRepository<User, Long>{

}
