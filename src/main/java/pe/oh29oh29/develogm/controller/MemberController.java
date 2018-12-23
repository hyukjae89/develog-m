package pe.oh29oh29.develogm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.oh29oh29.develogm.model.Member;
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
    public String signUp(Member member) {
        memberService.signUp(member);
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
    public String checkId() {
        return null;
    }

}
