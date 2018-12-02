package pe.oh29oh29.develogm.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.oh29oh29.develogm.model.Member;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;

    private static List<Member> mockMemberList;

    @BeforeClass
    public static void beforeClass() {
        mockMemberList = new ArrayList<Member>();
        for (int i = 0; i < 10; i++) {
            Member mockMember = new Member();
            mockMember.setId("testId" + i);
            mockMember.setEmail("testEmail" + i);
            mockMember.setName("testName" + i);
            mockMember.setRegDate("20181201000000");
            mockMemberList.add(mockMember);
        }
    }

    @Before
    public void before() {
        repository.deleteAll();
    }

    @Test
    public void signUp() {
        Member mockMember = mockMemberList.get(0);
        Member savedMember = repository.save(mockMember);

        assertEquals(mockMember.getId(), savedMember.getId());
        assertEquals(mockMember.getEmail(), savedMember.getEmail());
        assertEquals(mockMember.getName(), savedMember.getName());
        assertEquals(mockMember.getRegDate(), savedMember.getRegDate());
    }

    @Test
    public void findAll() {
        Member mockMember = mockMemberList.get(0);
        repository.save(mockMember);

        List<Member> members = repository.findAll();
        assertEquals(1, members.size());
    }

    @Test
    public void findOne() {
        Member mockMember = mockMemberList.get(0);
        repository.save(mockMember);

        Member member = repository.findById(mockMember.getId()).orElse(null);
        assertEquals(mockMember.getId(), member.getId());
    }

    @Test
    public void update() {
        Member mockMember = mockMemberList.get(0);
        repository.save(mockMember);

        Member mockMember2 = new Member();
        mockMember2.setId(mockMember.getId());
        mockMember2.setEmail(mockMember.getEmail());
        mockMember2.setName("updateName");
        mockMember2.setRegDate(mockMember.getRegDate());
        Member updatedMember = repository.save(mockMember2);

        assertEquals(mockMember.getId(), updatedMember.getId());
        assertEquals(mockMember.getEmail(), updatedMember.getEmail());
        assertEquals(mockMember2.getName(), updatedMember.getName());
        assertEquals(mockMember.getRegDate(), updatedMember.getRegDate());
    }

    @Test
    public void delete() {
        Member mockMember = mockMemberList.get(0);
        repository.save(mockMember);

        Member member = repository.findById(mockMember.getId()).orElse(null);
        assertEquals(mockMember.getId(), member.getId());

        repository.deleteById(member.getId());
        Member deletedMember = repository.findById(member.getId()).orElse(null);
        assertNull(deletedMember);
    }
}
