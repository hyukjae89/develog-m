package pe.oh29oh29.develogm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.oh29oh29.develogm.model.Category;
import pe.oh29oh29.develogm.model.response.CategoryResponseCode;
import pe.oh29oh29.develogm.model.response.Response;
import pe.oh29oh29.develogm.service.CategoryService;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public String categoryManagementView(Model model) {
        model.addAttribute("categories", categoryService.getCategories());
        return "admin/categories";
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<Response> addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
        return ResponseEntity.ok(new Response(CategoryResponseCode.SUCCESS));
    }

    @DeleteMapping("")
    @ResponseBody
    public ResponseEntity<Response> deleteCategory(@RequestBody String id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(new Response(CategoryResponseCode.SUCCESS));
    }
}
