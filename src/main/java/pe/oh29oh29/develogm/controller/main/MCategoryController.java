package pe.oh29oh29.develogm.controller.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.develogm.model.response.CategoryRes;
import pe.oh29oh29.develogm.service.CategoryService;

import java.util.List;

@RestController
public class MCategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<CategoryRes>> getCategories () {
        return ResponseEntity.ok(categoryService.getCategories());
    }
}
