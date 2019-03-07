package pe.oh29oh29.develogm.repository;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pe.oh29oh29.develogm.common.CategoryTest;
import pe.oh29oh29.develogm.model.Category;

import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategoryRepositoryTest extends CategoryTest {

    @Test
    public void t1_insert() {
        // test code
        Category insertedCategory = categoryRepository.save(mockCategory);

        // verification
        assertEquals(mockCategory.getName(), insertedCategory.getName());
        assertEquals(mockCategory.getDepth(), insertedCategory.getDepth());
        assertEquals(mockCategory.getOrdering(), insertedCategory.getOrdering());
        assertEquals(mockCategory.isVisible(), insertedCategory.isVisible());
        mockCategory = insertedCategory;
    }

    @Test
    public void t2_findAll() {
        // init
        t1_insert();

        // test code
        List<Category> categoryList = categoryRepository.findAll();

        // verification
        assertEquals(1, categoryList.size());
    }

    @Test
    public void t3_update() {
        //init
        t1_insert();
        Category mockCategory2 = new Category();
        mockCategory2.setId(mockCategory.getId());
        mockCategory2.setName("UPDATE_NAME");
        mockCategory2.setDepth(100);
        mockCategory2.setOrdering(100);
        mockCategory2.setVisible(true);

        // test code
        Category updatedCategory = categoryRepository.save(mockCategory2);

        // verification
        assertEquals(mockCategory2.getName(), updatedCategory.getName());
        assertEquals(mockCategory2.getDepth(), updatedCategory.getDepth());
        assertEquals(mockCategory2.getOrdering(), updatedCategory.getOrdering());
        assertEquals(mockCategory2.isVisible(), updatedCategory.isVisible());
    }

    @Test
    public void t4_delete() {
        // init
        t1_insert();
        String id = mockCategory.getId();

        // test code
        categoryRepository.deleteById(id);

        // verification
        assertEquals(0, categoryRepository.count());
    }
}
