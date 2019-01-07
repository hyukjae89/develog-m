package pe.oh29oh29.develogm.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("")
    public String homeView() {
        return "html/admin/home";
    }

    @GetMapping("/categories")
    public String categoryManagementView() {
        return "html/admin/menu/categories";
    }
}
