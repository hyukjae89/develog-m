package pe.oh29oh29.develogm.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import pe.oh29oh29.develogm.common.UserTest;
import pe.oh29oh29.develogm.model.User;
import pe.oh29oh29.develogm.repository.UserRepository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserServiceTest extends UserTest {

    @Autowired
    UserRepository repository;

    @Before
    public void before() {
        repository.deleteAll();
    }

    @Test
    public void existId() {
        User mockUser = mockUserList.get(2);
        User savedUser = repository.save(mockUser);

        User existUser = new User();
        existUser.setId(savedUser.getId());
        boolean result = repository.count(Example.of(existUser)) > 0 ? true : false;

        User notExistUser = new User();
        notExistUser.setId("notExistUserId");
        boolean result2 = repository.count(Example.of(notExistUser)) > 0 ? true : false;

        assertTrue(result);
        assertFalse(result2);
    }

    @Test
    public void signUp() {

    }

}
