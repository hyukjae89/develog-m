package pe.oh29oh29.develogm.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pe.oh29oh29.develogm.common.MemberTest;
import pe.oh29oh29.develogm.model.Member;

import java.util.List;

public class MemberRepositoryTest extends MemberTest {

    @Autowired
    MemberRepository repository;

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
        assertEquals(mockMember.getSignUpDate(), savedMember.getSignUpDate());
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
        mockMember2.setSignUpDate(mockMember.getSignUpDate());
        Member updatedMember = repository.save(mockMember2);

        assertEquals(mockMember.getId(), updatedMember.getId());
        assertEquals(mockMember.getEmail(), updatedMember.getEmail());
        assertEquals(mockMember2.getName(), updatedMember.getName());
        assertEquals(mockMember.getSignUpDate(), updatedMember.getSignUpDate());
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
