package pe.oh29oh29.develogm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import pe.oh29oh29.develogm.model.User;
import pe.oh29oh29.develogm.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public boolean existId(String id) {
        User newUser = new User();
        newUser.setId(id);
        return repository.count(Example.of(newUser)) > 0 ? true : false;
    }
}
