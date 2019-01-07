package pe.oh29oh29.develogm.controller.admin.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

    @GetMapping("")
    public String categoryManagementView() {
        return "html/admin/menu/categories";
    }
}
