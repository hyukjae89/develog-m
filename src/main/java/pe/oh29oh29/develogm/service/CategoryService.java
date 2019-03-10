package pe.oh29oh29.develogm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.oh29oh29.develogm.model.Category;
import pe.oh29oh29.develogm.model.response.CategoryRes;
import pe.oh29oh29.develogm.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PostService postService;

    public List<CategoryRes> getCategories() {
        List<Category> categories = categoryRepository.findAll(new Sort(Sort.Direction.ASC, "ordering"));
        List<CategoryRes> categoryResList = new ArrayList();
        categories.forEach(category -> {
            CategoryRes res = new CategoryRes();
            res.setId(category.getId());
            res.setName(category.getName());
            res.setDepth(category.getDepth());
            res.setOrdering(category.getOrdering());
            res.setVisible(category.isVisible());
            categoryResList.add(res);
        });

        return categoryResList;
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Transactional
    public void deleteCategory(String id) {
        postService.deletePostsByCategory(id);
        categoryRepository.deleteById(id);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

}
