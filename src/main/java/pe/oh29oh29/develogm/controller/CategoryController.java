package pe.oh29oh29.develogm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.oh29oh29.develogm.model.Category;
import pe.oh29oh29.develogm.service.CategoryService;

import java.util.List;

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
    public String addCategory(@RequestBody List<Category> category) {
        categoryService.addCategory(category);
        return "redirect:/admin/cateogires";
    }

    @DeleteMapping("")
    public String deleteCategory(String id) {
        categoryService.deleteCategory(id);
        return "redirect:/admin/cateogires";
    }

    @PatchMapping("")
    public String updateCategory(Category category) {
        categoryService.updateCategory(category);
        return "redirect:/admin/cateogires";
    }
}
