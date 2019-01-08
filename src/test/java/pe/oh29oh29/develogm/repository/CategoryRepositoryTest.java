package pe.oh29oh29.develogm.repository;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pe.oh29oh29.develogm.common.CategoryTest;
import pe.oh29oh29.develogm.model.Category;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CategoryRepositoryTest extends CategoryTest {

    @Autowired
    CategoryRepository repository;

    @Before
    public void before() {
        repository.deleteAll();
    }

    @Test
    public void insert() {
        Category mockCategory = mockCategoryList.get(0);
        Category savedCategory = repository.save(mockCategory);

        assertEquals(mockCategory.getName(), savedCategory.getName());
        assertEquals(mockCategory.getOrdering(), savedCategory.getOrdering());
    }

    @Test
    public void findAll() {
        Category mockCategory = mockCategoryList.get(0);
        repository.save(mockCategory);

        List<Category> category = repository.findAll();
        assertEquals(1, category.size());
    }

    @Test
    public void update() {
        Category mockCategory = mockCategoryList.get(0);
        Category insertedCategory = repository.save(mockCategory);

        Category mockCategory2 = new Category();
        mockCategory2.setId(insertedCategory.getId());
        mockCategory2.setName("updateName");
        mockCategory2.setOrdering(insertedCategory.getOrdering());
        Category updatedCategory = repository.save(mockCategory2);

        assertEquals(mockCategory2.getName(), updatedCategory.getName());
        assertEquals(mockCategory.getOrdering(), updatedCategory.getOrdering());
    }

    @Test
    public void delete() {
        Category mockCategory = mockCategoryList.get(0);
        Category insertedCategory = repository.save(mockCategory);

        Category category = repository.findById(insertedCategory.getId()).orElse(null);
        assertEquals(insertedCategory.getId(), category.getId());

        repository.deleteById(category.getId());
        Category deletedCategory = repository.findById(category.getId()).orElse(null);
        assertNull(deletedCategory);
    }
}
