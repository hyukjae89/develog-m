package pe.oh29oh29.develogm.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.oh29oh29.develogm.model.Category;
import pe.oh29oh29.develogm.model.response.CategoryRes;
import pe.oh29oh29.develogm.model.response.Response;
import pe.oh29oh29.develogm.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
public class ACategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.addCategory(category));
    }

    @GetMapping("")
    public ResponseEntity<List<CategoryRes>> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @PatchMapping("")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.updateCategory(category));
    }

    @DeleteMapping("")
    public ResponseEntity deleteCategory(String id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }


}
