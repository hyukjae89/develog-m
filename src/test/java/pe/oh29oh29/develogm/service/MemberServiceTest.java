package pe.oh29oh29.develogm.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import pe.oh29oh29.develogm.common.MemberTest;
import pe.oh29oh29.develogm.model.Member;
import pe.oh29oh29.develogm.repository.MemberRepository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MemberServiceTest extends MemberTest {

    @Autowired
    MemberRepository repository;

    @Before
    public void before() {
        repository.deleteAll();
    }

    @Test
    public void existId() {
        Member mockMember = mockMemberList.get(2);
        Member savedMember = repository.save(mockMember);

        Member existMember = new Member();
        existMember.setId(savedMember.getId());
        boolean result = repository.count(Example.of(existMember)) > 0 ? true : false;

        Member notExistMember = new Member();
        notExistMember.setId("notExistUserId");
        boolean result2 = repository.count(Example.of(notExistMember)) > 0 ? true : false;

        assertTrue(result);
        assertFalse(result2);
    }

    @Test
    public void signUp() {

    }

}
