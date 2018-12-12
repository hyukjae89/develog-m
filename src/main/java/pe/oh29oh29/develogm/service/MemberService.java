package pe.oh29oh29.develogm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import pe.oh29oh29.develogm.model.Member;
import pe.oh29oh29.develogm.repository.MemberRepository;

@Service
public class MemberService {

    @Autowired
    MemberRepository repository;

    public boolean existId(String id) {
        Member newMember = new Member();
        newMember.setId(id);
        return repository.count(Example.of(newMember)) > 0 ? true : false;
    }
}
