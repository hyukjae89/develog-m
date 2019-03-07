package pe.oh29oh29.develogm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.oh29oh29.develogm.model.Category;
import pe.oh29oh29.develogm.model.response.CategoryResponseCode;
import pe.oh29oh29.develogm.model.response.Response;
import pe.oh29oh29.develogm.service.CategoryService;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Response> categoryManagementView(Model model) {
        System.out.println("test");
        model.addAttribute("categories", categoryService.getCategories());
        return ResponseEntity.ok(new Response(CategoryResponseCode.SUCCESS));
    }

    @PostMapping("")
    public ResponseEntity<Response> addCategory(Category category) {
        System.out.println(category.getName());
        categoryService.addCategory(category);
        return ResponseEntity.ok(new Response(CategoryResponseCode.SUCCESS));
    }

    @DeleteMapping("")
    public ResponseEntity<Response> deleteCategory(String id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(new Response(CategoryResponseCode.SUCCESS));
    }
}
