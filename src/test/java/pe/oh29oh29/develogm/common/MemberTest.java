package pe.oh29oh29.develogm.common;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.oh29oh29.develogm.model.Member;
import pe.oh29oh29.develogm.repository.MemberOptionsRepository;
import pe.oh29oh29.develogm.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberTest {

    protected Member mockMember;

    protected static List<Member> mockMemberList;

    @Autowired
    protected MemberRepository memberRepository;

    @Autowired
    protected MemberOptionsRepository memberOptionsRepository;

    @BeforeClass
    public static void beforeClass() {
        mockMemberList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Member mockMember = new Member();
            mockMember.setId("testId" + i);
            mockMember.setPasswd("1234");
            mockMember.setEmail("testEmail" + i);
            mockMember.setName("testName" + i);
            mockMember.setRole("TEST_ROLE");
            mockMember.setSignUpDate("20181201000000");
            mockMemberList.add(mockMember);
        }
    }

    @Before
    public void setUp() {
        memberRepository.deleteAll();
        memberOptionsRepository.deleteAll();
        mockMember = mockMemberList.get(0);
    }

}
