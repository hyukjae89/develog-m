package pe.oh29oh29.develogm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.oh29oh29.develogm.model.Member;
import pe.oh29oh29.develogm.model.MemberForSecurity;
import pe.oh29oh29.develogm.repository.MemberRepository;

import java.util.Optional;

@Service
public class MemberService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    public boolean existId(String id) {
        Member newMember = new Member();
        newMember.setId(id);
        return memberRepository.count(Example.of(newMember)) > 0;
    }

    @Transactional
    public void signUp(Member member) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPasswd(passwordEncoder.encode(member.getPasswd()));
        member.setRole("USER");
        member.setSignUpDate("20181231000000");

        memberRepository.save(member);
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        return Optional.ofNullable(memberRepository.findById(id)).map(member -> new MemberForSecurity(member.get())).get();
    }

    public Member getMember(String id) {
        return memberRepository.getOne(id);
    }
}
