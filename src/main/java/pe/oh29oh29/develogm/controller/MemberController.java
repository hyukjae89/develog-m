package pe.oh29oh29.develogm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class MemberController {

    @GetMapping("/accept-terms")
    public String acceptTermsView() {
        return "html/user/acceptTerms";
    }

    @PostMapping("/accept-terms")
    public String acceptTerms() {
        return "redirect:/sign-up";
    }

    @GetMapping("/sign-up")
    public String signUpView() {
        return "html/user/signUp";
    }

    @PostMapping("/sign-up")
    public String signUp() {
        return null;
    }

    @GetMapping("/sign-in")
    public String signInView() {
        return "html/user/signIn";
    }

    @PostMapping("/sign-in")
    public String signIn() {
        return null;
    }

    @GetMapping("/my-info")
    public String myInfoView() {
        return "html/user/myInfo";
    }

    @PatchMapping("/my-info")
    public String updateMyInfo() {
        return "html/user/myInfo";
    }

    @GetMapping("/check-id")
    public String checkId() {
        return null;
    }

}
