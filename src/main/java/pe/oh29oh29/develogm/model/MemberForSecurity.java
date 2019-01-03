package pe.oh29oh29.develogm.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

public class MemberForSecurity extends User {

    private static final String ROLE_PREFIX = "ROLE_";

    public MemberForSecurity(Member member) {
        super(member.getId(), member.getPasswd(), makeGrantedAuthority(member.getRole()));
    }

    private static List<GrantedAuthority> makeGrantedAuthority(String role) {
        List<GrantedAuthority> list = new ArrayList();
        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role));
        return list;
    }
}
