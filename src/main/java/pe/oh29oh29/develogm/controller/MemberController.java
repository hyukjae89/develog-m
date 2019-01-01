package pe.oh29oh29.develogm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.oh29oh29.develogm.model.Member;
import pe.oh29oh29.develogm.model.MemberOptions;
import pe.oh29oh29.develogm.model.response.MemberResponseCode;
import pe.oh29oh29.develogm.model.response.Response;
import pe.oh29oh29.develogm.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/accept-terms")
    public String acceptTermsView() {
        return "html/member/acceptTerms";
    }

    @PostMapping("/accept-terms")
    public String acceptTerms() {
        return "redirect:/sign-up";
    }

    @GetMapping("/sign-up")
    public String signUpView() {
        return "html/member/signUp";
    }

    @PostMapping("/sign-up")
    public String signUp(Member member, MemberOptions memberOptions) {
        memberService.signUp(member, memberOptions);
        return "redirect:/";
    }

    @GetMapping("/sign-in")
    public String signInView() {
        return "html/member/signIn";
    }

    @PostMapping("/sign-in")
    public String signIn() {

        return null;
    }

    @GetMapping("/my-info")
    public String myInfoView() {
        return "html/member/myInfo";
    }

    @PatchMapping("/my-info")
    public String updateMyInfo() {
        return "html/member/myInfo";
    }

    @GetMapping("/check-id")
    @ResponseBody
    public ResponseEntity<Response> checkId(@RequestParam String id) {
        int code;
        if (memberService.existId(id)) {
            code = MemberResponseCode.EXIST_ID;
        } else {
            code = MemberResponseCode.NOT_EXIST_ID;
        }

        return ResponseEntity.ok(new Response(code));
    }

}
