package pe.oh29oh29.develogm.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.oh29oh29.develogm.model.Category;
import pe.oh29oh29.develogm.model.response.CategoryResCode;
import pe.oh29oh29.develogm.model.response.Response;
import pe.oh29oh29.develogm.service.CategoryService;

@RestController
@RequestMapping("/admin/category")
public class ACategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Response> categoryManagementView(Model model) {
        model.addAttribute("categories", categoryService.getCategories());
        return ResponseEntity.ok(new Response(CategoryResCode.SUCCESS));
    }

    @PostMapping("")
    public ResponseEntity<Response> addCategory(Category category) {
        System.out.println(category.getName());
        categoryService.addCategory(category);
        return ResponseEntity.ok(new Response(CategoryResCode.SUCCESS));
    }

    @DeleteMapping("")
    public ResponseEntity<Response> deleteCategory(String id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(new Response(CategoryResCode.SUCCESS));
    }
}
