package pe.oh29oh29.develogm.repository;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pe.oh29oh29.develogm.common.MemberTest;
import pe.oh29oh29.develogm.model.Member;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberRepositoryTest extends MemberTest {

    @Test
    public void t1_insert() {
        // test code
        Member insertedCategory = memberRepository.save(mockMember);

        // verification
        assertEquals(mockMember.getId(), insertedCategory.getId());
        assertEquals(mockMember.getPasswd(), insertedCategory.getPasswd());
        assertEquals(mockMember.getName(), insertedCategory.getName());
        assertEquals(mockMember.getSignUpDate(), insertedCategory.getSignUpDate());
        mockMember = insertedCategory;
    }

    @Test
    public void t2_findAll() {
        // init
        t1_insert();

        // test code
        List<Member> memberList = memberRepository.findAll();

        // verification
        assertEquals(1, memberList.size());
    }

    @Test
    public void t3_findById() {
        // init
        t1_insert();

        // test code
        Member member = memberRepository.findById(mockMember.getId()).orElse(null);

        // verification
        assertNotNull(member);
        assertEquals(mockMember.getId(), member.getId());
    }

    @Test
    public void t4_update() {
        // init
        t1_insert();
        Member mockMember2 = new Member();
        mockMember2.setId(mockMember.getId());
        mockMember2.setPasswd("UPDATE_PASSWD");
        mockMember2.setName("UPDATE_NAME");
        mockMember2.setEmail("UPDATE_EMAIL");
        mockMember2.setRole("UPD_ROLE");
        mockMember2.setSignUpDate("1000");

        // test code
        Member updatedMember = memberRepository.save(mockMember2);

        // verification
        assertEquals(mockMember2.getId(), updatedMember.getId());
        assertEquals(mockMember2.getPasswd(), updatedMember.getPasswd());
        assertEquals(mockMember2.getName(), updatedMember.getName());
        assertEquals(mockMember2.getEmail(), updatedMember.getEmail());
    }

    @Test
    public void t5_delete() {
        // init
        t1_insert();
        String id = mockMember.getId();

        // test code
        memberRepository.deleteById(id);

        // verification
        assertEquals(0, memberRepository.count());
    }
}
