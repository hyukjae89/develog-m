package pe.oh29oh29.develogm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/sign-up")
    public String signUpView() {
        return "html/member/signUp";
    }

    @PostMapping("/sign-up")
    public String signUp() {
        return null;
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

    @GetMapping("/checkDuplicatedId")
    public String checkDuplicatedId() {
        return null;
    }

}
