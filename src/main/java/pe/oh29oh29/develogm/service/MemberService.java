package pe.oh29oh29.develogm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.oh29oh29.develogm.model.Member;
import pe.oh29oh29.develogm.model.MemberOptions;
import pe.oh29oh29.develogm.model.SecurityMember;
import pe.oh29oh29.develogm.repository.MemberOptionsRepository;
import pe.oh29oh29.develogm.repository.MemberRepository;

import java.util.Optional;

@Service
public class MemberService implements UserDetailsService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberOptionsRepository memberOptionsRepository;

    public boolean existId(String id) {
        Member newMember = new Member();
        newMember.setId(id);
        return memberRepository.count(Example.of(newMember)) > 0 ? true : false;
    }

    public void signUp(Member member, MemberOptions memberOptions) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPasswd(passwordEncoder.encode(member.getPasswd()));
        member.setRole("BASIC");
        member.setSignUpDate("20181231000000");
        memberOptions.setMemberId(member.getId());

        memberRepository.save(member);
        memberOptionsRepository.save(memberOptions);
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        return Optional.ofNullable(memberRepository.findById(id)).filter(member -> member != null).map(member -> new SecurityMember(member.get())).get();
    }
}
