package pe.oh29oh29.develogm.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pe.oh29oh29.develogm.model.MemberForSecurity;

@Data
@ToString
@NoArgsConstructor
public class MemberRes {

    public MemberRes(MemberForSecurity memberForSecurity) {
        this.id = memberForSecurity.getUsername();
        this.name = memberForSecurity.getName();
        this.email = memberForSecurity.getEmail();
        this.role = memberForSecurity.getAuthorities().iterator().next().getAuthority();
    }

    public MemberRes(MemberForSecurity memberForSecurity, String accessToken) {
        this.id = memberForSecurity.getUsername();
        this.name = memberForSecurity.getName();
        this.email = memberForSecurity.getEmail();
        this.role = memberForSecurity.getAuthorities().iterator().next().getAuthority();
        this.accessToken = accessToken;
    }

    // 로그인
    private String id;
    private String name;
    private String email;
    private String role;
    private String accessToken;

    // 회원가입 > 중복 아이디 확인
    private boolean existId;

}
