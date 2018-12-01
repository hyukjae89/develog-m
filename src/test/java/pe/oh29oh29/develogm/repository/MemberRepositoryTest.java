package pe.oh29oh29.develogm.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.oh29oh29.develogm.model.Member;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired MemberRepository repository;

    @Before
    public void beforeTest() {
        repository.deleteAll();
    }

    @Test
    public void insert() {
        Member member = new Member();
        member.setId("testId");
        member.setEmail("testEmail");
        member.setName("testName");
        member.setRegDate("2017");
        repository.save(member);
    }


    @Test
    public void findAll() {
        List<Member> members = repository.findAll();
        assertNull(members);
    }
}
