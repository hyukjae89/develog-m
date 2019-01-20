package pe.oh29oh29.develogm.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pe.oh29oh29.develogm.common.MemberTest;
import pe.oh29oh29.develogm.model.Member;
import pe.oh29oh29.develogm.model.MemberOptions;
import pe.oh29oh29.develogm.repository.MemberOptionsRepository;
import pe.oh29oh29.develogm.repository.MemberRepository;

import java.util.Optional;

import static org.junit.Assert.*;

public class MemberServiceTest extends MemberTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberOptionsRepository memberOptionsRepository;

    @Before
    public void setUp() {
        memberOptionsRepository.deleteAll();
        memberRepository.deleteAll();
    }

    @Test
    public void existId() {
        // init
        Member mockMember = mockMemberList.get(0);
        mockMember.setRole("USER");
        Member savedMember = memberRepository.save(mockMember);

        // test code
        Member existMember = new Member();
        existMember.setId(savedMember.getId());
        boolean result = memberRepository.count(Example.of(existMember)) > 0;

        // verification
        Member notExistMember = new Member();
        notExistMember.setId("notExistMemberId");
        boolean result2 = memberRepository.count(Example.of(notExistMember)) > 0;

        assertTrue(result);
        assertFalse(result2);
    }

    @Test
    public void signUp() {
        // init
        Member mockMember = mockMemberList.get(0);
        MemberOptions mockMemberOptions = new MemberOptions();
        mockMemberOptions.setPasswdQuestion("password question");
        mockMemberOptions.setPasswdAnswer("password answer");

        // test code
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        mockMember.setPasswd(passwordEncoder.encode(mockMember.getPasswd()));
        mockMember.setRole("USER");
        mockMember.setSignUpDate("20181231000000");

        mockMemberOptions.setMemberId(mockMember.getId());

        memberRepository.save(mockMember);
        memberOptionsRepository.save(mockMemberOptions);

        // verification
        Member savedMember = Optional.ofNullable(memberRepository.findAll().get(0)).orElse(null);
        assertNotNull(savedMember);
        assertEquals(mockMember.getId(), savedMember.getId());
        assertEquals(mockMember.getName(), savedMember.getName());
        assertEquals(mockMember.getRole(), savedMember.getRole());
        assertEquals(mockMember.getEmail(), savedMember.getEmail());
        assertTrue(passwordEncoder.matches("1234", savedMember.getPasswd()));
    }
}
