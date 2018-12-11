package pe.oh29oh29.develogm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.oh29oh29.develogm.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
