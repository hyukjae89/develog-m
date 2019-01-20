package pe.oh29oh29.develogm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pe.oh29oh29.develogm.model.Category;
import pe.oh29oh29.develogm.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll(new Sort(Sort.Direction.ASC, "ordering"));
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(String id) {
        categoryRepository.deleteById(id);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }
    
}
