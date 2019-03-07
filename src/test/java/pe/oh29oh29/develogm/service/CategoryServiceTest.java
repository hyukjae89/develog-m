package pe.oh29oh29.develogm.service;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pe.oh29oh29.develogm.common.CategoryTest;
import pe.oh29oh29.develogm.model.Category;

import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategoryServiceTest extends CategoryTest {

    @Test
    public void t1_addCategory() {
        // test code
        Category insertedCategory = categoryRepository.save(mockCategory);

        // verification
        assertEquals(mockCategory.getName(), insertedCategory.getName());
        assertEquals(mockCategory.getDepth(), insertedCategory.getDepth());
        assertEquals(mockCategory.getOrdering(), insertedCategory.getOrdering());
        assertEquals(mockCategory.isVisible(), insertedCategory.isVisible());
        mockCategory.setId(insertedCategory.getId());
    }

    @Test
    public void t2_getCategories() {
        // init
        t1_addCategory();

        // test code
        List<Category> categoryList = categoryRepository.findAll();

        // verification
        assertEquals(1, categoryList.size());
        assertEquals(mockCategory.getName(), categoryList.get(0).getName());
    }

    @Test
    public void t3_updateCategory() {
        // init
        t1_addCategory();
        Category categoryForUpdate = new Category();
        categoryForUpdate.setId(mockCategory.getId());
        categoryForUpdate.setName("UPDATE_NAME");
        categoryForUpdate.setDepth(100);
        categoryForUpdate.setOrdering(100);
        categoryForUpdate.setVisible(false);

        // test code
        Category updatedCategory = categoryRepository.save(categoryForUpdate);

        // verification
        assertEquals(categoryForUpdate.getName(), updatedCategory.getName());
        assertEquals(categoryForUpdate.getDepth(), updatedCategory.getDepth());
        assertEquals(categoryForUpdate.getOrdering(), updatedCategory.getOrdering());
        assertEquals(categoryForUpdate.isVisible(), updatedCategory.isVisible());
    }

    @Test
    public void t4_deleteCategory() {
        // init
        t1_addCategory();
        String id = mockCategory.getId();

        // test code
        categoryRepository.deleteById(id);

        // verification
        assertEquals(0, categoryRepository.count());
    }
}
