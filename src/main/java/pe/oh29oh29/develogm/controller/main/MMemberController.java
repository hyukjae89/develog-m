package pe.oh29oh29.develogm.controller.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.oh29oh29.develogm.model.Member;
import pe.oh29oh29.develogm.model.response.MemberResCode;
import pe.oh29oh29.develogm.model.response.Response;
import pe.oh29oh29.develogm.service.MemberService;

@RestController
public class MMemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/sign-up")
    public String signUp(Member member) {
        memberService.signUp(member);
        return "redirect:/";
    }

    @PostMapping("/sign-in")
    public String signIn() {
        return null;
    }

    @GetMapping("/check-id")
    public ResponseEntity<Response> checkId(@RequestParam String id) {
        int code;
        if (memberService.existId(id)) {
            code = MemberResCode.EXIST_ID;
        } else {
            code = MemberResCode.NOT_EXIST_ID;
        }

        return ResponseEntity.ok(new Response(code));
    }

}
