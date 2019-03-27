package pe.oh29oh29.develogm.controller.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.develogm.model.Member;
import pe.oh29oh29.develogm.model.request.MemberReq;
import pe.oh29oh29.develogm.model.response.MemberRes;
import pe.oh29oh29.develogm.service.MemberService;

@RestController
public class MMemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/sign-up")
    public ResponseEntity<MemberRes> signUp(@RequestBody Member member) {

        MemberRes memberRes = new MemberRes();

        memberService.signUp(member);

        return ResponseEntity.ok(memberRes);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<MemberRes> signIn(MemberReq memberReq) {
//        return ResponseEntity.ok(memberService.signIn(memberReq));
        return null;
    }

    @GetMapping("/check-id")
    public ResponseEntity<MemberRes> checkId(MemberReq memberReq) {
        return ResponseEntity.ok(memberService.existId(memberReq));
    }

}
