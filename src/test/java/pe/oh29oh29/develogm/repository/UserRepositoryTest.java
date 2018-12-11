package pe.oh29oh29.develogm.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pe.oh29oh29.develogm.common.UserTest;
import pe.oh29oh29.develogm.model.User;

import java.util.List;

public class UserRepositoryTest extends UserTest {

    @Autowired
    UserRepository repository;

    @Before
    public void before() {
        repository.deleteAll();
    }

    @Test
    public void signUp() {
        User mockUser = mockUserList.get(0);
        User savedUser = repository.save(mockUser);

        assertEquals(mockUser.getId(), savedUser.getId());
        assertEquals(mockUser.getEmail(), savedUser.getEmail());
        assertEquals(mockUser.getName(), savedUser.getName());
        assertEquals(mockUser.getSignUpDate(), savedUser.getSignUpDate());
    }

    @Test
    public void findAll() {
        User mockUser = mockUserList.get(0);
        repository.save(mockUser);

        List<User> users = repository.findAll();
        assertEquals(1, users.size());
    }

    @Test
    public void findOne() {
        User mockUser = mockUserList.get(0);
        repository.save(mockUser);

        User user = repository.findById(mockUser.getId()).orElse(null);
        assertEquals(mockUser.getId(), user.getId());
    }

    @Test
    public void update() {
        User mockUser = mockUserList.get(0);
        repository.save(mockUser);

        User mockUser2 = new User();
        mockUser2.setId(mockUser.getId());
        mockUser2.setEmail(mockUser.getEmail());
        mockUser2.setName("updateName");
        mockUser2.setSignUpDate(mockUser.getSignUpDate());
        User updatedUser = repository.save(mockUser2);

        assertEquals(mockUser.getId(), updatedUser.getId());
        assertEquals(mockUser.getEmail(), updatedUser.getEmail());
        assertEquals(mockUser2.getName(), updatedUser.getName());
        assertEquals(mockUser.getSignUpDate(), updatedUser.getSignUpDate());
    }

    @Test
    public void delete() {
        User mockUser = mockUserList.get(0);
        repository.save(mockUser);

        User user = repository.findById(mockUser.getId()).orElse(null);
        assertEquals(mockUser.getId(), user.getId());

        repository.deleteById(user.getId());
        User deletedUser = repository.findById(user.getId()).orElse(null);
        assertNull(deletedUser);
    }
}
