package pe.oh29oh29.develogm.common;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.oh29oh29.develogm.model.User;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    protected static List<User> mockUserList;

    @BeforeClass
    public static void beforeClass() {
        mockUserList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User mockUser = new User();
            mockUser.setId("testId" + i);
            mockUser.setPasswd("1234");
            mockUser.setEmail("testEmail" + i);
            mockUser.setName("testName" + i);
            mockUser.setSignUpDate("20181201000000");
            mockUserList.add(mockUser);
        }
    }

}
